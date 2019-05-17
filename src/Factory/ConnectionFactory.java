package Factory;

import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://","root", "123456");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
