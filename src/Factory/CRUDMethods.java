package Factory;

import Interfaces.ICRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;

public class CRUDMethods implements ICRUD {

    private Connection connection;
    private PreparedStatement smt;

    public CRUDMethods (){
        this.connection = ConnectionFactory.getConnection();
    }


    @Override
    public ArrayList<?> getAll(String sqlQuery) {
        //smt = connection.prepareStatement(sqlQuery);
        return null;

    }

    @Override
    public ArrayList<?> getById(Object objSelId, String sqlQuery) {
        return null;
    }

    @Override
    public void Add(Object objAdd, String sqlQuery) {

    }

    @Override
    public void Delete(Object objDel, String sqlQuery) {

    }

    @Override
    public void Update(Object objAdd, String sqlQuery) {

    }

    private void ExecuteQuery(Dictionary<Integer, Object> params, String sql){
        try{
            smt= connection.prepareStatement(sql);
            smt = setParameters(params);
            smt.execute();
            smt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    private PreparedStatement setParameters(Dictionary<Integer, Object> params){

        try{
            for(int i = 1; i < params.size(); i++){

                Object o = params.get(i);

                if(o instanceof Calendar){
                    Calendar cl = (Calendar)o;
                    Date data = new Date(cl.getTimeInMillis());
                    smt.setDate(i,data);
                }

                else if (o instanceof Double)
                    smt.setDouble(i,(Double)o);

                else if (o instanceof  String)
                    smt.setString(i,(String)o);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return smt;
    }

}
