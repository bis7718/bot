<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="content_wraps">
	<div id="log_div" style="text-align: center;">
		<c:choose>
			<c:when test='${confirmFlag.actconfirm == "Y"}'>
				<table class="data_table">
					<thead>
						<tr>
							<th>執行動作</th>
							<th>執行參數</th>
							<th>請求時間</th>
							<th>提出人員</th>
							<th>審核</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${actionApprovesList}" var="actionApproves">
							<c:if test="${actionApproves.status == 'waiting'}">
								<tr class="${actionApproves.id}">
									<td>${actionApproves.action_type}</td>
									<td>${actionApproves.params}</td>
									<td>${actionApproves.apply_at}</td>
									<td>${actionApproves.apply_user}${actionApproves.apply_name}</td>
									<td>放行 | 退件</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
                             無資料 
			</c:otherwise>
		</c:choose>



	</div>
</div>