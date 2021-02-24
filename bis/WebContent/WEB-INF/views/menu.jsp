<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${user.menusList}" var="item">
	<c:choose>
		<c:when test='%{${item.link}.equals("")}'>
                ${item.name}|
            </c:when>
		<c:otherwise>
			<a href='${item.link}'>${item.name}</a>|
            </c:otherwise>
	</c:choose>
</c:forEach>