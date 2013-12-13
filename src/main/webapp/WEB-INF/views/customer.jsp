<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
<div align="center">
		<h2>Customer Manager</h2>
		<form method="post" action="addCustomer">
			<table>
				<tr>
					<td><form:label path="firstName"><spring:message code="label.firstname"/> </form:label></td>
					<td><form:input path="firstName"/></td>
					<td><form:errors path="firstName"/></td>				
				</tr>
				<tr>
					<td><form:label path="lastName"><spring:message code="label.lastname"/></form:label></td>
					<td><form:input path="lastName"/></td>
					<td><form:errors path="lastName"/></td>	
				</tr>
				<tr>
					<td><form:label path="email"><spring:message code="label.email"/> </form:label></td>
					<td><form:input path="email"/></td>
					<td><form:errors path="email"/></td>
				</tr>
				<tr>
					<td><form:label path="mobile"><spring:message code="label.mobile"/> </form:label></td>
					<td><form:input path="mobile"/></td>
					<td><form:errors path="mobile"/></td>
				</tr>
				<tr>
					<td><form:label path="home"><spring:message code="label.home"/> </form:label></td>
					<td><form:input path="home"/></td>
					<td><form:errors path="home"/></td>
				</tr>
				<tr>
					<td><form:label path="cardType"><spring:message code="label.cardtype"/> </form:label></td>
					<td><form:select path="cardType">
						<form:options/>
						</form:select> </td>
					<td><form:errors path="cardType"/></td>
				</tr>
				<tr>
					<td><form:label path="paymentInfo.currentBalance"><spring:message code="label.currentbalance"/> </form:label></td>
					<td><form:input path="paymentInfo.currentBalance"/></td>
					<td><form:errors path="paymentInfo.currentBalance"/></td>
				</tr>				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Add"> </td>
				</tr>
			</table>
		</form:form>
		
		<table frame="box" border="1">
			<tr><th>NAME</th>
    			<th>LAST NAME</th>
    			<th>DELETE</th>
    			<th>EDIT</th>
    			<th> + / -</th>
    			<th>VISITS</th>
  			</tr>
			<c:forEach var="customer" items="${customerList}" varStatus="loop">
				<c:choose>
					<c:when test="${customer.paymentInfo.currentBalance <= 0}">
						<tr bgcolor="#FF0000">
					</c:when>
					<c:otherwise>
						<tr>
					</c:otherwise>
				</c:choose>
					<!--  
					<td>${contact.id}</td>
					-->
					<td id='customer${loop.count}FirstName'>${customer.firstName}</td>
					  
					<td>${customer.lastName}</td>
					<!--
					<td>${customer.email}</td>
					-->
					<td><input type="button" value="delete" onclick="location.href='deleteCustomer?id=${customer.id}'"></td>
					<td><input type="button" value="edit" onclick="location.href='editCustomer?id=${customer.id}'"></td>
					<td><input type="button" value="+" onclick="location.href='incrementCount?id=${customer.id}'">
						<input type="button" value="-" onclick="location.href='decrementCount?id=${customer.id}'">
					</td>
					<td>${customer.entriesLeft}</td>
					<script type="text/javascript">
						$(document).ready(function(){
						$("#customer${loop.count}FirstName").click(function(){
							var str = "<table border='1' frame='box'>"+
							"<tr><th>First Name</th><th>Last Name</th><th>Current Balance</th><th>To Pay</th></tr>"+
							"<tr><td>${customer.firstName}</td><td>${customer.lastName}</td><td>${customer.paymentInfo.currentBalance}</td><td>${customer.paymentInfo.amountToPay}</td></tr></table>";
							$("#customer_info_form").html(str).dialog("open");
						})});
					</script>
				</tr>
			</c:forEach>
</table>
		
<input type="button" value="home" onclick="location.href='home'">

</div>	
		
<%@ include file="footer.jsp"%>
