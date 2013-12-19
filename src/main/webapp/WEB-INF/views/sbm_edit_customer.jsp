<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
		<h2>Customer Manager</h2>
		<form:form method="post" action="updateCustomer" commandName="customer">
			<form:hidden path="id"/>
			<table class="table">
<!-- 				<tr> -->
<%-- 					<td><form:label path="id"><spring:message code="label.id"/> </form:label></td> --%>
<%-- 					<td><form:input path="id"/></td> --%>
<%-- 					<td><form:errors path="id"/></td>				 --%>
<!-- 				</tr> -->
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
<!-- 				<tr> -->
<%-- 					<td><form:label path="cardType"><spring:message code="label.cardtype"/> </form:label></td> --%>
<%-- 					<td><form:select path="cardType"> --%>
<%-- 							<form:options/> --%>
<%-- 						</form:select> </td> --%>
<%-- 					<td><form:errors path="cardType"/></td> --%>
<!-- 				</tr>	 -->
				<tr>
					<td><form:label path="customerCard.entriesLeft"><spring:message code="label.entriesleft"/> </form:label></td>
					<td><form:input path="customerCard.entriesLeft"/></td>
					<td><form:errors path="customerCard.entriesLeft"/></td>				
				</tr>
				<tr>					
					<td><form:label path="balance"><spring:message code="label.balance"/> </form:label></td>
					<td><form:input path="balance"/></td>
					<td><form:errors path="balance"/></td>			
				</tr>
				<tr>					
					<td><form:label path="customerCard.balance"><spring:message code="label.card.balance"/> </form:label></td>
					<td><form:input path="customerCard.balance"/></td>
					<td><form:errors path="customerCard.balance"/></td>			
				</tr>
<!-- 				<tr>					 -->
<%-- 					<td><form:label path="paymentInfo.amountToPay"><spring:message code="label.amounttopay"/> </form:label></td> --%>
<%-- 					<td><form:input path="paymentInfo.amountToPay"/></td> --%>
<%-- 					<td><form:errors path="paymentInfo.amountToPay"/></td>			 --%>
<!-- 				</tr> -->
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${customer.balance<=0}"> --%>
<!-- 						<tr bgcolor="#FF0000"> -->
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<!-- 						<tr> -->
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
<!-- 				<tr> -->
<%-- 					<td><form:label path="balance"><spring:message code="label.currentbalance"/> </form:label></td> --%>
<%-- 					<td><form:input path="balance"/></td> --%>
<%-- 					<td><form:errors path="balance"/></td> --%>
<!-- 				</tr> -->
				<tr>
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="label.update"/>" class="btn btn-primary"> </td>
				</tr>
				<tr>
					<td> <input type="button" value="CANCEL" onclick="location.href='cancel'" class="btn btn-danger"></td>
					<td> <input type="submit" value="Delete User"  name="delete" class="btn btn-danger pull-right">
<%-- 						<input type="submit" value="Delete User" onclick="location.href='deleteCustomer?id=${customer.id}'" class="btn btn-danger pull-right"> --%>
					</td>
				</tr>
			</table>
		</form:form>
</div>
<%@ include file="sbm_footer.jsp"%>