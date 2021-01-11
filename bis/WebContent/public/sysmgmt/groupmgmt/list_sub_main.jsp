<%@page pageEncoding="UTF-8"%>

	<div id="content_wraps">
	<div id="group_div">
	<h2>群組資訊</h2>
	<table class="data_table">
	  <thead>
        <tr>
          <th>指令</th>
		  <th>代碼</th>
          <th>名稱</th>
		  <th style="width: 450px">說明</th>
        </tr>
      </thead>
      <tbody>
	  
		<tr class=""> 
			<td>
				<a href='/nova/sysmgmt/groupmgmt/input.action?id=<s:property value="groups.id"/>'>
					修改
				</a>
			</td>
			<td><s:property value="groups.sym"/></td>
			<td><s:property value="groups.name"/></td>
			<td class="textAlignLeft"><s:property value="groups.desc"/></td>
		</tr>
	  
	  </tbody>
    </table>
	
	<h2>賦予使用者清單</h2>
	<table class="data_table">
      <thead>
        <tr>
          <th>代碼</th>
          <th>名稱</th>
          <th>所屬部門</th>
		  <th>帳號啟用</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="groups.usersList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td>
					<a href='/nova/sysmgmt/usrmgmt/list_sub.action?id=<s:property value="id"/>'>
						<s:property value="code"/>
					</a>
				</td>
				<td><s:property value="name"/></td>
				<td><s:property value="departments.code + ' ' + departments.name"/></td>
				<td>
					<s:if test='is_valid=="N"'>否</s:if>
					<s:elseif test='is_valid=="Y"'>是</s:elseif> 
				</td>
			</tr>
		</s:iterator>
      </tbody>
  </table>
  
  <h2>擁有功能列表</h2>
	<table class="data_table">
      <thead>
        <tr>
          <th>代碼</th>
          <th>名稱</th>
          <th style="width: 450px">說明</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="groups.functionsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td><s:property value="sym"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="desc"/></td>
			</tr>
		</s:iterator>
      </tbody>
  </table>
	
	</div>
	</div>