package domain.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;
import domain.TipoContribuinte;

public class ContribuinteCSVRepository {

    private static final String ARQUIVO = "dados/contribuintes.csv";

    /* ================= SALVAR ================= */

    public void salvar(List<Contribuinte> contribuintes) {

        File arquivo = new File(ARQUIVO);
        arquivo.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {

            // Header (profissional)
            writer.write("TIPO;NOME;RENDA_ANUAL;GASTOS_SAUDE;NUM_FUNCIONARIOS");
            writer.newLine();

            for (Contribuinte c : contribuintes) {

                if (c.getTipo() == TipoContribuinte.PESSOA_FISICA) {
                    PessoaFisica pf = (PessoaFisica) c;

                    writer.write(
                        pf.getTipo() + ";" +
                        pf.getNome() + ";" +
                        pf.getRendaAnual() + ";" +
                        pf.getGastosSaude() + ";"
                    );

                } else if (c.getTipo() == TipoContribuinte.PESSOA_JURIDICA) {
                    PessoaJuridica pj = (PessoaJuridica) c;

                    writer.write(
                        pj.getTipo() + ";" +
                        pj.getNome() + ";" +
                        pj.getRendaAnual() + ";;" +
                        pj.getNumeroFuncionarios()
                    );
                }

                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar contribuintes no CSV", e);
        }
    }

    /* ================= CARREGAR ================= */

    public List<Contribuinte> carregar() {

        List<Contribuinte> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

            String linha = reader.readLine(); // pula header

            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");

                TipoContribuinte tipo = TipoContribuinte.valueOf(dados[0]);
                String nome = dados[1];
                double rendaAnual = Double.parseDouble(dados[2]);

                if (tipo == TipoContribuinte.PESSOA_FISICA) {
                    double gastosSaude = Double.parseDouble(dados[3]);
                    lista.add(new PessoaFisica(nome, rendaAnual, gastosSaude));

                } else if (tipo == TipoContribuinte.PESSOA_JURIDICA) {
                    int numFuncionarios = Integer.parseInt(dados[4]);
                    lista.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar contribuintes do CSV", e);
        }

        return lista;
    }
}
