<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="content_wraps">
	<div id="log_div" style="text-align: center;">
		<table class="data_table">
			<thead>
				<tr>
					<th>使用者</th>
					<th>來源</th>
					<th>IP</th>
					<th>程式名稱</th>
					<th>存取帳號</th>
					<th>存取物件</th>
					<th>動作</th>
					<th>語法</th>
					<th>狀態</th>
					<th>資料筆數</th>
					<th>執行結果</th>
					<th>版本</th>
					<th>時間</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${apAuditLogsList}" var="apAuditLogs">
					<c:if test="${((startDate < apAuditLogs.created_at) and (apAuditLogs.created_at < endDate)) or (fn:contains(apAuditLogs.created_at, endDate))}">
						<tr class="${apAuditLogs.id}">
							<td>${apAuditLogs.user_id}</td>
							<td>${apAuditLogs.source_id}</td>
							<td>${apAuditLogs.destination_id}</td>
							<td>${apAuditLogs.procedure_name}</td>
							<td>${apAuditLogs.schema_name}</td>
							<td>${apAuditLogs.table_name}</td>
							<td>${apAuditLogs.action_type}</td>
							<td>${apAuditLogs.sql_script}</td>
							<td>${apAuditLogs.sql_status}</td>
							<td>${apAuditLogs.sql_rows}</td>
							<td>${apAuditLogs.sql_result}</td>
							<td>${apAuditLogs.ss_seq}</td>
							<td>${apAuditLogs.created_at}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>