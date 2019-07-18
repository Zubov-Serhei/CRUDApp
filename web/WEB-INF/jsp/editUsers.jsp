<%--
  Created by IntelliJ IDEA.
  User: Сергей Зубов
  Date: 10.06.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="editPage.pageName"/></title>
    <style type="text/css">
        .error {
            color: red;
        }
        .topright {
            position: absolute;
            top: 8px;
            right: 16px;
            font-size: 18px;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            border-spacing: 0px;
        }
        table td {
            border: 1px solid #565454;
            padding: 20px;
        }
    </style>
</head>
<body>
<h1><spring:message code="editPage.inputForm"/></h1>
<form:form action="addUser" method="post" modelAttribute="user">
    <table>
        <tr>
            <td><spring:message code="editPage.fieldName.name"/></td>
            <td>
                <form:input path="name" /><br />
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="editPage.fieldName.email"/></td>
            <td>
                <form:input path="mail" /> <br />
                <form:errors path="mail" cssClass="error" />
            </td>
            <c:if test="${user.id}!=null">
                <form:hidden path="id" title="${user.id}"/>
            </c:if>
        </tr>
        <tr>
            <td colspan="2"><button type="submit"><spring:message code="editUser.button.submit"/> </button></td>
        </tr>
    </table>
</form:form>

<h2><spring:message code="editPage.form.userList"/></h2>
<table>
    <tr>
        <td><strong><spring:message code="editPage.fieldName.name"/> </strong></td>
        <td><strong><spring:message code="editPage.fieldName.email"/> </strong></td>
        <td><strong><spring:message code="editUser.fieldName.action"/> </strong></td>
    </tr>
    <c:forEach items="${users}" var="user">

        <c:url var="updateLink" value="/updateUser">
            <c:param name="userId" value="${user.id}" />
        </c:url>

        <c:url var="deleteLink" value="/deleteUser">
            <c:param name="userId" value="${user.id}" />
        </c:url>

        <tr>
            <td>${user.name}</td>
            <td>${user.mail}</td>
            <td>
                <a href="${updateLink}"><spring:message code="editUser.action.update"/> </a>|
                <a href="${deleteLink}"
                   onclick="if (!(confirm(<spring:message code="editUser.message.confirm"/>))) return false"><spring:message code="editUser.action.delete"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
    <div class="topright">
        <a href="/?lang=en">EN</a>
        <a href="/?lang=ru">RU</a>
    </div>
</body>
</html>
