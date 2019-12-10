package app;
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        Customer ob = new Customer("ma1512kjets");
        //ob.updateCustomer();
        //insert1 ob = new insert1();
        // Connection con = null; //USED FOR DOING CONNECTION
        // Statement stmt = null; //USED FOR RUNNING COMMAND
        // ResultSet rs = null; //USED FOR STORING THE RECORDS WHICH COMES FROM TABLE
        // System.out.println("Hello");
        // try {
        //     // Establish the connection.  
        //     Class.forName("com.mysql.jdbc.Driver");
        //     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasql", "root", "");
        //     stmt = con.createStatement();
        //     // boolean r = stmt.execute("INSERT INTO employee VALUES(3,'Nikhil','Nerul')");

        //     // System.out.println("RS "+r);
        //     // Create and execute an SQL statement that returns some data.  
        //     stmt = con.createStatement();
        //     rs = stmt.executeQuery("select NAME,ID,ADDRESS from employee");

        //     // Iterate through the data in the result set and display it.  
        //     while (rs.next()) {
        //         System.out.println(rs.getString(1) + "  " + rs.getString(3) + " " + rs.getString(2));
        //     }
        // } // Handle any errors that may have occurred.  
        // catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
    }
}