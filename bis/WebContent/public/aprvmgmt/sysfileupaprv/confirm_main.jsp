<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="content_wraps">
	<div id="log_div" style="text-align: center;">
		<c:choose>
			<c:when test='${confirmFlag.sysfileconfirm == "Y"}'>
				<form action="/bis/aprvmgmt/fileupaprv/log" method="post">
					全選： <input id="submitall" type="checkbox" value="1"> <input
						name="commit" type="submit" value="放行"> <br> <br>
					<table class="data_table">
						<thead>
							<tr>
								<th>勾選</th>
								<th>名稱</th>
								<th>檔案</th>
								<th>上傳時間</th>
								<th>上傳人員</th>
								<th>審核</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${fileApprovesList}" var="fileApproves">
								<c:if
									test='${fileApproves.action_type == "SYSTEM" && fileApproves.status == "waiting"}'>
									<tr class="${fileApproves.id}">
										<td><input id="${fileApproves.id}" type="checkbox"
											value="1"></td>
										<td>${fileApproves.uploadFiles.name}</td>
										<td>${fileApproves.files_name}</td>
										<td>${fileApproves.upload_at}</td>
										<td>${fileApproves.upload_user}&ensp;${fileApproves.upload_name}</td>
										<td></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				無資料
			</c:otherwise>
		</c:choose>
	</div>
</div>