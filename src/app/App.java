package app;
//import java.sql.*;
public class App {
    //MAIN IS ONLY FOR TESTING PURPOSES
    //Merely changing object values won't reflect in database
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        Flight ob = new Flight(2);
        //System.out.println(new Flight(2).eco_avail);
        // ob.id = 2;
        // ob.source = "some souce";
        // ob.destination = "some dest";
        // ob.eco_cost = 0;
         ob.eco_avail = 100;
         ob.updateFlight();
        // ob.first_cost = 2;
        // ob.first_avail = 3;
        // ob.business_cost = 4;
        // ob.business_avail = 5;
        // ob.time = "Time";
        // ob.addNewFlight();
        
    }
}