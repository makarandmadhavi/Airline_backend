package app;
import java.sql.*;
public class Conn{
    // This works like php connection.php file we make
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Change database path according to your xampp configuration
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}