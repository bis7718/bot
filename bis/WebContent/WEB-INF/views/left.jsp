<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<input id="updatesym" type="hidden" value="">
<c:forEach items="${user.currentFunctionsList}" var="item">
	<c:set var="tmpSym"
		value='${fn:substring(item.sym, 0, fn:indexOf(item.sym, "_")+2)}' />
	<c:if test="${tmpSym == item.sym}">
		<h3>${item.name}</h3>
	</c:if>
	<ul>
		<c:if test="${tmpSym != item.sym}">
			<c:if test="${setSym == item.sym}">
				<li>[${item.name}]</li>
			</c:if>
			<c:if test="${setSym != item.sym}">
				<li><a href="${item.url}">${item.name}</a></li>
			</c:if>
		</c:if>
	</ul>
</c:forEach>