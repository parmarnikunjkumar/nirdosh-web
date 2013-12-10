<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>

<title>Capi Admin Interface</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="base"
	value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}/" />
</head>


<h3 align="center"><spring:message code="label.title" /></h3>
<span style="float: right">
	<a href="?lang=en">en</a>
	|
	<a href="?lang=de">de</a>
</span>