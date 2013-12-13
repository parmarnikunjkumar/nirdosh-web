<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>

<script type="text/javascript">
	$(function(){
		$("#datepicker").datepicker();
		$("#timepicker").timepicker();
	});
</script>
<div class="container">

	<h3>Course Management</h3>
	<form method="post" action="course/addCourse" commandName="course">
		<table>
			<tr>
				<td><label path="name">Name</label></td>
				<td><input path="name" name="name"/></td>
			</tr>
			<tr>
				<td><label path="onDate">Date</label></td>
				<td>
					<input path="onDate" type="text" id="datepicker" name="onDate"/>
				</td>
			</tr>
			<tr>
				<td><label path="duration">Duration</label></td>
				<td><input path="duration" name="duration"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add"/></td>
			</tr>
		</table>
	</form>	


		<table>
			<tr>
				<td>
					<h3>Courses available</h3>
		
					<table frame="box" border="1">
						<tr>
							<th>NAME</th>
							<th>DATE</th>
							<th>Members</th>
							<th>EDIT</th>
							<th>+ / -</th>
						</tr>
						
						<c:forEach var="course" items="${coursesList}">
							<tr>
							<td>${course.name}</td>
		
							<td>${course.onDate}</td>
		
							<td>${fn:length(course.customersId)}
							</td>
						
							<td><input type="button" value="edit" onclick="location.href='course/editCourse?id=${course.id}'"></td>
							<td><input type="button" value="delete" onclick="location.href='course/deleteCourse?id=${course.id}'"></td>
							
							<%-- 					<td><input type="button" value="+" onclick="location.href='incrementCount?id=${customer.id}'"> --%>
							<%-- 						<input type="button" value="-" onclick="location.href='decrementCount?id=${customer.id}'"> --%>
							<!-- 					</td> -->
							<%-- 					<td>${customer.entriesLeft}</td> --%>
							</tr>
						</c:forEach>
					</table>
					
					<input type="button" value="home" onclick="location.href='${pageContext.request.contextPath}/home'">
				</td>
			</tr>
			</table>
</div>

