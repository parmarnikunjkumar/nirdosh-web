<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div align="left">
	<h3>Course Management</h3>
	<form:form method="post" action="addCourse" commandName="course">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="onDate">Date</form:label></td>
				<td>
					<form:input path="onDate" type="text"/>
				</td>
				<td><form:errors path="onDate"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="duration">Duration</form:label></td>
				<td><form:input path="duration"/></td>
				<td><form:errors path="duration"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add"/></td>
			</tr>
		</table>
	</form:form>	
</div>

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

					<td>${course.customers.size}</td>
				
					<td><input type="button" value="edit" onclick="location.href='editCourse?id=${course.id}'"></td>
					<td><input type="button" value="delete" onclick="location.href='deleteCourse?id=${course.id}'"></td>
					
					<%-- 					<td><input type="button" value="+" onclick="location.href='incrementCount?id=${customer.id}'"> --%>
					<%-- 						<input type="button" value="-" onclick="location.href='decrementCount?id=${customer.id}'"> --%>
					<!-- 					</td> -->
					<%-- 					<td>${customer.entriesLeft}</td> --%>
					</tr>
				</c:forEach>
			</table>
			
			<input type="button" value="home" onclick="location.href='home'">
		</td>
	</tr>
</table>