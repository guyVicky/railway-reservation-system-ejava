<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% List<String> pnr; %>
<!DOCTYPE html>
<html>
  <head>
    <title>IRCTC</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="menu.css">
  </head>
  <body>
    <header>
      <h1>IRCTC Booking Portal</h1>
    </header>
    <main>
      <% pnr = (List<String>) request.getAttribute("pnr");%>
    	<h2>Entry added to Database !</h2>
        <h5>Your pnr is <%= pnr.get(0)%></h5>
    	<a href="${pageContext.request.contextPath}/booking" id="added_link"><< Add another</a>
    </main>
    <footer>
      <p>&copy; 2023 Indian Railway Catering and Tourism Corporation Site. All rights reserved.</p>
    </footer>
  </body>
</html>
