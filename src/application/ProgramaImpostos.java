package application;

import java.util.ArrayList;
import java.util.List;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;
import domain.service.CalculadoraImpostos;
import domain.service.RelatorioImpostos;

public class ProgramaImpostos {

    public static void main(String[] args) {
    	
    	RelatorioImpostos relatorio = new RelatorioImpostos();
    	
        List<Contribuinte> contribuintes = new ArrayList<>();

        contribuintes.add(new PessoaFisica("Maria", 50000.0, 2000.0));
        contribuintes.add(new PessoaJuridica("Empresa X", 400000.0, 25));
        contribuintes.add(new PessoaFisica("João", 30000.0, 1000.0));

        CalculadoraImpostos calculadora = new CalculadoraImpostos();

        double totalImpostos = calculadora.calcularTotal(contribuintes);
        
        relatorio.imprimir(contribuintes);
        
        System.out.printf("Total de impostos: R$ %.2f%n", totalImpostos);
    }
}

