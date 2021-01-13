<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
			<div class="menu_bar">
				<div style="float:right">
					Hi, <s:property value="#session.user.name"/> |
					<a href="/nova/logout.action">登出</a>
				</div>
				<tiles:insertAttribute name="menu"/>
			</div>
  
		</div>
    
    
		<div class="sidebar">
			<tiles:insertAttribute name="left"/>
		</div>
    
		<div class="right_panel">
			<div id="message" style="display:none"><s:property value="message"/></div>
			<div id="methodInvoked" style="display:none"><s:property value="#session.user.methodInvoke"/></div>
			<tiles:insertAttribute name="main"/>
		</div>
		
		<div class="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
		

	</body>
</html>