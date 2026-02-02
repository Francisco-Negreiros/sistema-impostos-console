package domain;

public abstract class Contribuinte {

    private String nome;
    private double rendaAnual;
    private TipoContribuinte tipo;

    protected Contribuinte(String nome, double rendaAnual, TipoContribuinte tipo) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (rendaAnual < 0) {
            throw new IllegalArgumentException("Renda anual não pode ser negativa");
        }

        this.nome = nome;
        this.rendaAnual = rendaAnual;
        this.tipo = tipo;
    } 
 
    public TipoContribuinte getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public abstract double calcularImposto();
       
}



