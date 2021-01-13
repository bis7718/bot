<%@page pageEncoding="UTF-8"%>
	<div id="content_wraps">
	<div id="group_div">
	<table class="data_table">
      <thead>
        <tr>
          <th>代碼</th>
          <th>名稱</th>
		  <th style="width: 450px">說明</th>
		  <th>使用者數</th>
        </tr>
      </thead>
      <tbody>
	  
		<s:iterator value="groupsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td>
					<a href='/nova/sysmgmt/groupmgmt/list_sub.action?id=<s:property value="id"/>'>
						<s:property value="sym"/></td>
					</a>
				<td><s:property value="name"/></td>
				<td class="textAlignLeft"><s:property value="desc"/></td>
				<td><s:property value="usersList.size()"/></td>
			</tr>
		</s:iterator>
	  
	  </tbody>
    </table>
	</div>
	</div>