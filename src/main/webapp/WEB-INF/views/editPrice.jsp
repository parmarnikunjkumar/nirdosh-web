<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<form:form action="updatePrice" method="post" commandName="price">
			<table>
				<tr>
				<td><form:label path="id">ID</form:label>
				<td><form:input path="id"/> </td>
				</tr>
				<tr>
				<td><form:label path="value">Value</form:label>
				<td><form:input path="value"/> </td>
				</tr>
				<tr>
				<td><form:label path="cardType">Card Type</form:label>
				<td><form:select path="cardType">
						<form:options/>
					</form:select>					
				</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="UPDATE"> </td>
				</tr>
			</table>			
		</form:form>		
	</body>
</html>