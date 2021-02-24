<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="edit_div" >
	<form action="${eventName}">
		<table class="edit_job_table">
			<c:if test="${eventName == 'insert'}">
				<caption>新增工作</caption>
			</c:if>
			<c:if test="${eventName == 'update'}">
				<caption>修改工作內容</caption>
			</c:if>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="送出"
						onclick="return(confirm('確認送出？'))"></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td class="tdLabel"><label for="jobs_id" class="label">ID:</label></td>
					<td class="font13"><input type="text" value="${jobs.id}"
						id="jobs_id"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label for="jobs_id" class="label">名稱:</label></td>
					<td class="font13"><input type="text" value="${jobs.name}"
						id="jobs_name"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label for="jobs_action" class="label">動作:</label></td>
					<td class="font13"></td>
				</tr>
				<tr>
					<td class="tdLabel"><label for="jobs_command" class="label">指令:</label></td>
					<td class="font13"><textarea id="jobs_command" rows="3"
							cols="25">${jobs.command}</textarea></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>