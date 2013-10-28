
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<table border="1"  cellpadding="2" cellspacing="2" align="center" bgcolor="yellow" width="800">
		<tr>
			<td height="30" colspan="3"><tiles:insertAttribute name="header"/></td>
		</tr>
		<tr>
			<td height="250"><tiles:insertAttribute name="leftMenu"/></td>
			<td height="350"><tiles:insertAttribute name="body"/></td>
			<td height="250"><tiles:insertAttribute name="rightMenu"/></td>
		</tr>
		<tr>
			<td height="30" colspan="3"><tiles:insertAttribute name="footer"/></td>
		</tr>
	</table>
</body>
</html>