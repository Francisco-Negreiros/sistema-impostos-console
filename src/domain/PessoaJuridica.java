package domain;

import domain.exception.DadosInvalidosException;

public class PessoaJuridica extends Contribuinte {

    private Integer numeroFuncionarios;
    private static final double ALIQUOTA = 0.16;
    private static final double DESCONTO_FUNCIONARIOS = 0.14;

    
    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        
        if (numeroFuncionarios == null || numeroFuncionarios < 0) {
            throw new DadosInvalidosException("Número de funcionários inválido");
        }
        
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
    	double impostoBase = getRendaAnual() * ALIQUOTA;

    	if (numeroFuncionarios > 10) {
    	    impostoBase -= impostoBase * DESCONTO_FUNCIONARIOS;
    	}
       
        return impostoBase;
    }
}
