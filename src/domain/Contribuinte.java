package domain;

import domain.exception.DadosInvalidosException;

public abstract class Contribuinte {

    private String nome;
    private double rendaAnual;

    public Contribuinte(String nome, double rendaAnual) {
        this.nome = nome;
         
        if (rendaAnual < 0) {
        	throw new DadosInvalidosException("Renda anual não pode ser negativa");
        }
        
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public abstract double calcularImposto();
}

