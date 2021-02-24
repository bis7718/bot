<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="content_wraps">
	<div id="log_div" style="text-align: center;">
		<form action="/bis/aprvmgmt/fileupaprv/log" method="post">
			年份： <select id="yyyy">
				<option value="">全部</option>
				<c:forEach items="${yyyyList}" var="yyyy">
					<option value="${yyyy}">${yyyy}</option>
				</c:forEach>
			</select> 月份： <select id="mm">
				<option value="">全部</option>
				<c:forEach items="${mmList}" var="yyyy">
					<option value="${mm}">${mm}</option>
				</c:forEach>
			</select> <input name="commit" type="submit" value="送出">
		</form>
		<table class="data_table">
			<thead>
				<tr>
					<th>檔案</th>
					<th>上傳時間</th>
					<th>上傳人員</th>
					<th>審核時間</th>
					<th>審核人員</th>
					<th>狀態</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fileApprovesList}" var="fileApproves">
					<c:if test='${fileApproves.action_type == "SYSTEM"}'>
						<tr>
							<td>${fileApproves.files_name}</td>
							<td>${fileApproves.upload_at}</td>
							<td>${fileApproves.upload_user}${fileApproves.upload_name}</td>
							<td>${fileApproves.approve_at}</td>
							<td>${fileApproves.approve_user}
								${fileApproves.approve_name}</td>
							<td><c:choose>
									<c:when test="${fileApproves.status == 'approved'}">已覆核</c:when>
									<c:when test="${fileApproves.status == 'rejected'}">退件</c:when>
									<c:otherwise>待審中</c:otherwise>
								</c:choose></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>