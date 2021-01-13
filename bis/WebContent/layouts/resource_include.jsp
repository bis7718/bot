<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<style><%@include file="/css/common.css"%></style>
		<style><%@include file="/css/nova.css"%></style>
		<style><%@include file="/css/jquery-ui-1.10.3.custom.min.css"%></style>
		<%-- <link href="<c:url value="/css/common.css"/>" media="screen" rel="stylesheet" type="text/css">
		<link href="<c:url value="/css/nova.css"/>" media="screen" rel="stylesheet" type="text/css">
		<link href="<c:url value="/css/jquery-ui-1.10.3.custom.min.css"/>" media="screen" rel="stylesheet" type="text/css"> --%>
		<c:choose>
            <c:when test='%{#session.ie_version.equals("8")}'>
                <script type="text/javascript" src="<c:url value="/js/jquery-1.6.1.min.js"/>"></script>
            </c:when> 
            <c:otherwise>
                <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
            </c:otherwise>
		</c:choose>
		<script type="text/javascript" src="<c:url value="/js/nova.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.10.3.custom.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.ui.datepicker-zh-TW.js"/>"></script>
		
		<script type="text/javascript" src="<c:url value="/dwr/engine.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/dwr/util.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/dwr/interface/%{className}.js"/>"></script>
		
		<c:choose>
            <c:when test='%{funcationName!=null}'>
                <link href="<c:url value="/css/%{funcationName}.css"/>" media="screen" rel="stylesheet" type="text/css">
                <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
            </c:when> 
		</c:choose>
		