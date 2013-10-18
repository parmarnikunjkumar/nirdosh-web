<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 3 MVC Series - Validation</title>
</head>
<body>
	<div align="center">
		<h2>Customer Manager</h2>
		<form:form method="post" action="addCustomer" commandName="customer">
			<table>
				<tr>
					<td><form:label path="firstName"><spring:message code="label.firstname"/> </form:label></td>
					<td><form:input path="firstName"/></td>
					<td><form:errors path="firstName"/></td>				
				</tr>
				<tr>
					<td><form:label path="lastName"><spring:message code="label.lastname"/></form:label></td>
					<td><form:input path="lastName"/></td>
					<td><form:errors path="lastName"/></td>	
				</tr>
				<tr>
					<td><form:label path="email"><spring:message code="label.email"/> </form:label></td>
					<td><form:input path="email"/></td>
					<td><form:errors path="email"/></td>
				</tr>
				<tr>
					<td><form:label path="telephone"><spring:message code="label.telephone"/> </form:label></td>
					<td><form:input path="telephone"/></td>
					<td><form:errors path="telephone"/></td>
				</tr>
				<tr>	
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="label.addcontact"/>"> </td>
				</tr>
			</table>
		</form:form>
		
		<table border="1">
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<!--  
					<td>${contact.id}</td>
					-->
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td><input type="button" value="delete" onclick="location.href='deleteCustomer?id=${customer.id}'"></td>
				</tr>
			</c:forEach>
		</table>

		</div>
</body>
</html>