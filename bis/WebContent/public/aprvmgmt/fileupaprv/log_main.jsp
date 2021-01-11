<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div id="content_wraps">
	<div id="log_div">
	
	<form action="/nova/aprvmgmt/fileupaprv/log.action" method="post">
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
	<display:table name="fileApprovesList"
				id="row"
				pagesize="15"
				requestURI="/nova/aprvmgmt/fileupaprv/log.action"
				export="false"
				class="approve_table">
		<display:column property="uploadFiles.name" title="名稱" class="width200"></display:column>
		
		<c:choose>
            <c:when test="${row.status.equalsIgnoreCase('approved') || row.status.equalsIgnoreCase('rejected')}">
                <c:set var="linkStr" value=""/>
            </c:when>                                              
            <c:otherwise>
                <c:set var="linkStr" value="href='/nova/aprvmgmt/fileupaprv/download.action?id=${row.id}'"/>
            </c:otherwise>
		</c:choose>
		<display:column title="檔案" class="textAlignLeft">
			<a ${linkStr}>
			<s:property value="#attr.row.files_name"/>
			</a>
		</display:column>
		
		<display:column property="upload_at" title="上傳時間"></display:column>
		<display:column title="上傳人員"><s:property value="#attr.row.upload_user+' '+#attr.row.upload_name"/></display:column>
		<display:column property="approve_at" title="審核時間"></display:column>
		<display:column title="審核人員"><s:property value="#attr.row.approve_user+' '+#attr.row.approve_name"/></display:column>
		<display:column title="狀態">
			<s:property value="getText('status.'+#attr.row.status)"/>
		</display:column>
	</display:table>
	</form>
	
	</div>
	</div>