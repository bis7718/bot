<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<display:table name="bisApAuditLogsList"
				id="row"
				pagesize="30"
				requestURI="/nova/sysmgmt/auditlog/batchquery.action"
				export="false"
				class="approve_table">
		<display:column property="user_id" title="使用者"></display:column>
		<display:column property="source_id" title="來源"></display:column>
		<display:column property="destination_id" title="IP"></display:column>
		<display:column property="procedure_name" title="程式名稱"></display:column>
		<display:column property="schema_name" title="存取帳號"></display:column>
		<display:column property="table_name" title="存取物件"></display:column>
		<display:column property="action_type" title="動作"></display:column>
		<display:column property="sql_script" title="語法"></display:column>
		<display:column property="sql_status" title="狀態"></display:column>
		<display:column property="sql_rows" title="資料筆數"></display:column>
		<display:column property="sql_result" title="執行結果"></display:column>
		<display:column property="ss_seq" title="版本"></display:column>
		<display:column property="created_at" title="時間"></display:column>
</display:table>
