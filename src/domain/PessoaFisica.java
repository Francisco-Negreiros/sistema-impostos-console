package domain;

public class PessoaFisica extends Contribuinte {

    private double gastosSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual, TipoContribuinte.PESSOA_FISICA);

        if (gastosSaude < 0) {
            throw new IllegalArgumentException("Gastos com saúde não podem ser negativos");
        }

        this.gastosSaude = gastosSaude;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    @Override
    public double calcularImposto() {
        double impostoBase;

        if (getRendaAnual() < 20000.0) {
            impostoBase = getRendaAnual() * 0.15;
        } else {
            impostoBase = getRendaAnual() * 0.25;
        }

        impostoBase -= gastosSaude * 0.5;

        return Math.max(impostoBase, 0);
    }
}
