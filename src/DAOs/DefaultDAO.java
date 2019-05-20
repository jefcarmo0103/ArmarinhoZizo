package DAOs;

import Factory.CRUDMethods;
import Interfaces.IDAOMethods;
import Interfaces.IGetQuerys;

import java.sql.*;

public abstract class DefaultDAO implements IDAOMethods, IGetQuerys {
    protected CRUDMethods crud;

    protected DefaultDAO() {
        this.crud = new CRUDMethods();
    }

}
