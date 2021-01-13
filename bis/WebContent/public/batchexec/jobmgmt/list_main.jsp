<%@page pageEncoding="UTF-8"%>
	
	<div>
		<form id="dep_f" method="post" action="/nova/batchexec/jobmgmt/jobopen.action">
			<b>工作階段選擇</b>:
			<input id="job_st1" name="jobType['st1']" type="checkbox" value="1">資料檢核階段
			<input id="job_st2" name="jobType['st2']" type="checkbox" value="1">資料匯整階段
			<input id="job_proc" name="jobType['proc']" type="checkbox" value="1">主管機關報表邏輯
			<input id="job_procma" name="jobType['procma']" type="checkbox" value="1">管理性報表邏輯
			<input id="job_report" name="jobType['report']" type="checkbox" value="1">產生全行報表
			<input id="job_reportma" name="jobType['reportma']" type="checkbox" value="1">產生分行報表
			<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
		</form>
		<hr>
	</div>    
	
	<table class="data_table_job">
      <thead>
        <tr>
          <th>ID</th>
		  <th>動作</th>
          <th>名稱</th>
		  <th>開啟/關閉</th>
		  <th>刪除</th>
        </tr>
      </thead>
      <tbody>
	  
		<s:iterator value="jobsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td><s:property value="id"/></td>
				<td><s:property value="job_type"/></td>
				<td class="textAlignLeft">
					<a href='/nova/batchexec/jobmgmt/input.action?id=<s:property value="id"/>'>
						<s:property value="name"/>
					</a>
				</td>
				<td>
					<s:if test='enable=="OPEN"'>開啟</s:if>
					<s:elseif test='enable=="CLOSE"'>關閉</s:elseif> 
				</td>
				<td>
					<a href='/nova/batchexec/jobmgmt/delete.action?jobs.id=<s:property value="id"/>'
						onclick='return confirm("確定刪除工作<s:property value='name'/>");'>
					刪除
					</a>
				</td>
			</tr>
		</s:iterator>
	  
	  </tbody>
    </table>