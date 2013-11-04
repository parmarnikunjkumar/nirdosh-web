<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
</head>

<body>
		<div id="container">
			<div id="header">
				<h1>SMART BODY METHOD</h1>
			</div>
			<div id="navigation">
				<ul>
					<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/customer">Customers</a></li>
					<li><a href="${pageContext.request.contextPath}/price">Price</a></li>
					<li><a href="${pageContext.request.contextPath}/course/courses">Courses</a></li>
				</ul>
			</div>
			<div id="content-containder">
				<div id="content">