<%@ include file="headerFrame.jsp"%>
	<div align="center">
		<h2>Course Edit</h2>
		<form:form method="post" action="updateCourse" commandName="course" modelAttribute="course">
			<table>
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
					<td><input type="button" value="Add Customer" onclick="location.href='addCustomers?courseId=${course.id}'"></td>
					
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="label.update"/>"> </td>
				</tr>
				<tr>
					<td> <input type="button" value="CANCEL" onclick="location.href='cancel'"></td>
				</tr>
			</table>
		</form:form>
		</div>
<%@ include file="footerFrame.jsp"%>