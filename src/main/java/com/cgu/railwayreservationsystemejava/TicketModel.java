package com.cgu.railwayreservationsystemejava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketModel {

    public static List<PassengerTicket> getAllTickets() {
        ArrayList list = new ArrayList();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/product_ejava"; // Replace with your database URL
            String USER = "root"; // Replace with your database username
            String PASSWORD = "Naksha3a!"; // Replace with your database password
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load Driver class");
            System.exit(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement("Select * from tickets_irctc");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PassengerTicket pst = new PassengerTicket();
                pst.setId(rs.getInt("id"));
                pst.setTrain_name(rs.getString(2));
                pst.setFrom_station(rs.getString(3));
                pst.setTo_station(rs.getString(4));
                pst.setDate_travel(rs.getString(5));
                pst.setCoach_class(rs.getString(6));
                pst.setNum_passengers(rs.getString(7));
                pst.setPassenger_name(rs.getString(8));
                pst.setPassenger_email(rs.getString(9));
                pst.setPassenger_phone(rs.getString(10));
                list.add(pst);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }

        return list;
    }
}
