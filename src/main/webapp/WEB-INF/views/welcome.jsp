<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<h2>Hello World!</h2>

<input type="submit" name="customer" value="customers">

<form:form method="get" action="customer">
	<input type="submit" value="customers">
</form:form>

<form:form method="get" action="price">
	<input type="submit"  value="Prices">
</form:form>
</body>
</html>
