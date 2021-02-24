<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
		<style><%@include file="/css/aprvmgmt.css"%></style>
		<style><%@include file="/css/auditlog.css"%></style>
		<style><%@include file="/css/batchexec.css"%></style>
		<style><%@include file="/css/common.css"%></style>
		<style><%@include file="/css/deptmgmt.css"%></style>
		<style><%@include file="/css/fileupload.css"%></style>
		<style><%@include file="/css/groupmgmt.css"%></style>
		<style><%@include file="/css/jquery-ui-1.10.3.custom.min.css"%></style>
		<style><%@include file="/css/nova.css"%></style>
		<style><%@include file="/css/reports.css"%></style>
		<style><%@include file="/css/userlogs.css"%></style>
		<style><%@include file="/css/usrmgmt.css"%></style>
		<script type="text/javascript" src="<%=basePath%>js/jquery.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/aprvmgmt.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/auditlog.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/batchexec.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/controls.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/deptmgmt.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/dragdrop.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/effects.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/fileupload.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/groupmgmt.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.6.1.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-min.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.10.3.custom.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.ui.datepicker-zh-TW.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.ui.datepicker.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/nova.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/opaprv.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/rptview.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/userlogs.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=basePath%>js/usrmgmt.js" charset="utf-8"></script>
		