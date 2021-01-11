<%@page pageEncoding="UTF-8"%>

	<div id="edit_div">
	<s:if test="eventName=='usrmgmt_insert'">
	<s:set name="actionURL" value="'/sysmgmt/usrmgmt/insert.action'"/>
	</s:if>
	<s:elseif test="eventName=='usrmgmt_update'">
	<s:set name="actionURL" value="'/sysmgmt/usrmgmt/update.action'"/>
	</s:elseif> 
	
	<s:form action="%{#actionURL}" onsubmit="return create_user_submit()" theme="simple">
	<s:hidden name="users.id" />
	<table class="edit_user_table">
		<s:if test="eventName=='usrmgmt_insert'">
		<caption>新增使用者</caption>
		</s:if>
		<s:elseif test="eventName=='usrmgmt_update'">
		<caption>修改使用者</caption>
		</s:elseif> 
		<tfoot>
			<tr><td colspan="4">
				<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
				<input type="reset">
				</td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td class="tdLabel"><label for="users_code" class="label">員工編號:</label></td>
				<td colspan="3"><s:textfield id="users_code" key="users.code" size="30"/></td>
			</tr>
			<tr>
				<td class="tdLabel"><label for="users_name" class="label">顯示名稱:</label></td>
				<td colspan="3"><s:textfield id="users_name" key="users.name" size="30"/></td>
			</tr>
			<tr>
				<td class="tdLabel"><label for="users_departments_name" class="label">所屬部門:</label></td>
				<td colspan="3">
					<s:select list="departmentsList"
						id="user_departments"
						name="users.departmentsId"
						listKey="id"
						listValue="code+' '+name"
						value="users.departments.id"/>
				</td>
			</tr>
			<tr>
				<td class="tdLabel"><label for="users_is_valid" class="label">帳號啟用:</label></td>
				<td colspan="3">
					<s:if test='%{users.is_valid=="Y"}'>
						<s:checkbox id="users_is_valid" name="users.is_valid" value="true" fieldValue="%{users.is_valid}" />
					</s:if>  
					<s:else>
						<s:checkbox id="users_is_valid" name="users.is_valid" value="false" fieldValue="Y"/>
					</s:else> 
				</td>
			</tr>
			<tr>
				<td class="tdLabel"><label for="users_name" class="label">密碼:</label></td>
				<td colspan="3"><s:textfield id="users_pass" key="users.pass" size="30"/></td>
			</tr>
			<tr>
				<td class="tdLabel" rowspan="2"><label for="users_groups" class="label">群組指派:</label></td>
				<td class="tdLabel1">所有群組</td>
				<td></td>
				<td class="tdLabel1">使用者群組</td>
			</tr>
			<tr>
				<td>
					<s:select list="unselectGroupsList"
						name="unselectGroupsList"
						listKey="id"
						listValue="name"
						id="unselect_groups"
						multiple="true"
						cssClass="user_group_select"/>
				</td>
				<td>
					<span id="add"> &gt; </span><br>
					<span id="remove"> &lt; </span><br>
				</td>
				<td>
					<s:select list="users.groupsList"
						name="groupsIdList"
						id="user_groups"
						multiple="true"
						listKey="id"
						listValue="name"
						cssClass="user_group_select"/>
				</td>
			</tr>
		</tbody>
    </table>
   </s:form>
   
   </div>