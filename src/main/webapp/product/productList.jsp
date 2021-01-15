<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 1/15/2021
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>
<center>
    <h1> Product Management</h1>
    <h2>
        <a href="">Add New User</a>
    </h2>
    <div>
        <form action="/products" method="get">
            <input type="text" name="Search" placeholder="Name product">
            <input type="submit" value="Search">
        </form>
    </div>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List product</h2></caption>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th> Price  </th>
            <th>Quantity</th>
            <th>Color   </th>
            <th>Category</th>
            <th>Action  </th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.nameProduct}"/></td>
                <td><c:out value="${product.priceProduct}"/></td>
                <td><c:out value="${product.quantityProduct}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.idCategory}"/></td>
                <td>
                    <a href="/products?action=edit?id=${product.id}">Edit</a>
                    <a href="/products?action=delete?id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
