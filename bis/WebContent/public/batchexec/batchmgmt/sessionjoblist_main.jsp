<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
	<a href="/nova/errorcode.action" target="_blank">錯誤代碼一覽表</a>
	
	<s:set name="sessionId" value="currentSession.id"/>
	
	<s:if test='isOpenJob=="Y"'>
	<div style="text-align:left" ,="" padding:="" 3px="" 50px=""> 
		<b>註1:批次卡住請勿打勾</b><br>
		<b>註2:如需分段執行批次請打勾</b>
		<form id="ses_f" name="ses_f" method="post" action="/nova/batchexec/batchmgmt/sessionrun.action">
			<table class="data_tabletest">
				<tbody>
					<tr>
						<td>是否從中斷點繼續執行工作(批次號碼<s:property value="#sessionId"/>)
							<input type="submit" name="ses_s" value="確定" onClick="sessionrun_submit();">
							<input id="job_open" name="opencheck" type="checkbox" value="1" >是否開啟關閉工作
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="sessionId" value='<s:property value="#sessionId"/>'>
		</form>	
	</div>
	</s:if>
   
	<table class="data_tablejobs">
      <thead>
        <tr>
          <th>ID</th>
          <th>動作</th>
          <th>名稱</th>
          <th>開始時間</th>
          <th>結束時間</th>
          <th>結果</th>
		  <th>開啟/關閉</th>
		  
        </tr>
      </thead>
      <tbody>
		<s:iterator value="jobsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td><s:property value="id"/></td>
				<td>
					<s:if test='action=="SQLLDR"'>資料檢核階段</s:if>
					<s:elseif test='command=="BAD"'>產生BAD.tar檔案</s:elseif> 
					<s:elseif test='command=="LOG"'>產生LOG.tar檔案</s:elseif> 
					<s:elseif test='command=="PDF"'>產生PDF.tar檔案</s:elseif> 
					<s:elseif test='command.substring(0,3)=="PKG"'>資料匯整階段</s:elseif> 
					<s:elseif test='command.substring(0,3)=="USP"'>業務邏輯</s:elseif> 
					<s:elseif test='action=="CMD"'>產生PDF報表</s:elseif> 
				</td>
				<td><s:property value="name"/></td>
				<td style="text-align: left"><s:property value="start_on"/></td>
				<td><s:property value="stop_at"/></td>
				<td><s:property value="result"/></td>
				<td>
					<s:if test='enable=="OPEN"'>開啟</s:if>
					<s:elseif test='enable=="CLOSE"'>關閉</s:elseif> 
				</td>
			</tr>
		</s:iterator>
            </tbody>
    </table>


    </div>