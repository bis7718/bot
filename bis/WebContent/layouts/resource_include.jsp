<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<style><%@include file="/css/common.css"%></style>
		<style><%@include file="/css/nova.css"%></style>
		<style><%@include file="/css/jquery-ui-1.10.3.custom.min.css"%></style>

		<c:choose>
            <c:when test='%{#session.ie_version.equals("8")}'>
                <script src="/js/jquery-1.6.1.min.js"></script>
            </c:when> 
            <c:otherwise>
                <script src="/js/jquery.js"></script>
            </c:otherwise>
		</c:choose>
		<script src="/js/nova.js"></script>
		<script src="/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="/js/jquery.ui.datepicker-zh-TW.js"></script>
		
		<script src="dwr/engine.js"></script>
		<script src="dwr/util.js"></script>
		<script src="dwr/interface/%{className}.js"></script>
		
		<c:choose>
            <c:when test='%{funcationName!=null}'>
                <link href="<c:url value="/css/%{funcationName}.css"/>" media="screen" rel="stylesheet" type="text/css">
                <script src="/js/%{funcationName}.js"></script>
            </c:when> 
		</c:choose>
		