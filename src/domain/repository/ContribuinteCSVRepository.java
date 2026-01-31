package domain.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;

public class ContribuinteCSVRepository {

    private static final String ARQUIVO = "dados/contribuintes.csv";

    public void salvar(List<Contribuinte> lista) {

        File arquivo = new File(ARQUIVO);
        arquivo.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
        	
        	writer.write("tipo;nome;renda;extra");
        	writer.newLine();

            for (Contribuinte c : lista) {

                if (c instanceof PessoaFisica pf) {
                    writer.write("PF;" + pf.getNome() + ";" +
                                 pf.getRendaAnual() + ";" +
                                 pf.getGastosSaude());
                } else if (c instanceof PessoaJuridica pj) {
                    writer.write("PJ;" + pj.getNome() + ";" +
                                 pj.getRendaAnual() + ";" +
                                 pj.getNumeroFuncionarios());
                }

                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar CSV", e);
        }
    }

    public List<Contribuinte> carregar() {

        List<Contribuinte> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        	
        	reader.readLine(); // ignora header

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");

                String tipo = dados[0];
                String nome = dados[1];
                double renda = Double.parseDouble(dados[2]);

                if (tipo.equals("PF")) {
                    double gastos = Double.parseDouble(dados[3]);
                    lista.add(new PessoaFisica(nome, renda, gastos));

                } else if (tipo.equals("PJ")) {
                    int funcionarios = Integer.parseInt(dados[3]);
                    lista.add(new PessoaJuridica(nome, renda, funcionarios));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar CSV", e);
        }

        return lista;
    }


}
