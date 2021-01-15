<%--
  Created by IntelliJ IDEA.
  User: luong
  Date: 1/15/2021
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Information Category</title>
</head>
<body>
<center>
    <h1> Information delete Category</h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th> Name:</th>
                <td>
                    <c:out value="${product.nameProduct}" />
                </td>
            </tr>
            <tr>
                <th> Price:</th>
                <td>
                <c:out value="${product.priceProduct}"  />
                </td>
            </tr>
            <tr>
                <th> Quantity:</th>
                <td>
                    <c:out value="${product.quantityProduct}"  />
                </td>
            </tr>
            <tr>
                <th> Color:</th>
                <td>
                    <c:out value="${product.color}"  />
                </td>
            </tr>
            <tr>
                <th> Description:</th>
                <td>
                    <c:out value="${product.descriptionProduct}"  />
               </td>
            </tr>
            <tr>
                <th> Category:</th>
                <td>
                    <c:forEach var="category" items="${listCategory}">
                        <c:if test="${product.idCategory==category.idCategory}">
                            <c:out value="${category.nameCategory}"/>
                        </c:if>
                    </c:forEach>
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
