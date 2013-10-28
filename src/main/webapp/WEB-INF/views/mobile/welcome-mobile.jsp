<!DOCTYPE html> 
<html> 
<head> 
	<title>smart-body-method</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js"></script>
	<script type="text/javascript">
	var baseUrl = "http://localhost:8080/nirdosh-web/";
	
	$(document).on("pageshow","#pagetwo",function(event){
		$.ajax({
			url:baseUrl+"rest/customer/all",
			dataType: "json",
			success: function(data,textStatus,jqXHR){
				$('#customerList').empty();
				$.each(data,function(index,output){					
					$('#customerList').append('<li><a href="#">' +output.firstName+ '</a><a href="#">'+output.lastname+'</a></li>');
				});
				$('#customerList').listview("refresh");
			}
			
		});
	});
	</script>
</head> 
<body> 

<div data-role="page" id="pageone">

	<div data-role="header">
		<a data-role="button" data-icon="home">Home</a>
		<h1>SMART BODY METHOD</h1>
	</div>

	<div data-role="listview" data-icon="arrow-r" data-theme="b">	
		<li><a href="#pagetwo" data-transition="slide">CUSTOMERS</a></li>	
		<li><a href="">ADD</a></li>
		<li><a href="">EDIT</a></li>
		
	</div>
</div>

<div data-role="page" id="pagetwo">
		<div data-role="header" data-theme="b">
			<a data-role="button" data-icon="home">Home</a>
			<h1>Header</h1>
		</div>
		<!-- /header -->
		
		<div data-role="content">			
			<div data-role="listview" data-theme="d" id="customerList">
			</div>
			
		</div>
		
		<!-- /content -->

		<div data-role="footer" data-theme="b">
			<a href="#" data-role="button"  data-rel="back" data-inline="true" data-icon="back">Back</a>
			<h4>Footer</h4>
		</div>
		<!-- /footer -->

	</div>

</body>
</html>