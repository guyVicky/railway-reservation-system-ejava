<%@ page import="com.cgu.railwayreservationsystemejava.PassengerTicket" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Booked Train Tickets</title>
    <link rel="stylesheet" type="text/css" href="list.css">
  </head>
  <body>
    <header>
      <a href="${pageContext.request.contextPath}/menu.jsp"><h1>IRCTC</h1></a>
    </header>
    <table border="0" style="width: 100%;">
      <thead>
      <tr>
        <th>PNR</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date</th>
        <th>Journey</th>
        <th>Train</th>
        <th>Class</th>
      </tr>
      </thead>
      <tbody>
      <% List<PassengerTicket> tickets = (List<PassengerTicket>) request.getAttribute("tickets"); %>
      <% for (PassengerTicket ticket : tickets) {%>
        <tr>
          <td><%= ticket.getId() %></td>
          <td><%= ticket.getPassenger_name()%></td>
          <td><%= ticket.getPassenger_email()%></td>
          <td><%= ticket.getDate_travel()%></td>
          <td><%= ticket.getFrom_station()%> → <%= ticket.getTo_station()%> </td>
          <td><%= ticket.getTrain_name()%></td>
          <td><%= ticket.getCoach_class()%></td>
        </tr>
      <% } %>
      </tbody>
    </table>
    <footer>
        <p>&copy; 2023 2023 Indian Railway Catering and Tourism Corporation Site. All rights reserved. All rights reserved.</p>
    </footer>
  </body>
</html>
