<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
	<form:form action="done"  commandName="course" method="post">
		<form:hidden path="id"/>
	<table class="table table-bordered">
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
		<input type="submit" value="Add" class="btn btn-success">
		<input type="button" value="cancel" onclick="location.href='cancel'" class="btn btn-info"/>
	</form:form>
</div>
<%@ include file="footerFrame.jsp"%>