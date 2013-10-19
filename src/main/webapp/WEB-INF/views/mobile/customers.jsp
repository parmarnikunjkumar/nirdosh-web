<!DOCTYPE html>
<html>
<head>
<title>smart-body-method</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.css" />
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js"></script>
<script type="text/javascript">
	var baseUrl = "http://localhost:8080/nirdosh-web/";
	$(document).ready(function(){
		$.ajax({
			url:baseUrl+"rest/customer/all",
			dataType: "json",
			success: function(data,textStatus,jqXHR){
				$.each(data,function(index,output){
					$('#customerList').append('<li><a href=customer>' +output.firstName+ '</a></li>');
				});
			}
			
		});
	});
</script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>Header</h1>
		</div>
		<!-- /header -->
		
		<div data-role="content">
			<div data-role="listview" data-theme="b" id="customerList">
			</div>
		</div>
		<!-- /content -->

		<div data-role="footer">
			<h4>Footer</h4>
		</div>
		<!-- /footer -->

	</div>
	<!-- /page -->

</body>