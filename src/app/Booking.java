package app;
import java.sql.*;

public class Booking
{
    Customer customer;
    Flight flight;
    int booking_id;
    String clas;
    int no_of_tickets;
    String datetime_of_flight;
    String time_of_booking;
    Booking(Flight flight,Customer customer,String clas,int no_of_tickets)
    {   
        this.no_of_tickets = no_of_tickets;
        this.clas = clas;
        datetime_of_flight = "";
        time_of_booking = "";
        this.customer = customer;
        this.flight = flight;
    }
    public void confirmBooking()
    {
        boolean check = true;
        if(clas == "ECONOMY")
        {
            if(flight.eco_avail<no_of_tickets)
            {
                check = false;    
            }
            else
            {
                flight.eco_avail = flight.eco_avail - no_of_tickets;
            }
            
        }
        else if(clas == "FIRST")
        {
            if(flight.first_avail<no_of_tickets)
            {
                check = false;    
            }
            else
            {
                flight.first_avail = flight.first_avail - no_of_tickets;
            }
        }
        else if(clas == "BUSINESS")
        {
            if(flight.business_avail<no_of_tickets)
            {
                check = false;    
            }
            else
            {
                flight.business_avail = flight.business_avail - no_of_tickets;
            }
        }
        if(check)
        {
            flight.updateFlight();
            try {
                Connection con = Conn.getConnection();
                PreparedStatement stat = con.prepareStatement("insert into book(book_username, flight_id, class, no_of_tickets, datetime_of_flight, time_of_booking) values (?, ?, ?, ?, ?, ?)");
    
                stat.setString(1, customer.username);
                stat.setInt(2, flight.id);
                stat.setString(3, clas);
                stat.setInt(4, no_of_tickets);
                stat.setString(5, datetime_of_flight);
                stat.setString(6, time_of_booking);
                stat.executeUpdate();
                System.out.println("Booked for " + customer.username);
                //executeupdate -used for doing dml (insert,delete,update)
                con.close();
            } catch (Exception m) {
                System.out.println(m.getMessage());
            }
        }
        else
        {
            System.out.println("Not enough Available");
        }
    }
}