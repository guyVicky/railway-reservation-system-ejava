package com.cgu.railwayreservationsystemejava;

import java.io.*;
import java.sql.*;
import java.util.Random;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.Math.abs;


@WebServlet(name = "booking", value = "/booking")
public class booking extends HttpServlet {

    private Random rand;
    private Connection conn;

    public void init()
    {
        rand = new Random();

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

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/boook.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PassengerTicket pst = new PassengerTicket();
        pst.setId(abs(rand.nextInt()));
        pst.setTrain_name(request.getParameter("train_name"));
        pst.setFrom_station(request.getParameter("from"));
        pst.setTo_station(request.getParameter("to"));
        pst.setDate_travel(request.getParameter("date"));
        pst.setCoach_class(request.getParameter("class"));
        pst.setNum_passengers(request.getParameter("num_passengers"));
        pst.setPassenger_name(request.getParameter("name"));
        pst.setPassenger_email(request.getParameter("email"));
        pst.setPassenger_phone(request.getParameter("phone"));

        try {
            String insertQuery = "INSERT INTO tickets_irctc (id, train_name, from_station, to_station, date_travel, coach_class, passenger_num, passenger_name, passenger_email, passenger_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setInt(1, pst.getId());
            preparedStatement.setString(2, pst.getTrain_name());
            preparedStatement.setString(3, pst.getFrom_station());
            preparedStatement.setString(4, pst.getTo_station());
            preparedStatement.setString(5, pst.getDate_travel());
            preparedStatement.setString(6, pst.getCoach_class());
            preparedStatement.setString(7, pst.getNum_passengers());
            preparedStatement.setString(8, pst.getPassenger_name());
            preparedStatement.setString(9, pst.getPassenger_email());
            preparedStatement.setString(10, pst.getPassenger_phone());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Entry successful");
                List<String> pnr = List.of(new String[]{Integer.toString(pst.getId())});
                request.setAttribute("pnr", pnr);
                request.getRequestDispatcher("./added.jsp").forward(request, response);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}