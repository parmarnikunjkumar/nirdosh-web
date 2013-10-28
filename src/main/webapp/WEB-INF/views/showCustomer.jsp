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
		<h2>Customer</h2>
		<table cellspacing="2" cellpadding="2" border="2">
			<tr>
				<td><spring:message code="label.firstname" /></td>
				<td>${customer.firstName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.lastname" /></td>
				<td>${customer.lastName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.email" /></td>
				<td>${customer.email}</td>
			</tr>
			<tr>
					<td><spring:message code="label.cardtype"/></td>
					<td>${customer.cardType} </td>
				</tr>
			<tr>
				<td><spring:message code="label.entriesleft" /></td>
				<td>${customer.entriesLeft}</td>
			</tr>
			<tr>
				<td><spring:message code="label.currentbalance" /></td>
				<td>${customer.paymentInfo.currentBalance}</td>
			</tr>
		</table>
		<button onclick="location.href='customer'" value="OK" > OK</button>

	</div>
</body>
</html>