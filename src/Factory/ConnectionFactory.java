package Factory;

import java.sql.*;

public abstract class ConnectionFactory {

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/PapelariaZizo","root", "123456");
            //return DriverManager.getConnection("jdbc:mysql://localhost:8080/PapelariaZizo","root", "123456");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
