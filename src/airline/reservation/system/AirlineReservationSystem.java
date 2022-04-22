/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.reservation.system;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.sqlite.JDBC;

/**
 *
 * @author aliar
 */
public class AirlineReservationSystem {

    /**
     * @param args the command line arguments
     */
    
    public static Statement statement = null; // For ease of use
    public static Connection connection;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new LoaderPage().setVisible(true);
        connect();
    }
    
    public static void connect() {
        File dbFile = new File("airlineDB.db");
        boolean dbCreated = dbFile.exists();
        System.out.println("dbFile exists: " + dbCreated);
        try {
            java.sql.DriverManager.registerDriver(new JDBC());
            connection = DriverManager.getConnection("jdbc:sqlite:airlineDB.db");
            statement = connection.createStatement();
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println("Error connecting to database");
            System.out.println("Error:" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}
