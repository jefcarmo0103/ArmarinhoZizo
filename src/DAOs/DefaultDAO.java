package DAOs;

import Factory.CRUDMethods;
import Interfaces.IDAOMethods;
import Interfaces.IGetQuerys;
import javafx.collections.ObservableList;

import java.sql.*;

public abstract class DefaultDAO<T> implements IDAOMethods, IGetQuerys {
    protected CRUDMethods crud;

    protected DefaultDAO() {
        this.crud = new CRUDMethods();
    }

    protected ObservableList<T> MapperDAO(){
        return null;
    }

}
