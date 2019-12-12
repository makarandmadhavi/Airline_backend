package app;
import java.sql.*;
public class Customer {
    String username;
    String name;
    String address;
    String phone;
    String email;
    public Customer() //default
    {
        username = "";
        name = "";
        address = "";
        phone = "";
        email = "";
    }
    // To load a customer from database
    public Customer(String username) {
        Connection con = null; 
        Statement stmt = null; 
        ResultSet rs = null;
        try { 
            
            con = Conn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Customer WHERE cust_username = '"+username+"'");
           if(rs.next()) {
                this.username = username;
                this.name = rs.getString(2);
                this.address = rs.getString(3);
                this.phone = rs.getString(4);
                this.email = rs.getString(5);
                System.out.println(this.username+" "+this.name+" "+this.address+" "+this.phone+" "+this.email);
            }
            con.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // To create a new customer
    public Customer(String username, String name, String address, String phone, String email) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    // To add a new customer to the database, will take object values for updation,
    //BE SURE TO SET ALL VALUES BEFORE YOU FIRE THIS FUNCTION using constructor or accessing object values individually
    public void addNewCustomer() {
        
        try {
            Connection con = Conn.getConnection();
            PreparedStatement stat = con.prepareStatement("insert into customer values (?, ?, ?, ?, ?)");

            stat.setString(1, username);
            stat.setString(2, name);
            stat.setString(3, address);
            stat.setString(4, phone);
            stat.setString(5, email);
            stat.executeUpdate();
            System.out.println("Inserted id " + username);
            //executeupdate -used for doing dml (insert,delete,update)
            con.close();
        } catch (Exception m) {
            System.out.println(m.getMessage());
        }
    }
    //To update existing records of a customer, will take object values for updation
    //Donot fire unless logged in.
    public void updateCustomer() {
        try {
            Connection con = Conn.getConnection();
            PreparedStatement stat = con.prepareStatement("UPDATE customer set name = ?, address = ?, phone = ?, email = ? WHERE cust_username = ?");

            stat.setString(5, username);
            stat.setString(1, name);
            stat.setString(2, address);
            stat.setString(3, phone);
            stat.setString(4, email);
            stat.executeUpdate();
            System.out.println("Updated id " + username);
            con.close();
        } catch (Exception m) {
            System.out.println(m.getMessage());
        }
    }
}