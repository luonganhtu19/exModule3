<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 1/15/2021
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>

<center>
    <h1>User Management</h1>
    <h2>
        <a href="/products">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
                <c:if test="${message!=null}">
                    <c:out value="${message}"/>
                </c:if>
            </caption>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Price:</th>
                <td>
                    <input type="text" name="Price" id="Price" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Quantity:</th>
                <td>
                    <input type="text" name="Quantity" id="Quantity" size="15"/>
                </td>
            </tr>
            <tr>
                <th> Color:</th>
                <td>
                    <input type="text" name="Color" id="Color" size="15"/>
                </td>
            </tr>
            <tr>
                <th> Description:</th>
                <td>
                    <input type="text" name="Description" id="Description" size="15"/>
                </td>
            </tr>
            <tr>
                <th> Category:</th>
                <td>
                    <select class="custom-select" name="categoryID" id="inputGroupSelect01">
                        <option selected>Choose...</option>
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.idCategory}">${category.nameCategory}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
