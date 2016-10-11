<%--
  User: A.Tymchenko
  Date: 21.12.2015

  View to display login page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>

<body>
<h1>Please login:</h1>

<form method="POST" action="/login">
    <table>
        <tbody>
        <%-- Username --%>
        <tr>
            <td>
                <label>Username:</label>
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>

        <%-- Password --%>
        <tr>
            <td>
                <label>Password:</label>
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>

        <tr></tr>

        <tr>
            <td>
                <input type="submit" value="OK">
            </td>
            <td>
            </td>
        </tr>

        </tbody>
    </table>

</form>

<form action="/register" method="POST">
    <input type="submit" value="Register">
</form>

<p>${errorMessage}</p>
</body>
</html>
