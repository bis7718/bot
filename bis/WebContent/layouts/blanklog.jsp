<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>
		</title>
		<jsp:include page="/layouts/resource_include.jsp"></jsp:include>
	</head>
	<body onload="showMessage();">
		<div id="message" style="display:none"><s:property value="message"/></div>
		<tiles:insertAttribute name="main"/>
	</body>
</html>