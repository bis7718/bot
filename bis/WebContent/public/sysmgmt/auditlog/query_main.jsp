<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="content_wraps">
	<div id="log_div" style="text-align: center;">
		<table class="data_table">
			<thead>
				<tr>
					<th>員編</th>
					<th>IP</th>
					<th>組織別</th>
					<th>控制器</th>
					<th>執行動作</th>
					<th>參數</th>
					<th>註解</th>
					<th>執行SQL</th>
					<th>執行時間</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${auditLogsList}" var="auditLogs">
					<c:if test="${((startDate < auditLogs.updated_at) and (auditLogs.updated_at < endDate)) or (fn:contains(auditLogs.updated_at, endDate))}">
						<tr class="${auditLogs.id}">
							<td>${auditLogs.user_id}</td>
							<td>${auditLogs.ip}</td>
							<td>${auditLogs.companydomain}</td>
							<td>${auditLogs.controller}</td>
							<td>${auditLogs.action}</td>
							<td>${auditLogs.params}</td>
							<td>${auditLogs.status}</td>
							<td>${auditLogs.sqlcommand}</td>
							<td>${auditLogs.updated_at}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>