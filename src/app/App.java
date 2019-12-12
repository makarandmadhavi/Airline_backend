package app;
//import java.sql.*;
public class App {
    //MAIN IS ONLY FOR TESTING PURPOSES
    //Refer Conn.java for database connection
    //Merely changing object values won't reflect in database
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        Customer customer = new Customer("makjets");
        Flight flight = new Flight(1);
        Booking b = new Booking(flight, customer, "BUSINESS", 2);
        //Class can be "ECONOMY" "FIRST" "BUSINESS"
        b.confirmBooking();
        
    }
}