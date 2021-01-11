<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
	<div id="content_wraps">
	<div id="log_div">
	
	<s:set name="functionURL" value="'/nova/aprvmgmt/fileupaprv/'"/>
	<s:set name="sFunctionURL" value="'/aprvmgmt/fileupaprv/'"/>
	<s:set name="actionURL" value="#sFunctionURL+'approveall.action'"/>
	<s:form id="dep_f" action="%{#actionURL}" onsubmit="return new_dep_submit()" theme="simple">
	
	全選:<input type="checkbox" id="chkAll" onclick="select_all()"><input type="submit" value="放行">
	<table id="tb1" class="approve_table">
      <thead>
        <tr>
          <th>勾選</th>
		  <th style="width: 200px">名稱</th>
          <th>檔案</th>
          <th>上傳時間</th>
          <th>上傳人員</th>
		  <th>審核</th>
        </tr>
      </thead>
      <tbody>
		
		<s:iterator value="fileApprovesList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td>
					<s:checkbox id="job_%{id}" name="idList" value="false" fieldValue="%{id}"/>
				</td>
				<td><s:property value="uploadFiles.name"/></td>
				<td class="textAlignLeft">
					<a href='<s:property value="#functionURL"/>download.action?id=<s:property value="id"/>&format=csv'>
						<s:property value='files_name.replaceAll(".csv","")'/>
					</a>
				</td>
				<td><s:property value="upload_at.toString()"/></td>
				<td><s:property value="upload_user+' '+upload_name"/></td>
				<td>
					<div id='act_<s:property value="id"/>'>
						<a href='<s:property value="#functionURL"/>approve.action?id=<s:property value="id"/>' onclick="return(confirm('確定執行動作嗎?'))">放行</a> |
						<a href='<s:property value="#functionURL"/>reject.action?id=<s:property value="id"/>' onclick="return(confirm('確定執行動作嗎?'))">退件</a>
					</div>
					<div id='act_<s:property value="id"/>_loading' style="display: none; text-align:center">
						<img alt="Loading_s" src="/nova/images/loading_s.gif" /> 處理中...
					</div>
				</td>
			</tr>
		</s:iterator>
	  
	  </tbody>
    </table>
	</s:form>
	
	</div>
	</div>