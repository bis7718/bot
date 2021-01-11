<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
	   
<html>

<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>The page you were looking for doesn't exist (404)</title>
	<style type="text/css">
		body { background-color: #fff; color: #666; text-align: center; font-family: arial, sans-serif; }
		div.dialog {
			width: 25em;
			padding: 0 4em;
			margin: 4em auto 0 auto;
			border: 1px solid #ccc;
			border-right-color: #999;
			border-bottom-color: #999;
		}
		h1 { font-size: 100%; color: #f00; line-height: 1.5em; }
	</style>
	<s:include value="/layouts/resource_include.jsp"></s:include>
</head>

<body onload="showMessage();">
  <div id="message" style="display:none"><s:property value="message"/></div>
  <div class="dialog">
  <h1>The resource you were looking for doesn't exist.</h1>
    <p>資源不存在</p>
  </div>
</body>
</html>