<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
   
	<table class="data_tablejobs">
      <thead>
        <tr>
          <th>ID</th>
          <th>動作</th>
          <th>名稱</th>
          <th>開始時間</th>
          <th>結束時間</th>
          <th>結果</th>
		  <th>檔案查詢</th>
		  
        </tr>
      </thead>
      <tbody>
		<s:set name="logURL" value="'/nova/batchexec/batchmgmt/viewlog.action'"/>
		<s:set name="badURL" value="'/nova/batchexec/batchmgmt/viewbad.action'"/>
		
		<s:set name="sessionId" value="currentSession.id"/>
		<s:iterator value="jobsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td><s:property value="id"/></td>
				<td><s:property value="action"/></td>
				<td><s:property value="name"/></td>
				<td style="text-align: left"><s:property value="start_on"/></td>
				<td><s:property value="stop_at"/></td>
				<td><s:property value="result"/></td>
				<td>
					<a href="<s:property value='#logURL + "?sessionId=" + #sessionId + "&jobId=" + id'/>" target="_blank">log</a> |
					<a href="<s:property value='#badURL + "?sessionId=" + #sessionId + "&jobId=" + id'/>" target="_blank">bad</a>
				</td>
			</tr>
		</s:iterator>
            </tbody>
    </table>


    </div>