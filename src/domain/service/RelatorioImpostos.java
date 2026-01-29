package domain.service;

import java.util.List;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;

public class RelatorioImpostos {

    public void imprimir(List<Contribuinte> contribuintes) {

        System.out.println("=== RELATÓRIO DE IMPOSTOS ===");

        for (Contribuinte c : contribuintes) {

            String tipo = (c instanceof PessoaFisica) ? "Pessoa Física" : "Pessoa Jurídica";

            System.out.printf(
                "Nome: %s | Tipo: %s | Imposto: %.2f%n",
                c.getNome(),
                tipo,
                c.calcularImposto()
            );
        }

        System.out.println("============================");
    }
}

