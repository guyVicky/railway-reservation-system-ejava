package com.cgu.railwayreservationsystemejava;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listing", value = "/listing")
public class listing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PassengerTicket> list=null;
        list = TicketModel.getAllTickets();
        System.out.println(list.size());

        if(list==null || list.size()==0){
            System.out.println("Something wrong occurred...");
        }

        request.setAttribute("tickets", list);
        request.getRequestDispatcher("./list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}