package domain;
import domain.exception.DadosInvalidosException;

public class PessoaFisica extends Contribuinte {

    private Double gastosSaude;

    public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {

    	super(nome, rendaAnual);

        if (gastosComSaude < 0) {
            throw new DadosInvalidosException("Gastos com saúde não podem ser negativos");
        }
        this.gastosSaude = gastosComSaude;
    }
    
    public Double getGastosSaude() {
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

        if (impostoBase < 0) {
            impostoBase = 0;
        }

        return impostoBase;
    }
    
    
}
