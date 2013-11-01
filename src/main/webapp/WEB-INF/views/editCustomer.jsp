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
		<h2>Course Edit</h2>
		<form:form method="post" action="updateCourse" commandName="course">
			<table>
				<tr>
					<td><form:label path="id"><spring:message code="label.id"/> </form:label></td>
					<td><form:input path="id"/></td>
					<td><form:errors path="id"/></td>				
				</tr>
				<tr>
					<td><form:label path="name"><spring:message code="label.firstname"/> </form:label></td>
					<td><form:input path="name"/></td>
					<td><form:errors path="name"/></td>				
				</tr>
				<tr>
					<td><form:label path="onDate"><spring:message code="label.lastname"/></form:label></td>
					<td><form:input path="onDate"/></td>
					<td><form:errors path="onDate"/></td>	
				</tr>
				<tr>
					<td><form:label path="duration"><spring:message code="label.email"/> </form:label></td>
					<td><form:input path="duration"/></td>
					<td><form:errors path="duration"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="label.update"/>"> </td>
				</tr>
				<tr>
					<td> <input type="button" value="CANCEL" onclick="location.href='cancel'"></td>
				</tr>
			</table>
		</form:form>
		</div>
</body>
</html>