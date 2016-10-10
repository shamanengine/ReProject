<%--
  Created by IntelliJ IDEA.
  User: Raccoon
  Date: 22.12.2015
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset=utf-8>
    <title>Main</title>
    <style>
        h1,
        h3 {
            text-align: center;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        table,
        th,
        td {
            padding: 10px;
            border: 1px solid black;
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

        form table {
            width: auto;
        }

        form table td {
            border: none;
        }

        .big-form {
            width: 50%;
            margin: auto;
        }

        #button-cancel {
            margin: 20px auto;
            text-align: center;
        }

        a {
            color: black;
            text-decoration: none;
        }
    </style>
</head>

<body>
<h1>Contracts List</h1>
<table>
    <thead>
    <tr>
        <td>N</td>
        <td>Address</td>
        <td>Contractor</td>
        <td>Square</td>
        <td>Rent</td>
        <td>Start Date</td>
        <td>End Date</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="masterView" items="${masterViews}">
        <tr>
            <td>${masterView.rentId}</td>
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
            <form action="/main/rent" method="post">
                <input type="submit" value="Add Rent">
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
