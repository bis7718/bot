<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
	<div id="content_wraps">
	<div id="log_div">
	
	<form action="/nova/aprvmgmt/actaprv/log.action" method="post">
	年份：
	<s:select list="yyyyList"
		headerKey=""
		headerValue="全部"
		name="yyyy"
		value="yyyy"
		theme="simple"/>
	月份：
	<s:select list="mmList"
		headerKey=""
		headerValue="全部"
		name="mm"
		value="mm"
		theme="simple"/>
	<s:submit theme="simple" value="送出" />
	<br><br>
	<display:table name="actionApprovesList"
				id="row"
				pagesize="15"
				requestURI="/nova/aprvmgmt/actaprv/log.action"
				export="false"
				class="approve_table">
		<display:column title="執行動作"><s:property value="getText('action_types.'+#attr.row.action_type)"/></display:column>
		<display:column property="params" title="執行參數" class="break"></display:column>
		<display:column property="apply_at" title="請求時間"></display:column>
		<display:column title="提出人員"><s:property value="#attr.row.apply_user+' '+#attr.row.apply_name"/></display:column>
		<display:column property="approve_at" title="審核時間"></display:column>
		<display:column title="審核人員"><s:property value="#attr.row.approve_user+' '+#attr.row.approve_name"/></display:column>
		<display:column title="狀態"><s:property value="getText('status.'+#attr.row.status)"/></display:column>
	</display:table>
	</form>
	
	
	</div>
	</div>