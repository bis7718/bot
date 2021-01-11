<%@page pageEncoding="UTF-8"%>
	<div id="content_wraps">
	<div id="user_div">
	<h2>使用者資訊</h2>
	<table class="data_table">
	  <thead>
        <tr>
          <th>指令</th>
		  <th>員工編號</th>
          <th>姓名</th>
		  <th>部門</th>
		  <th>帳號啟用</th>
        </tr>
      </thead>
      <tbody>
	  
		<tr class=""> 
			<td>
				<a href='/nova/sysmgmt/usrmgmt/input.action?id=<s:property value="users.id"/>'>
					修改
				</a>
			</td>
			<td><s:property value="users.code"/></td>
			<td><s:property value="users.name"/></td>
			<td><s:property value="users.departments.code + ' ' + users.departments.name"/></td>
			<td>
				<s:if test='users.is_valid=="N"'>否</s:if>
				<s:elseif test='users.is_valid=="Y"'>是</s:elseif> 
			</td>
		</tr>
	  
	  </tbody>
    </table>
	
	<h2>所屬群組列表</h2>
	<table class="data_table">
      <thead>
        <tr>
          <th>代碼</th>
          <th>名稱</th>
          <th style="width: 450px">說明</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="users.groupsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td>
					<a href='/nova/sysmgmt/groupmgmt/list_sub.action?id=<s:property value="id"/>'>
						<s:property value="sym"/>
					</a>
				</td>
				<td><s:property value="name"/></td>
				<td><s:property value="desc"/></td>
			</tr>
		</s:iterator>
      </tbody>
  </table>
	
	</div>
	</div>