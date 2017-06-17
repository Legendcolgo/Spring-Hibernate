<%--
  Created by IntelliJ IDEA.
  User: bharathrajakumar
  Date: 6/14/17
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        <%--When this form is loaded Spring MVC will call student.getFirstName() and student.getLastName()--%>
        <%--Should match with the properties of Student class--%>
        First Name : <form:input path="firstName"></form:input>
        <br><br>
        Last Name : <form:input path="lastName"></form:input>
        <br><br>
        <form:select path="country">
            <%--Use this if you would like to populate the drop down list from the properties file--%>
            <form:options items="${theCountryOptions}"></form:options>

            <%--Use this if you would like to populate the drop down list from the java class--%>
            <%--<form:options items="${student.countryOptions}"></form:options>--%>

            <%--Use this if you would like to populate the drop down list from jsp directly--%>
            <%--<form:option value="Brazil" label="Brazil"></form:option>--%>
            <%--<form:option value="France" label="France"></form:option>--%>
            <%--<form:option value="Germany" label="Germany"></form:option>--%>
            <%--<form:option value="India" label="India"></form:option>--%>
            <%--<form:option value="Sweden" label="Sweden"></form:option>--%>
        </form:select>
        <br><br>
        Favorite Language : 

        Java <form:radiobutton path="favoriteLanguage" value="java"></form:radiobutton>
        C# <form:radiobutton path="favoriteLanguage" value="c#"></form:radiobutton>
        PHP <form:radiobutton path="favoriteLanguage" value="php"></form:radiobutton>
        Ruby <form:radiobutton path="favoriteLanguage" value="ruby"></form:radiobutton>

        <br><br>

        Operating Systems :

        Linux <form:checkbox path="favoriteOperatingSystems" value="linux"></form:checkbox>
        Mac Os <form:checkbox path="favoriteOperatingSystems" value="mac"></form:checkbox>
        Windows <form:checkbox path="favoriteOperatingSystems" value="windows"></form:checkbox>

        <br><br>

        <input type="submit" value="Submit">
        <%--When this form is submitted Spring MVC will call student.setFirstName() and student.setLastName()--%>

    </form:form>
</body>
</html>
