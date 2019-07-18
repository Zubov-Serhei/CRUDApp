<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
  Created by IntelliJ IDEA.
  User: Сергей Зубов
  Date: 17.06.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD App</title>
</head>
<body>
<h1>Input Form</h1>
<form:form action="updateUser" method="post" modelAttribute="user">
    <table>
        <tr>
            <td>Name</td>
            <td>
                <form:input path="name" title="${user.name}"/>
                <form:errors path="name" cssStyle="color: #ff0000;" />
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <form:input path="mail" title="${user.mail}"/>
                <form:errors path="mail" cssStyle="color: #ff0000;" />
            </td>
            <form:hidden path="id" title="${user.id}"/>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Submit</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
