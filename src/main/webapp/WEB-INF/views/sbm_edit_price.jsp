<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
		<form:form action="updatePrice" method="post" commandName="price">
			<form:hidden path="id"/>
			<table class="table table-bordered">
<!-- 				<tr> -->
<%-- 				<td><form:label path="id">ID</form:label> --%>
<%-- 				<td><form:input path="id"/> </td> --%>
<!-- 				</tr> -->
				<tr>
				<td><form:label path="value">Value</form:label>
				<td><form:input path="value"/> </td>
				</tr>
				<tr>
				<td><form:label path="cardType">Card Type</form:label>
				<td><form:select path="cardType">
						<form:options/>
					</form:select>					
				</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="UPDATE" class="btn btn-success"> </td>
				</tr>
			</table>			
		</form:form>	
</div>	
<%@ include file="footerFrame.jsp"%>