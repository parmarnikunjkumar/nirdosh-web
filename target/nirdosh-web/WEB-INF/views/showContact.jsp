<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 3 MVC Series - Validation</title>
</head>
<body>
	<div align="center">
		<h2>domainContacts</h2>
		<table cellspacing="2" cellpadding="2" border="2">
			<tr>
				<td><spring:message code="label.firstname" /></td>
				<td>${domainContact.firstName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.lastname" /></td>
				<td>${domainContact.lastName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.email" /></td>
				<td>${domainContact.email}</td>
			</tr>
			<tr>
				<td><spring:message code="label.telephone" /></td>
				<td>${domainContact.telephone}</td>
			</tr>
		</table>
		<button onclick="location.href='contact'" value="OK" > OK</button>

	</div>
</body>
</html>