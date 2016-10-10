<%--
  Created by IntelliJ IDEA.
  User: Raccoon
  Date: 22.12.2015
  Time: 23:17
  To change this template use File | Settings | File Templates.
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

        .table-buttons,
        .table-buttons tr,
        .table-buttons td {
            border: none;
            width: auto;
        }

        .table-buttons {
            margin: 20px auto 50px auto;
        }
    </style>
</head>

<body>
<h1>Welcome, admin</h1>
<table>
    <thead>
    <tr>
        <th>№</th>
        <th>Filia</th>
        <th>User</th>
        <th>Address</th>
        <th>Contractor</th>
        <th>Square</th>
        <th>Rent</th>
        <th>Start Date</th>
        <th>End Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="masterView" items="${masterViews}">
        <tr>
            <td>${masterView.rentId}</td>
            <td>${masterView.title}</td>
            <td>${masterView.username}</td>
            <td>${masterView.address}</td>
            <td>${masterView.contractor}</td>
            <td>${masterView.square}</td>
            <td>${masterView.rent}</td>
            <td>${masterView.startD}</td>
            <td>${masterView.endD}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<table class="table-buttons">
    <tbody>
    <tr>
        <td>
            <form action="/admin/all-users" method="post">
                <input type="submit" value="All Users">
            </form>
        </td>
        <td>
            <form action="/logout" method="post">
                <input type="submit" value="Logout">
            </form>
        </td>
    </tr>
    </tbody>
</table>
</body>

</html>
