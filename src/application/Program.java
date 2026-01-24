package application;

import java.util.ArrayList;
import java.util.List;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;

public class Program {

    public static void main(String[] args) {

        List<Contribuinte> contribuintes = new ArrayList<>();

        contribuintes.add(new PessoaFisica("Alex", 50000.0, 2000.0));
        contribuintes.add(new PessoaJuridica("SoftTech", 400000.0, 25));
        contribuintes.add(new PessoaFisica("Maria", 18000.0, 1000.0));
        contribuintes.add(new PessoaJuridica("StartupX", 80000.0, 8));

        double totalImpostos = 0.0;

        for (Contribuinte c : contribuintes) {
            double imposto = c.calcularImposto();
            System.out.println(c.getNome() + " - Imposto: R$ " + String.format("%.2f", imposto));
            totalImpostos += imposto;
        }

        System.out.println("\nTOTAL DE IMPOSTOS: R$ " + String.format("%.2f", totalImpostos));
    }
}
