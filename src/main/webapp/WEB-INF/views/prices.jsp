<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<form:form acceptCharset="addPrice" method="post" commandName="price">
			<table>
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
					<td colspan="2" align="center"><input type="submit" value="ADD"> </td>
				</tr>
			</table>			
		</form:form>
		
		<table frame="box" border="1">
			<tr><th>VALUE</th>
    			<th>CARD TYPE</th>
  			</tr>
			<c:forEach var="price" items="${priceList}">
				<tr>
					<!--  
					<td>${contact.id}</td>
					-->
					<td>${price.value}</td>
					  
					<td>${price.cardType}</td>
					<!--
					<td>${customer.email}</td>
					-->
					<td><input type="button" value="edit" onclick="location.href='editPrice?$price'"></td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>