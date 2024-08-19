package Controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    
    private Connection connection;
    private Statement st;

    public DatabaseConnection() {

    }

    public static Connection connectToDatabase()throws SQLException{
        Connection connection = null;
        try 
        {
            String server = "localhost";
            String port = "3306";
            String database = "my_db";
            String userName = "root";
            String password = "";

            connection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, userName, password);            
            System.err.println("Excelent conection");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return connection;
    }

    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }
}