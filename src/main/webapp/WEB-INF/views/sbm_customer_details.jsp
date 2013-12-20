<%@ include file="sbm_header.jsp"%>
<%@ include file="sbm_navigation_bar.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h4>Name:</h4>
			${customer.firstName}
			<h4>Surname:</h4>
			${customer.lastName }
			<br> <br>
			<table>
				<thead>
					<tr>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<h4>Course Visited</h4>
						</td>
					</tr>
					<tr>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Date</th>
									<th>Course</th>
									<th>Type</th>
									<th>Price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach varStatus="status" var="course" items="${courseList}">
									<tr>
										<td><fmt:formatDate value="${course.onDate}"
												pattern="dd-MM-yyyy HH:mm" /></td>
										<td>${course.name}</td>
										<td>${course.courseType}</td>
										<td>${course.price}</td>
									</tr>
									<c:set var="totalPrice" value="${totalPrice + course.price }"></c:set>
									<c:if test="${status.last}">
										<c:set var="totalRecords" value="${status.count}" />
										<tr>
											<td><h5>Total</h5></td>
											<td>${totalRecords}</td>
											<td/>
											<td>${totalPrice}</td>

										</tr>
									</c:if>
								</c:forEach>
								<tr>

								</tr>
							</tbody>
						</table>
					</tr>
					<tr>
						<td>
							<h4>Payment History</h4>
						</td>
					</tr>
					<tr>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Index</th>
									<th>Date</th>
									<th>Amount</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach varStatus="status" var="payment"
									items="${customer.paymentHistory}">
									<tr>
										<td>${status.count}</td>
										<td><fmt:formatDate value="${payment.date}"
												pattern="dd-MM-yyyy HH:mm" /></td>
										<td>${payment.amount}</td>
									</tr>
									<c:set var="totalPayment" value="${totalPayment + payment.amount}"></c:set>
									<c:if test="${status.last}">
										<c:set var="totalRecords" value="${status.count}" />
										<tr>
											<td><h5>Total</h5></td>
											<td>${totalRecords}</td>
											<td>${totalPayment}</td>
										</tr>
									</c:if>
									
								</c:forEach>
								<tr>

								</tr>
							</tbody>
						</table>
					</tr>
				</tbody>
			</table>


		</div>
	</div>
</div>
<%@ include file="sbm_footer.jsp"%>