<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="edit_div">

	<form action="${eventName}" onsubmit="return create_user_submit()">
		<table class="edit_user_table">
			<c:if test="${eventName == 'insert'}">
				<caption>新增使用者</caption>
			</c:if>
			<c:if test="${eventName == 'update'}">
				<caption>修改使用者</caption>
			</c:if>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="送出"
						onclick="return(confirm('確認送出申請？'))"> <input type="reset">
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td class="tdLabel"><label>員工編號：</label></td>
					<td colspan="3"><input type="text" id="users_code" size="30"
						value="${users.code}"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>顯示名稱：</label></td>
					<td colspan="3"><input type="text" id="users_name" size="30"
						value="${users.name}"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>所屬部門：</label></td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>帳號啟用：</label></td>
					<td colspan="3"><c:if test="${users.is_valid == 'Y'}">
							<input type="checkbox" id="users_is_valid" value="true">
						</c:if> <c:if test="${eventName == 'insert' || users.is_valid == 'N'}">
							<input type="checkbox" id="users_is_valid" value="false">
						</c:if></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>密碼：</label></td>
					<td colspan="3"><input type="password" id="users_pass"
						size="30" value="${users.pass}"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label>群組指派：</label></td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</form>

</div>