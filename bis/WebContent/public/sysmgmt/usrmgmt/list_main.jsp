<%@page pageEncoding="UTF-8"%>
	<div id="content_wraps">
	<div id="user_div">
	
	<s:set name="sFunctionURL" value="'/sysmgmt/usrmgmt/'"/>
	<s:set name="actionURL" value="#sFunctionURL+'deleteall.action'"/>
	<s:form id="dep_f" action="%{#actionURL}" onsubmit="return delete_user_submit()" theme="simple">
	
	全選:<input type="checkbox" id="chkAll" onclick="select_all()"><input type="submit" value="刪除" onclick='return confirm("確定申請刪除多位使用者？");'>
	
	<table id="tb1" class="data_table">
      <thead>
        <tr>
          <th>勾選</th>
          <th>ID</th>
		  <th>員工編號</th>
          <th>姓名</th>
		  <th>部門</th>
		  <th>刪除</th>
        </tr>
      </thead>
      <tbody>
	  
		<s:iterator value="usersList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
			    <td>
					<s:checkbox id="job_%{id}" name="idList" value="false" fieldValue="%{id}"/>
				</td>
				<td><s:property value="id"/></td>
				<td>
					<a href='/nova/sysmgmt/usrmgmt/list_sub.action?id=<s:property value="id"/>'>
						<s:property value="code"/>
					</a>
				</td>
				<td><s:property value="name"/></td>
				<td><s:property value="departments.code"/> <s:property value="departments.name"/></td>
				<td>
					<a href='/nova/sysmgmt/usrmgmt/delete.action?id=<s:property value="id"/>'
						onclick='return confirm("確定申請刪除使用者<s:property value='name'/>");'>
					刪除
					</a>
				</td>
			</tr>
		</s:iterator>
	  
	  </tbody>
    </table>
    </s:form>
    
	</div>
	</div>