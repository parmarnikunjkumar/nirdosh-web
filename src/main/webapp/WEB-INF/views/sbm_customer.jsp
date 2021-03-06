<%@ include file="sbm_header.jsp"%>
<%@ include file="sbm_navigation_bar.jsp"%>
<script type="text/javascript">
	function updateBalance(id){
		var balance = $('input[id=amount_to_pay]').val();
		$.post("customer/updateBalance?id="+id+"&balance="+balance);
	}
</script>
<div class="container">
		<h2>Customer Manager</h2>
		<form:form method="post" action="addCustomer" commandName="customer" role="form">
			<table class="table table-bordered">
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
					<td><form:label path="satsangi"><spring:message code="label.isSatsangi"/> </form:label></td>
					<td><form:checkbox path="satsangi"/></td>
					<td><form:errors path="satsangi"/></td>
				</tr>
<!-- 				<tr> -->
<%-- 					<td><form:label path="cardType"><spring:message code="label.cardtype"/> </form:label></td> --%>
<%-- 					<td><form:select path="cardType"> --%>
<%-- 						<form:options/> --%>
<%-- 						</form:select> </td> --%>
<%-- 					<td><form:errors path="cardType"/></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<%-- 					<td><form:label path="paymentInfo.currentBalance"><spring:message code="label.currentbalance"/> </form:label></td> --%>
<%-- 					<td><form:input path="paymentInfo.currentBalance"/></td> --%>
<%-- 					<td><form:errors path="paymentInfo.currentBalance"/></td> --%>
<!-- 				</tr>	 -->
				<tr>
					<td><form:label path="balance"><spring:message code="label.currentbalance"/></form:label></td>
					<td><form:input path="balance"/></td>
					<td><form:errors path="balance"/></td>
				</tr>			
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Add" class="btn btn-success"></td>
					<td/>
				</tr>
			</table>
		</form:form>
		
		<table class="table table-bordered">
			<tr><th>NAME</th>
    			<th>LAST NAME</th>
    			<th>BALANCE</th>
    			<th>EDIT</th>    			
    			<th>VISITS</th>
    			<th>DETAILS</th>
    			<th>PAY</th>
    			<th></th>
  			</tr>
			<c:forEach var="customer" items="${customerList}" varStatus="loop">
			<form:form method="post" commandName="customer" role="form" action="updateCustomer">
			<tr>
					<form:hidden path="id" value="${customer.id}"/>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
<%-- 					<td><input type="button" value="delete" onclick="location.href='deleteCustomer?id=${customer.id}'" class="btn btn-danger btn-block"></td> --%>
					<td>${customer.totalBalance}</td>
					<td><input type="submit" value="edit" name="edit" class="btn btn-success btn-block"></td>
<%-- 					<td><input type="button" value="+" onclick="location.href='incrementCount?id=${customer.id}'" class="btn btn-default btn-sm"> --%>
<%-- 						<input type="button" value="-" onclick="location.href='decrementCount?id=${customer.id}'" class="btn btn-default btn-sm"> --%>
<!-- 					</td> -->
					<td>${fn:length(customer.courseList)}</td>
					<td>
						<input type="submit" class="btn btn-info" value="Details" name="details"/>
					</td>
					<td>						
						<input name="creditBalance" style="width: 50px"><input type="submit" class="btn btn-success pull-right" value="Pay"/>
					</td>
					<td>
						<form:select path="customerCard.cardType" items="${cardTypes}"/>
						<input type="submit" class="btn btn-success" value="Buy Card" name="buyCard"/>
					</td>
					
				</tr>
			</form:form>
		</c:forEach>
	</table>		
	<input type="button" value="home" onclick="location.href='home'" class="btn btn-primary"">
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">Buy Card</h4>
	      </div>
	      <div class="modal-body">
	         Card Type:<input name="cardType">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" onclick="">Save changes</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
</div>

<%@ include file="sbm_footer.jsp"%>
