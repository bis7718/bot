<%@page pageEncoding="UTF-8"%>

	<s:if test='sessionsList.size()==0'>
	<h1>上一次批次已正常結束</h1>
	</s:if>
	<s:else>
	<table class="data_table_job">
      <thead>
        <tr>
          <th>ID</th>
          <th>日期</th>
		  <th>開始時間</th>
		  <th>結束時間</th>
		  <th>sh的PID</th>
		  <th>bossa的PID</th>
		  <th>中止</th>
        </tr>
      </thead>
      <tbody>
	  
		<s:iterator value="sessionsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td>
					<s:property value="id"/>
				</td>
				<td>
					<s:property value='%{datadate.toString().split(" ")[0]}'/>
				</td>
				<td>
					<s:property value='%{start_on.toString()}'/>
				</td>
				<td>
					<s:property value='%{stop_at.toString()}'/>
				</td>
				<td>
					<s:property value="sh_pid"/>
				</td>
				<td>
					<s:property value="bossa_pid"/>
				</td>
				<td>
					<a href='/nova/batchexec/batchmgmt/stopsession.action?id=<s:property value="id"/>'
						onclick='return confirm("確定中止批次<s:property value='id'/>?");'>
					中止
					</a>
				</td>
			</tr>
		</s:iterator>
	  
	  </tbody>
    </table>
	</s:else>