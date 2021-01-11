<%@page pageEncoding="UTF-8"%>
	<div id="content_wraps">
	<table class="data_table">
      <thead>
        <tr>
          <th>分行代碼</th>
          <th>分行名稱</th>
		  <th>國內/海外</th>
		  <th>刪除</th>
        </tr>
      </thead>
      <tbody>
	  
		<s:iterator value="departmentsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td><s:property value="code"/></td>
				<td>
					<a href='/nova/deptmgmt/input.action?id=<s:property value="id"/>'>
						<s:property value="name"/>
					</a>
				</td>
				<td>
					<s:if test='overseas_flag=="N"'>國內</s:if>
					<s:elseif test='overseas_flag=="Y"'>海外</s:elseif> 
				</td>
				<td>
					<a href='/nova/deptmgmt/delete.action?id=<s:property value="id"/>'
						onclick='return confirm("確定申請刪除分行<s:property value='name'/>");'>
					刪除
					</a>
				</td>
			</tr>
		</s:iterator>
	  
	  </tbody>
    </table>
	</div>