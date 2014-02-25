<%@ include file="sbm_header.jsp"%>
<%@ include file="sbm_navigation_bar.jsp"%>

<script type="text/javascript">
	$(function() { 		
		$("#datepicker").datetimepicker();
 	});
</script>
<div class="container">

	<h3>Course Management</h3>
	<form:form method="post" action="addCourse" commandName="course">
		<table class="table table-bordered">
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="onDate">Date</form:label></td>
				<td><form:input path="onDate" type="text" id="datepicker" /></td>
				<td><form:errors path="onDate"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="satsangiPrice">Satsangi Price</form:label></td>
				<td><form:input path="satsangiPrice" /></td>
				<td><form:errors path="satsangiPrice"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="courseType">Course Type</form:label></td>
				<td>
					<form:select path="courseType" items="${courseTypes}"/>
				</td>
				<td/>
			</tr>
			<tr>
				<td><input type="submit" value="Add" class="btn btn-success" /></td>
				<td />
				<td />
			</tr>
		</table>
	</form:form>

	<table class="table table-bordered">
		<thead>
			<tr>
				<td>
					<h3>Courses available</h3>
					<h4 class="pull-right">From:</h4>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<table class="table table-bordered">
						<tr>
							<th>NAME</th>
							<th>DATE</th>
							<th>TYPE</th>
							<th>Members</th>
							<th>EDIT</th>
							<th>DETAILS</th>
							<!-- 							<th>DELETE</th> -->
							<th>REPEAT</th>
						</tr>

						<c:forEach var="course" items="${coursesList}">
							<form:form commandName="course" action="updateCourse" method="post">
							<form:hidden path="id" value="${course.id}"/>
							<tr>
								<td>${course.name}</td>

								<td><fmt:formatDate value="${course.onDate}"
										pattern="dd-MM-yyyy HH:mm" /></td>
								<td>${course.courseType}</td>
								<td>${fn:length(course.customersId)}</td>
								<td>
									<input type="submit" value="Edit" name="edit" class="btn btn-success">
<!-- 									<input type="button" value="Edit" -->
<%-- 									onclick="location.href='editCourse?id=${course.id}'" --%>
<!-- 									class="btn btn-success"> -->
								</td>
								<td>
									<input type="submit" value="Details" name="details" class="btn btn-success">
								</td>
								<%-- 							<td><input type="button" value="Delete" onclick="location.href='deleteCourse?id=${course.id}'" class="btn btn-danger"></td> --%>
								<td><input type="submit" value="Repeat"	name="repeat" class="btn btn-info"></td>


								<%-- 					<td><input type="button" value="+" onclick="location.href='incrementCount?id=${customer.id}'"> --%>
								<%-- 						<input type="button" value="-" onclick="location.href='decrementCount?id=${customer.id}'"> --%>
								<!-- 					</td> -->
								<%-- 					<td>${customer.entriesLeft}</td> --%>
							</tr>
						</form:form>
						</c:forEach>
					</table>
				</td>
				</tr>
		</tbody>
		<tfoot>
			<tr>
				<td align="center">
				<input type="button" value="home"
					onclick="location.href='${pageContext.request.contextPath}/home'"
					class="btn btn-primary"/>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

<%@ include file="sbm_footer.jsp"%>

