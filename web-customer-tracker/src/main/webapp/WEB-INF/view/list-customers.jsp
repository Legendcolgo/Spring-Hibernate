<%--
  Created by IntelliJ IDEA.
  User: bharathrajakumar
  Date: 7/15/17
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customers</title>

    <%--Link up the style sheet--%>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

            <%--Add customer button--%>
            <%--Make a call to /showFormForAdd which will invoke a controller for this mapping--%>
            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email Address</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.emailAddress}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
