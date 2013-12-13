
<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
		<h2>Course Edit</h2>
		<form:form method="post" action="updateCourse" commandName="course" modelAttribute="course">
			<table class="table">
				<!-- 
				<tr>
					<td><form:label path="id"><spring:message code="label.id"/> </form:label></td>
					<td><form:input  path="id"/></td>
					<td><form:errors path="id"/></td>				
				</tr>
				-->
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
					<td><form:label path="duration">DURATION</form:label></td>
					<td><form:input path="duration"/></td>
					<td><form:errors path="duration"/></td>
				</tr>
				<tr>
					<td><input type="button" value="Add Customer" onclick="location.href='addCustomersInCourse?courseId=${course.id}'" class="btn btn-success"></td>
					
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="label.update"/>" class="btn btn-success"> </td>
				</tr>
				<tr>
					<td> <input type="button" value="CANCEL" onclick="location.href='cancel'" class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>
</div>
<%@ include file="footerFrame.jsp"%>