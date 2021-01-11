<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
		<link href="<s:url value="/css/common.css"/>" media="screen" rel="stylesheet" type="text/css">
		<link href="<s:url value="/css/nova.css"/>" media="screen" rel="stylesheet" type="text/css">
		<link href="<s:url value="/css/jquery-ui-1.10.3.custom.min.css"/>" media="screen" rel="stylesheet" type="text/css">
		
		<s:if test='%{#session.ie_version.equals("8")}'>
			<script src="<s:url value="/js/jquery-1.6.1.min.js"/>" type="text/javascript"></script>
		</s:if>
		<s:else>
			<script src="<s:url value="/js/jquery.js"/>" type="text/javascript"></script>
		</s:else>
		
		<script src="<s:url value="/js/nova.js"/>" type="text/javascript"></script>
		<script src="<s:url value="/js/jquery-ui-1.10.3.custom.min.js"/>" type="text/javascript"></script>
		<script src="<s:url value="/js/jquery.ui.datepicker-zh-TW.js"/>" type="text/javascript"></script>
		
		<script src="<s:url value="/dwr/engine.js"/>" type="text/javascript"></script>
		<script src="<s:url value="/dwr/util.js"/>" type="text/javascript"></script>
		<script src="<s:url value="/dwr/interface/%{className}.js"/>" type="text/javascript"></script>
		
		<s:if test="%{funcationName!=null}">
		<link href="<s:url value="/css/%{funcationName}.css"/>" media="screen" rel="stylesheet" type="text/css">
		<script src="<s:url value="/js/%{funcationName}.js"/>" type="text/javascript"></script>
		</s:if>
		