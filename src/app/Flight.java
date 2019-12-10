package app;
import java.sql.*;
public class Flight {
    int id;
    String source;
    String destination;
    int eco_cost;
    int eco_avail;
    int first_cost;
    int first_avail;
    int business_cost;
    int business_avail;
    String time;
    public Flight() //default
    {
        id = 0;
        source = "";
        destination = "";
        eco_cost = 0;
        eco_avail = 0;
        first_cost = 0;
        first_avail = 0;
        business_cost = 0;
        business_avail = 0;
        time = "";
    }
    // To load a Flight from database
    public Flight(int id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = Conn.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from flight WHERE flight_id = " + id);
            if (rs.next()) {
                this.id = id;
                this.source = rs.getString(2);
                this.destination = rs.getString(3);
                this.eco_cost = rs.getInt(4);
                this.eco_avail = rs.getInt(5);
                this.first_cost = rs.getInt(6);
                this.first_avail = rs.getInt(7);
                this.business_cost = rs.getInt(8);
                this.business_avail = rs.getInt(9);
                this.time = rs.getString(10);
                
                System.out.println(this.id);
                System.out.println(this.source);
                System.out.println(this.destination);
                System.out.println(this.eco_cost);
                System.out.println(this.eco_avail);
                System.out.println(this.first_cost);
                System.out.println(this.first_avail);
                System.out.println(this.business_cost);
                System.out.println(this.business_avail);
                System.out.println(this.time);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // To add a new Flight to the database, will take object values for updation,
    //BE SURE TO SET ALL VALUES BEFORE YOU FIRE THIS FUNCTION using constructor or accessing object values individually
    public void addNewFlight() {
        try {
            Connection con = Conn.getConnection();
            PreparedStatement stat = con.prepareStatement("insert into Flight values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stat.setInt(1, this.id);
            stat.setString(2, this.source);
            stat.setString(3, this.destination);
            stat.setInt(4, this.eco_cost);
            stat.setInt(5, this.eco_avail);
            stat.setInt(6, this.first_cost);
            stat.setInt(7, this.first_avail);
            stat.setInt(8, this.business_cost);
            stat.setInt(9, this.business_avail);
            stat.setString(10, this.time);
            stat.executeUpdate();
            System.out.println("Inserted id " + id);
            //executeupdate -used for doing dml (insert,delete,update)
            con.close();
        } catch (Exception m) {
            System.out.println(m.getMessage());
        }
    }
    //To update existing records of a Flight, will take object values for updation
    //Donot fire unless you are sure of changes. 
    public void updateFlight() {
        try {
            
            Connection con = Conn.getConnection();
            PreparedStatement stat = con.prepareStatement("UPDATE flight set eco_cost = ?, eco_avail = ?, first_cost = ?, first_avail = ?, business_cost = ?, business_avail = ? WHERE flight_id = "+this.id);

            stat.setInt(1, this.eco_cost);
            stat.setInt(2, this.eco_avail);
            stat.setInt(3, this.first_cost);
            stat.setInt(4, this.first_avail);
            stat.setInt(5, this.business_cost);
            stat.setInt(6, this.business_avail);
            stat.executeUpdate();
            System.out.println("Updated id " + id);
            con.close();
        } catch (Exception m) {
            System.out.println(m.getMessage());
        }
    }
}