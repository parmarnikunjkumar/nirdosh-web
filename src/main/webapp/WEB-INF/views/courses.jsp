<script type="text/javascript">
	$(function(){
		$("input[type=submit]").button().click(function(){
			$('#table').append("<tr><td>28-10-2013</td><td>15</td></tr>");
		});
	});
	
	function createTable(){
		$('#row').append("<td>28-10-2013</td><td>15</td>");
	};
</script>
<div>
	<h3>Courses available</h3>
	<input type="submit" value="New Course" style="margin: 50" />
	<div id="course_table">
		<table id="table" border="2">
			<tr>
				<th>On</th>
				<th>Members</th>
			</tr>
		</table>
	</div>
	
</div>