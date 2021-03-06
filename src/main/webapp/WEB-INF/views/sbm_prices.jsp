<%@ include file="sbm_header.jsp"%>	
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
		<form:form action="addPrice" method="post" commandName="price">
			<table class="table">
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
					<td colspan="2" align="center"><input type="submit" value="ADD" class="btn btn-primary"> </td>
				</tr>
			</table>			
		</form:form>
		
		<table class="table table-bordered">
			<tr><th>VALUE</th>
    			<th>CARD TYPE</th>
    			<th>EDIT</th>
  			</tr>
			<c:forEach var="price" items="${priceList}">
				<tr>
					<!--  
					<td>${contact.id}</td>
					-->
					<td>${price.value}</td>
					  
					<td>${price.cardType}</td>
					<!--
					<td>${customer.email}</td>
					-->
					<td><input type="button" value="edit" onclick="location.href='editPrice?id=${price.id}'" class="btn btn-success">
						<input type="button" value="delete" onclick="location.href='deletePrice?id=${price.id}'" class="btn btn-danger"></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="button" value="home" onclick="location.href='home'" class="btn btn-primary">
</div>
		
<%@ include file="sbm_footer.jsp"%>