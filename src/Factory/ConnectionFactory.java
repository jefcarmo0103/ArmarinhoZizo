package Factory;

import java.sql.*;

public class ConnectionFactory {

    private static Connection connection = null;

    public static Connection getConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zizo_Papelaria","root", "123456");
            //return DriverManager.getConnection("jdbc:mysql://localhost:8080/Zizo_Papelaria","root", "123456");

            connection.setAutoCommit(true);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

        return connection;

    }
}
