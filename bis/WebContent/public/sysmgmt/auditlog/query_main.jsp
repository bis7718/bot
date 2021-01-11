<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
 
<display:table name="auditLogsList"
				id="row"
				pagesize="30"
				requestURI="/nova/sysmgmt/auditlog/query.action"
				export="false"
				class="approve_table">
		<display:column property="user_id" title="員編"></display:column>
		<display:column property="ip" title="IP"></display:column>
		<display:column property="companydomain" title="組織別"></display:column>
		<display:column property="controller" title="控制器"></display:column>
		<display:column property="action" title="執行動作"></display:column>
		<display:column property="params" title="參數"></display:column>
		<display:column property="status" title="註解"></display:column>
		<display:column property="sqlcommand" title="執行SQL"></display:column>
		<display:column property="updated_at" title="執行時間"></display:column>
</display:table>
