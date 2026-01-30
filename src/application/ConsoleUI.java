package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Contribuinte;
import domain.PessoaFisica;
import domain.PessoaJuridica;
import domain.service.CalculadoraImpostos;
import domain.service.RelatorioImpostos;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);
    private List<Contribuinte> contribuintes = new ArrayList<>();

    private CalculadoraImpostos calculadora = new CalculadoraImpostos();
    private RelatorioImpostos relatorio = new RelatorioImpostos();

    public void iniciar() {
        int opcao;

        do {
            mostrarMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }
    
    private void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("      SISTEMA DE IMPOSTOS");
        System.out.println("==============================");
        System.out.println("1 - Cadastrar Pessoa Física");
        System.out.println("2 - Cadastrar Pessoa Jurídica");
        System.out.println("3 - Listar Contribuintes");
        System.out.println("4 - Calcular Impostos");
        System.out.println("0 - Sair");
    }

    private int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // consome ENTER
        return opcao;
    }
    

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarPessoaFisica();
                break;
            case 2:
            	cadastrarPessoaJuridica();
                break;
            case 3:
                if (contribuintes.isEmpty()) {
                    System.out.println("Nenhum contribuinte cadastrado.");
                } else {
                    relatorio.imprimir(contribuintes);
                }
                break;
            case 4:
            	if (contribuintes.isEmpty()) {
                    System.out.println("Nenhum contribuinte cadastrado.");
                } else {
                    double total = calculadora.calcularTotal(contribuintes);
                    System.out.printf("Total de impostos: %.2f%n", total);
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    
    private void cadastrarPessoaFisica() {
        System.out.println("\n=== Cadastro de Pessoa Física ===");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Renda anual: ");
            double rendaAnual = scanner.nextDouble();

            System.out.print("Gastos com saúde: ");
            double gastosSaude = scanner.nextDouble();

            Contribuinte pf = new PessoaFisica(nome, rendaAnual, gastosSaude);
            contribuintes.add(pf);

            System.out.println("Pessoa Física cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Pessoa Física: " + e.getMessage());
            scanner.nextLine(); // evita loop quebrado
        }
    }
    
    private void cadastrarPessoaJuridica() {
        System.out.println("\n=== Cadastro de Pessoa Jurídica ===");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Renda anual: ");
            double rendaAnual = scanner.nextDouble();

            System.out.print("Número de Funcionários: ");
            int numeroFuncionarios = scanner.nextInt();

            Contribuinte pj = new PessoaJuridica(nome, rendaAnual, numeroFuncionarios);
            contribuintes.add(pj);

            System.out.println("Pessoa Jurídica cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Pessoa Jurídica: " + e.getMessage());
            scanner.nextLine(); // evita loop quebrado
        }
    }

}

