<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Multiple Language -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="message" />

<html>
<div class="login_form">
	<form action="check" id="signin_f" method="post" autocomplete="off">
		<table style="width: 99%" summary="login form">
			<thead>
				<tr class="trFont">
					<th colspan="2">使用者登入</th>
				</tr>
			</thead>
			<tbody>
				<tr class="trFont">
					<td><label for="username"><fmt:message key="LB_ACCT" /></label></td>
					<td><input id="username" name="username" type="text"></td>
				</tr>
				<tr class="trFont">
					<td><label for="password"><fmt:message key="LB_PWD" /></label></td>
					<td><input id="password" name="password" type="password" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						name="commit" type="submit" value="送出"> <input
						type="reset" value="清除"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<div id="message" style="display: block">
		<c:if test="${not empty message}">
        	${message}
        </c:if>
	</div>
</div>
</html>