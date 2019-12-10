package app;
import java.sql.*;
public class Conn{

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}