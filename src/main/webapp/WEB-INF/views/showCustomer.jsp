<%@ include file="headerFrame.jsp"%>
	<div align="center">
		<h2>Customer</h2>
		<table cellspacing="2" cellpadding="2" border="2">
			<tr>
				<td><spring:message code="label.firstname" /></td>
				<td>${customer.firstName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.lastname" /></td>
				<td>${customer.lastName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.email" /></td>
				<td>${customer.email}</td>
			</tr>
			<tr>
					<td><spring:message code="label.cardtype"/></td>
					<td>${customer.cardType} </td>
				</tr>
			<tr>
				<td><spring:message code="label.entriesleft" /></td>
				<td>${customer.entriesLeft}</td>
			</tr>
			<tr>
				<td><spring:message code="label.currentbalance" /></td>
				<td>${customer.paymentInfo.currentBalance}</td>
			</tr>
		</table>
		<button onclick="location.href='customer'" value="OK" > OK</button>

	</div>
<%@ include file="footerFrame.jsp"%>