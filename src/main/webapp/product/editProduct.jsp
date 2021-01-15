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
    <title>Information Product</title>
</head>
<body>
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
                    <input type="text" name="name" id="name" size="45" placeholder="input Name"  value="${product.nameProduct}"/>
                </td>
            </tr>
            <tr>
                <th> Price:</th>
                <td>
                    <input type="text" name="Price" id="Price" size="45" placeholder="input price" value="${product.priceProduct}"/>
                </td>
            </tr>
            <tr>
                <th> Quantity:</th>
                <td>
                    <input type="text" name="Quantity" id="Quantity" placeholder="input quantity" size="15" value="${product.quantityProduct}"/>
                </td>
            </tr>
            <tr>
                <th> Color:</th>
                <td>
                    <input type="text" name="Color" id="Color" size="15" placeholder="input color" value="${product.color}"/>
                </td>
            </tr>
            <tr>
                <th> Description:</th>
                <td>
                    <input type="text" name="Description" id="Description" size="15" placeholder="input description" value="${product.descriptionProduct}"  />
                </td>
            </tr>
            <tr>
                <th> Category:</th>
                <td>
                    <select class="custom-select" name="categoryID" id="inputGroupSelect01" >
                        <c:forEach items="${listCategory}" var="category">
                            <c:if test="${product.idCategory==category.idCategory}">
                                <option value="${category.idCategory}">${category.nameCategory}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach items="${listCategory}" var="category">
                            <c:if test="${product.idCategory!=category.idCategory}">
                                <option value="${category.idCategory}">${category.nameCategory}</option>
                            </c:if>
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
