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
		<form:form method="post" action="updateCustomer" commandName="customer">
			<table>
				<tr>
					<td><form:label path="id"><spring:message code="label.id"/> </form:label></td>
					<td><form:input path="id"/></td>
					<td><form:errors path="id"/></td>				
				</tr>
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
					<td><form:label path="cardType"><spring:message code="label.cardtype"/> </form:label></td>
					<td><form:select path="cardType">
							<form:options/>
						</form:select> </td>
					<td><form:errors path="cardType"/></td>
				</tr>	
				<tr>
					<td><form:label path="entriesLeft"><spring:message code="label.entriesleft"/> </form:label></td>
					<td><form:input path="entriesLeft"/></td>
					<td><form:errors path="entriesLeft"/></td>				
				</tr>
				<tr>
					<td><form:label path="paymentInfo.amountPaid"><spring:message code="label.amountpaid"/> </form:label></td>
					<td><form:input path="paymentInfo.amountPaid"/></td>
					<td><form:errors path="paymentInfo.amountPaid"/></td>
					
					<td><form:label path="paymentInfo.amountToPay"><spring:message code="label.amounttopay"/> </form:label></td>
					<td><form:input path="paymentInfo.amountToPay"/></td>
					<td><form:errors path="paymentInfo.amountToPay"/></td>			
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="label.ok"/>"> </td>
				</tr>
			</table>
		</form:form>
		</div>
</body>
</html>