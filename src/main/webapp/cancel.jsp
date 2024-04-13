<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>IRCTC Cancellation</title>
    <link rel="stylesheet" type="text/css" href="cancel.css">
  </head>
  <body>
    <header>
      <a href="${pageContext.request.contextPath}/menu.jsp"><h1>IRCTC</h1></a>
    </header>
    <div class="cancel-ticket-panel">
      <h2>Cancel Ticket</h2>
      <form action="/cancelling" method="post">
        <label for="pnr">PNR:</label>
        <input type="text" id="pnr" name="pnr" required>
        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required>
        <button type="submit">Cancel Ticket</button>
      </form>
    </div>
    <footer>
        <p>&copy; 2023 2023 Indian Railway Catering and Tourism Corporation Site. All rights reserved. All rights reserved.</p>
    </footer>
  </body>
</html>

  
  