<%@ include file="header.jsp"%>
<%@ include file="navigation-bar.jsp"%>

<div class="container">
	<div class="jumbotron">
		<h2>CONTENT API DASHBOARD</h2>		
	</div>
	<div class="row">
		<div class="col-lg-6">
			<h2><a href="log">APILOG</a></h2>
			<span id="server_result_api-log"></span>
		</div>
		<div class="col-lg-6">
			<h2><a href="access">ACCESS</a></h2>
			<span id="server_result_access"></span>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<h2><a href="storage">STORAGE</a></h2>
			<span id="server_result_storage"></span>
		</div>
		<div class="col-lg-6">
			<h2><a href="systems">SYSTEMS</a></h2>
			<span id="server_result_systems"></span>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>
