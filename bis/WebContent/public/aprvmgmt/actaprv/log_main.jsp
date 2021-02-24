<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	function get_mm() {
		alert(document.getElementById("dateList"));
	}
</script>
<c:set var="mmList" value="" />
<div id="content_wraps">
	<div id="log_div" style="text-align: center;">
		<form action="/bis/aprvmgmt/actaprv/log_filter" method="post">
			年份： <select id="yyyy" onchange="get_mm()">
				<option value="">全部</option>
				<c:forEach items="${dateList}" var="date">
					<option value="${date.key}">${date.key}</option>
				</c:forEach>
			</select>&ensp; 
			月份： <select id="mm">
				<option value="">全部</option>
			</select>&ensp; 
			<input name="commit" type="submit" value="送出">
		</form>
		<table class="data_table">
			<thead>
				<tr>
					<th>執行動作</th>
					<th>執行參數</th>
					<th>請求時間</th>
					<th>提出人員</th>
					<th>審核時間</th>
					<th>審核人員</th>
					<th>狀態</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${actionApprovesList}" var="actionApproves"
					begin="1" end="15" step="1">
					<tr class="${actionApproves.id}">
						<td>${actionApproves.action_type}</td>
						<td>${actionApproves.params}</td>
						<td>${actionApproves.apply_at}</td>
						<td>${actionApproves.apply_user}&ensp;${actionApproves.apply_name}</td>
						<td>${actionApproves.approve_at}</td>
						<td>${actionApproves.approve_user}&ensp;${actionApproves.approve_name}</td>
						<td><c:choose>
								<c:when test="${actionApproves.status == 'approved'}">已覆核</c:when>
								<c:when test="${actionApproves.status == 'rejected'}">退件</c:when>
								<c:otherwise>待審中</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		第 1 - 15 筆,共${fn:length(actionApprovesList)}筆 [第一頁/前一頁] [下一頁/最末頁]
	</div>
</div>