package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Contribuinte;
import domain.service.CalculadoraImpostos;
import domain.service.RelatorioImpostos;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);
    private List<Contribuinte> contribuintes = new ArrayList<>();
    private CalculadoraImpostos calculadora = new CalculadoraImpostos();
    private RelatorioImpostos relatorio = new RelatorioImpostos();

    public void iniciar() {
        System.out.println("=== SISTEMA DE IMPOSTOS ===");
    }
}





























































/*package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);
    private List<Contribuinte> contribuintes = new ArrayList<>();

    public void iniciar() {
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarPessoaFisica();
                    break;
                case 2:
                    cadastrarPessoaJuridica();
                    break;
                case 3:
                    listarImpostos();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
    
    private void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE IMPOSTOS ===");
        System.out.println("1 - Cadastrar Pessoa Física");
        System.out.println("2 - Cadastrar Pessoa Jurídica");
        System.out.println("3 - Listar impostos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void cadastrarPessoaFisica() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Renda anual: ");
        double renda = scanner.nextDouble();

        System.out.print("Gastos com saúde: ");
        double gastosSaude = scanner.nextDouble();
        scanner.nextLine();

        Contribuinte pf = new PessoaFisica(nome, renda, gastosSaude);
        contribuintes.add(pf);

        System.out.println("✅ Pessoa Física cadastrada!");
    }

    private void cadastrarPessoaJuridica() {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Renda anual: ");
        double renda = scanner.nextDouble();

        System.out.print("Número de funcionários: ");
        int funcionarios = scanner.nextInt();
        scanner.nextLine();

        Contribuinte pj = new PessoaJuridica(nome, renda, funcionarios);
        contribuintes.add(pj);

        System.out.println("✅ Pessoa Jurídica cadastrada!");
    }

    private void listarImpostos() {

        if (contribuintes.isEmpty()) {
            System.out.println("Nenhum contribuinte cadastrado.");
            return;
        }

        double total = 0.0;

        System.out.println("\n--- IMPOSTOS ---");
        for (Contribuinte c : contribuintes) {
            double imposto = c.calcularImposto();
            System.out.println(c.getNome() + " - R$ " + String.format("%.2f", imposto));
            total += imposto;
        }

        System.out.println("\nTOTAL DE IMPOSTOS: R$ " + String.format("%.2f", total));
    }
}*/
