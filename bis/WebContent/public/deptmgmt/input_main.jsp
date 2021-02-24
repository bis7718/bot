<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="edit_div">
	<form action="${eventName}" onsubmit="return(new_dep_submit())">
		<table class="edit_dep_table">
			<c:if test="${eventName == 'insert'}">
				<caption>新增分行</caption>
			</c:if>
			<c:if test="${eventName == 'update'}">
				<caption>修改分行</caption>
			</c:if>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="送出"
						onclick="return(confirm('確認送出申請？'))"></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td class="tdLabel"><label>分行代碼：</label></td>
					<td><input type="text" id="departments_code" size="30"
						value="${dept.code}"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>分行名稱：</label></td>
					<td><input type="text" id="departments_name" size="30"
						value="${dept.name}"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>是否為海外分行(Ｙ/Ｎ)：</label></td>
					<td><select id="departments_overseas_flag">
							<c:choose>
								<c:when test="${eventName == 'insert' || dept.overseas_flag == 'Y'}">
									<option value="Y">Y</option>
									<option value="N">N</option>
								</c:when>
								<c:otherwise>
									<option value="N">N</option>
									<option value="Y">Y</option>
								</c:otherwise>
							</c:choose>

					</select></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>