<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h4>Name:</h4><input value="${customer.firstName}"/>
			<h4>Surname:</h4><input value="${customer.lastName }"/>
			<br>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Date</th>
						<th>Course</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="status" var="course" items="${courseList}">
						<tr>
							<td><fmt:formatDate value="${course.onDate}" pattern="dd-MM-yyyy HH:mm" /></td>
							<td>${course.name}</td>
						</tr>
						<c:if test="${status.last}">
							<c:set var="totalRecords" value="${status.count}"/>
							<tr>
								<td><h5>Total</h5></td>
								<td>${totalRecords}</td>
								
							</tr>
						</c:if>						
					</c:forEach>
					<tr>
					
					</tr>
				</tbody>
			</table>
			
		</div>
	</div>
</div>
<%@ include file="sbm_footer.jsp"%>