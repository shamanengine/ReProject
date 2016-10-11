<%--
  User: A.Tymchenko
  Date: 22.12.2015

  View to distlay all users
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>All Users</title>
    <style>
        h1 {
            text-align: center;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }

        table,
        th,
        td {
            border: 1px solid black;
        }

        form {
            margin-top: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }
    </style>
</head>

<body>
<h1>All Users</h1>
<table>
    <thead>
    <tr>
        <th>№</th>
        <th>Role</th>
        <th>Active</th>
        <th>Filia</th>
        <th>Username</th>
        <th>Email</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}"> <%--${users} - as in command--%>
        <tr>
            <td>${user.userId}</td>
            <td>${user.role}</td>
            <td>${user.active}</td>
            <td>${user.filia}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>
                <form action="/admin/all-users/change-status" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="submit" value="${user.active ? 'Deactivate' : 'Activate'}">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form id="button-ok" method="POST" action="/admin">
    <input type="submit" value="OK">
</form>
</body>

</html>
