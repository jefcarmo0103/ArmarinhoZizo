package Factory;

import Interfaces.ICRUD;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CRUDMethods implements ICRUD {

    private Connection connection;
    private PreparedStatement smt;

    public CRUDMethods (){
        this.connection = ConnectionFactory.getConnection();
    }


    @Override
    public Map<?,?> getAll(String sqlQuery) {

        ResultSet rs = ExecutaSQL(null,sqlQuery);
        Map<String,Object> result = makeMap(rs);

        return result;
    }

    @Override
    public Map<?,?> getById(Object objSelId, String sqlQuery) {

        Map<Integer, Object> parameters = (Map<Integer, Object>)objSelId;

        ResultSet rs = ExecutaSQL(parameters,sqlQuery);
        Map<String,Object> result = makeMap(rs);

        return result;

    }

    @Override
    public void Add(Object objAdd, String sqlQuery) {
        Map<Integer, Object> parameters = (Map<Integer, Object>)objAdd;
        ExecuteQuery(parameters, sqlQuery);

    }

    @Override
    public void Delete(Object objDel, String sqlQuery) {
        Map<Integer, Object> parameters = (Map<Integer, Object>)objDel;
        ExecuteQuery(parameters, sqlQuery);
    }

    @Override
    public void Update(Object objUpd, String sqlQuery) {
        Map<Integer, Object> parameters = (Map<Integer, Object>)objUpd;
        ExecuteQuery(parameters, sqlQuery);
    }

    private Map<String, Object> makeMap(ResultSet rs){

        Map<String,Object> result = new HashMap<>();
        try{
            List<String> columnNames = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnNames.add(rsmd.getColumnLabel(i));
            }

            int rowIndex = 0;
            while (rs.next()) {
                rowIndex++;

                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }

                System.out.printf("Row %d%n", rowIndex);
                for (int colIndex = 0; colIndex < rsmd.getColumnCount(); colIndex++) {
                    String objType = "null";
                    String objString = "";
                    Object columnObject = rowData.get(colIndex);
                    if (columnObject != null) {
                        objString = columnObject.toString() + " ";
                        objType = columnObject.getClass().getName();
                    }
                    System.out.printf("  %s: %s(%s)%n",
                            columnNames.get(colIndex), objString, objType);

                    result.put(columnNames.get(colIndex) + result.size(), objString);
                }
            }

            rs.close();
            smt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }



        return result;
    }

    private void ExecuteQuery(Map<Integer, Object> params, String sql){
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

    private ResultSet ExecutaSQL (Map<Integer, Object> params, String sql){
        ResultSet rs = null;

        try{
            smt = connection.prepareStatement(sql);

            if(params != null)
                smt = setParameters(params);

            rs = smt.executeQuery();

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

        return rs;
    }



    private PreparedStatement setParameters(Map<Integer, Object> params){

        try{
            for(int i = 1; i <= params.size(); i++){

                Object o = params.get(i);

                if(o instanceof Date){
                    Date cl = (Date) o;
                    //Date data = new Date(cl.getTimeInMillis());
                    smt.setDate(i,cl);
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
