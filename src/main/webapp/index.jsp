<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>IRCTC Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
</head>
<body>
<header>
    <h1>IRCTC Ticket Counter</h1>
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">About Us</a></li>
            <li><a href="#">Contact Us</a></li>
        </ul>
    </nav>
</header>
<main>
    <section>
        <h2>Admin Login</h2>
        <form action="${pageContext.request.contextPath}/hello-servlet" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <button type="submit">Login</button>
        </form>
    </section>
</main>
<footer>
    <p>&copy; 2023 Indian Railway Catering and Tourism Corporation Site. All rights reserved.</p>
</footer>
</body>
</html>
