<%--
  User: A.Tymchenko
  Date: 27.12.2015

  View to display forms for new rent addition
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset=utf-8>
    <title>Add rent</title>
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

<form class="big-form" action="/main/rent/add-rent" method="post">
    <h3>Add Rent</h3>

    <table>
        <tbody>
        <tr>
            <td>
                <label>Address</label>
            </td>
            <td>
                <select name="address">
                    <c:forEach var="onm" items="${onmList}">
                    <option onmId="${onm.onmId}">${onm.address}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label>Contractor</label>
            </td>
            <td>
                <input type="text" name="contractor">
            </td>
        </tr>
        <tr>
            <td>
                <label>Square</label>
                <br/>
                <input type="number" name="square">
            </td>
            <td>
                <label>Rent</label>
                <br/>
                <input type="number" name="rent">
            </td>
        </tr>
        <tr>
            <td>
                <label>Start date</label>
                <br/>
                <input type="date" name="startD">
            </td>
            <td>
                <label>End date</label>
                <br/>
                <input type="date" name="endD">
            </td>
        </tr>
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

<form id="button-cancel" method="POST" action="/main">
    <input type="submit" value="Cancel">
</form>
<p>${message}</p>
</body>
</html>
