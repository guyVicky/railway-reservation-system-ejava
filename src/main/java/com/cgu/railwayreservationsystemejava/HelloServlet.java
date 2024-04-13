package com.cgu.railwayreservationsystemejava;

import java.io.*;
import java.sql.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public String username_check;
    public String password_check;

    private Connection conn;
    private boolean is_login = false;

    public void init() {
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (is_login) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

//    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM login";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String loginUser = req.getParameter("username");
        String loginPass = req.getParameter("password");
        while(true)
        {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
//                int id = rs.getInt("id");
                username_check = rs.getString("user");
                password_check = rs.getString("pass");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            is_login = true;
            if (username_check.equals(loginUser) && password_check.equals(loginPass)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(req, resp);
            } else {
                System.out.println("Working...");
            }

        }
        resp.sendRedirect("/failure.html");

    }

    public void destroy() {
    }
}