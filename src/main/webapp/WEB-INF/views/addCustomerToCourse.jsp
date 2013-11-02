<%@ include file="headerFrame.jsp"%>

	<form:form action="done"  commandName="course" method="post">
		<form:hidden path="id"/>
	<table frame="box" border="1">
			<tr>
				<th></th>
				<th>NAME</th>
    			<th>LAST NAME</th>
  			</tr>
			<c:forEach var="customer" items="${customerList}" >
			<tr>
					
					<td><form:checkbox path="customersId" value="${customer.id}"/> </td>
					<td>${customer.firstName}</td>
					  
					<td>${customer.lastName}</td>
			</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Add">
		<input type="button" value="cancel" onclick="location.href='cancel'"/>
	</form:form>
<%@ include file="footerFrame.jsp"%>