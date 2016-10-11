<%--
  User: A.Tymchenko
  Date: 22.12.2015

  View to display new user registartion page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>

<body>
<h1>Please register:</h1>

<form method="POST" action="/register/add-user">
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

        <%-- email --%>
        <tr>
            <td>
                <label>Email:</label>
            </td>
            <td>
                <input type="email" name="email">
            </td>
        </tr>

        <%-- filia --%>
        <tr>
            <td>
                <label>Filia:</label>
            </td>
            <td>
                <select name="filia">
                    <c:forEach var="filia" items="${filias}">
                        <option filiaId="${filia.filiaId}">${filia.title}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <%-- OK-button --%>
        <tr></tr>
        <tr>
            <td>
                <input type="submit" value="OK">
            </td>
        </tr>
        </tbody>
    </table>
</form>

<form method="POST" action="/">
    <input type="submit" value="Cancel">
</form>

<p>${errorMessage}</p>
</body>
</html>
