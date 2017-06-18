<%--
  Created by IntelliJ IDEA.
  User: bharathrajakumar
  Date: 6/17/17
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    The customer is confirmed: ${customer.firstName} ${customer.lastName}
    <br><br>
    Free Passes: ${customer.freePasses}
</body>
</html>
