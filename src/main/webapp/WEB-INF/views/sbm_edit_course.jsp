
<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
		<h2>Course Edit</h2>
		<form:form method="post" action="updateCourse" commandName="course">
			<form:hidden path="id"/>
			<table class="table">
				<tr>
					<td><form:label path="name">NAME</form:label></td>
					<td><form:input path="name"/></td>
					<td><form:errors path="name"/></td>				
				</tr>
				<tr>
					<td><form:label path="onDate">ON</form:label></td>
					<td><form:input path="onDate"/></td>
					<td><form:errors path="onDate"/></td>	
				</tr>
				<tr>
					<td><form:label path="price">PRICE</form:label></td>
					<td><form:input path="price"/></td>
					<td><form:errors path="price"/></td>
				</tr>
				<tr>
					<td></td>
					<td align="center">
						
						<input type="submit" value="Add Customer"  name="addCustomer" class="btn btn-success">
<%-- 						<input type="button" value="Add Customer" onclick="location.href='addCustomersInCourse?courseId=${course.id}'" class="btn btn-success"> --%>
					</td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="<spring:message code="label.update"/>" class="btn btn-success"> </td>
					<td/>
					<td><input type="button" value="Delete Course" onclick="location.href='deleteCourse?id=${course.id}'" class="btn btn-danger pull-right"> </td>
				</tr>
				<tr>
					<td> <input type="button" value="CANCEL" onclick="location.href='course'" class="btn btn-primary"></td>
					<td/>
					<td/>
				</tr>
			</table>
		</form:form>
</div>
<%@ include file="sbm_footer.jsp"%>