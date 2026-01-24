package domain;

public class PessoaJuridica extends Contribuinte {

    private Integer numeroFuncionarios;

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
        double impostoBase = getRendaAnual() * 0.16;

        if (numeroFuncionarios > 10) {
            impostoBase -= impostoBase * 0.14;
        }

        return impostoBase;
    }
}
