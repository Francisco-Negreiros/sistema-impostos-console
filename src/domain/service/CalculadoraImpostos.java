package domain.service;

import java.util.List;
import domain.Contribuinte;

public class CalculadoraImpostos {

    public double calcularTotal(List<Contribuinte> contribuintes) {
        double total = 0.0;

        for (Contribuinte c : contribuintes) {
            total += c.calcularImposto(); // polimorfismo aqui
        }

        return total;
    }
}
