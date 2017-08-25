<%--
  Created by IntelliJ IDEA.
  User: bharathrajakumar
  Date: 7/16/17
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>

    <%--Link up the style sheet--%>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <%--This form basically maps to the /saveCustomer mapping request--%>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">

            <%--This field is needed to make sure that we are updating the correct customer when we click on the save button--%>
            <form:hidden path="id"></form:hidden>
            <table>
                <tbody>
                    <tr>
                        <td><label>First name : </label></td>
                        <td><form:input path="firstName"></form:input></td>
                    </tr>

                    <tr>
                        <td><label>Last name : </label></td>
                        <td><form:input path="lastName"></form:input></td>
                    </tr>

                    <tr>
                        <td><label>Email : </label></td>
                        <td><form:input path="emailAddress"></form:input></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear: both"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>
</body>
</html>
