package domain;

public class PessoaJuridica extends Contribuinte {

    private int numeroFuncionarios;

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual, TipoContribuinte.PESSOA_JURIDICA);

        if (numeroFuncionarios < 0) {
            throw new IllegalArgumentException("Número de funcionários não pode ser negativo");
        }

        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
        double imposto = getRendaAnual() * 0.16;

        if (numeroFuncionarios > 10) {
            imposto -= imposto * 0.14;
        }

        return imposto;
    }
}
