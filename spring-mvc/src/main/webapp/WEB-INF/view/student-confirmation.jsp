<%--
  Created by IntelliJ IDEA.
  User: bharathrajakumar
  Date: 6/14/17
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
    The student is confirmed : ${student.firstName} ${student.lastName}
    <%--When this form is loaded Spring MVC will call student.getFirstName() and student.getLastName()--%>
    <br><br>
    Country : ${student.country}
    <br><br>
    His favorite language is : ${student.favoriteLanguage}
    <br><br>
    His favorite operating system:
    <ul>
        <c:forEach var="temp" items="${student.favoriteOperatingSystems}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>
