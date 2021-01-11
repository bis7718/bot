<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
	<div id="content_wraps">
	<div id="log_div">
	
	<display:table name="fileApprovesList"
				id="row"
				pagesize="15"
				requestURI="/nova/aprvmgmt/sysfileupaprv/confirm.action"
				export="false"
				class="approve_table">
		<display:column property="files_name" title="檔案"></display:column>
		<display:column property="upload_at" title="上傳時間"></display:column>
		<display:column title="上傳人員"><s:property value="#attr.row.upload_user+' '+#attr.row.upload_name"/></display:column>
		<display:column title="審核">
			<div id='act_<s:property value="id"/>'>
				<a href='/nova/aprvmgmt/sysfileupaprv/approve.action?id=<s:property value="#attr.row.id"/>' onclick="return(confirm('確定執行動作嗎?'))">放行</a> |
				<a href='/nova/aprvmgmt/sysfileupaprv/reject.action?id=<s:property value="#attr.row.id"/>' onclick="return(confirm('確定執行動作嗎?'))">退件</a>
            </div>
			<div id='act_<s:property value="id"/>_loading' style="display: none; text-align:center">
				<img alt="Loading_s" src="/nova/images/loading_s.gif" /> 處理中...
			</div>
		</display:column>
	</display:table>
	</div>
	</div>