<%@ include file="headerFrame.jsp"%>
		<form:form action="updatePrice" method="post" commandName="price">
			<table>
				<tr>
				<td><form:label path="id">ID</form:label>
				<td><form:input path="id"/> </td>
				</tr>
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
					<td colspan="2" align="center"><input type="submit" value="UPDATE"> </td>
				</tr>
			</table>			
		</form:form>		
<%@ include file="footerFrame.jsp"%>