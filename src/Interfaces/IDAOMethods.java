package Interfaces;

import Models.DefaultModel;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public interface IDAOMethods <T extends Integer, U> {
    void Adiciona(DefaultModel model);
    void Altera(DefaultModel model);
    void Exclui(DefaultModel model);
    Dictionary<T,U> getParameters(DefaultModel model);
}
