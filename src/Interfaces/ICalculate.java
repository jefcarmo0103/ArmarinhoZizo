package Interfaces;

import Models.Produto;

import java.util.List;

public interface ICalculate {
    double calculaPrecoFinal(List<Produto> produtos);
}
