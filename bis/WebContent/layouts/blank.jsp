<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>
			<tiles:insertAttribute name="title"/>
		</title>
		<jsp:include page="/layouts/resource_include.jsp"></jsp:include>
	</head>
	<body onload="showMessage();">

		<div class="container">
			<div class="header">
				<h1>
					<tiles:insertAttribute name="head"/>
				</h1>
			</div>
		
			<div class="main">
				<div id="message" style="display:none">${message}</div>
				<tiles:insertAttribute name="main"/>
			</div>
		
			<div class="footer">
				<tiles:insertAttribute name="footer"/>
			</div>
		
		</div>
	</body>
</html>