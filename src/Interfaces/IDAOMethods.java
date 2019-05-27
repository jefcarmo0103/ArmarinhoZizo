package Interfaces;

import Models.DefaultModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public interface IDAOMethods <T extends Integer, U> {
    void Adiciona(DefaultModel model);
    void Altera(DefaultModel model);
    void Exclui(DefaultModel model);
    ArrayList<U> SelecionarTodos() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, ParseException;
    Map<T,U> getParameters(DefaultModel model);
}
