<%@ include file="sbm_header.jsp"%>
<%@ include file="sbm_navigation_bar.jsp"%>
 <div class="container">
 	<c:url value="/login" var="loginUrl"></c:url>
 	<form:form name="f" action="${loginUrl}" method="POST" role="form">
 		<fieldset>
 			<legend>Please Login</legend>
 			<c:if test="${param.error != null}">
 				<div class="alert alert-error">
 					Invalid Username and Password 					
 				</div>
 			</c:if>
 			<c:if test="${param.logout != null}">
 				<div class="alert alert-success">
                    You have been logged out.
                </div>
 			</c:if>
 			<div class="form-group">
 				<label for="username">Username</label>
 				<input type="text" id="username" name="username">
 			</div>
 			<div class="form-group">
 				<label for="password">Password</label>
 				<input type="password" id="password" name="password">
 			</div> 			
 			<div class="form-actions">
 				<button type="submit" class="btn btn-success">Login</button>
 			</div>
 		</fieldset>
 	</form:form>
 </div>