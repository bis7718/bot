<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<script type="text/javascript">
    
    function Check(id){
    	var answer = confirm('確定執行動作嗎?');
		if (answer == true) {
		  document.getElementById("act_" + id + "_loading").style.display = "block";
		  document.getElementById("act_" + id).style.display = "none";
        }
		return(answer)
    }

</script>
<s:head />
	<div id="content_wraps">
	<div id="log_div">
	
	<display:table name="actionApprovesList"
				id="row"
				pagesize="15"
				requestURI="/nova/aprvmgmt/actaprv/confirm.action"
				export="false"
				class="approve_table">
		<display:column title="執行動作"><s:property value="getText('action_types.'+#attr.row.action_type)"/></display:column>
		<display:column property="params" title="執行參數" class="break"></display:column>
		<display:column property="apply_at" title="請求時間"></display:column>
		<display:column title="提出人員"><s:property value="#attr.row.apply_user+' '+#attr.row.apply_name"/></display:column>
		<display:column title="審核">
			<div id='act_<s:property value="#attr.row.id"/>'>
				<a href='/nova/aprvmgmt/actaprv/approve.action?id=<s:property value="#attr.row.id"/>' onclick="return(Check(<s:property value="#attr.row.id"/>))">放行</a> |
				<a href='/nova/aprvmgmt/actaprv/reject.action?id=<s:property value="#attr.row.id"/>' onclick="return(Check(<s:property value="#attr.row.id"/>))">退件</a>
            </div>
			<div id='act_<s:property value="#attr.row.id"/>_loading' style="display: none">
				<img alt="Loading_s" src="/nova/images/loading_s.gif" /> 處理中...
			</div>
		</display:column>
	</display:table>
	
	</div>
	</div>