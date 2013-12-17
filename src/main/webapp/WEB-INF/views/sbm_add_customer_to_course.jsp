<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
	<form:form action="doneAddCustomers"  commandName="course" method="post">
		<form:hidden path="id"/>
	<table class="table table-bordered">
			<tr>
				<th></th>
				<th>NAME</th>
    			<th>LAST NAME</th>
    			<th></th>
  			</tr>
			<c:forEach var="customer" items="${customerList}" >
			<tr>
					
					<td><form:checkbox path="customersId" value="${customer.id}"/> </td>
					<td>${customer.firstName}</td>
					  
					<td>${customer.lastName}</td>
					<td>
						<c:set var="contains" value="false"></c:set>
						<c:set var="courseId" value="${course.id}"></c:set>
						<c:forEach var="item" items="${customer.courseList}">
							<c:if test="${item eq courseId}">
									<input type="submit" value="Take Out" class="btn btn-danger" name="${customer.id}"/>								
							</c:if>
						</c:forEach>
					</td>
			</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Add" class="btn btn-success">
		<input type="button" value="cancel" onclick="location.href='course'" class="btn btn-info"/>
	</form:form>
</div>
<%@ include file="sbm_footer.jsp"%>