<%@page pageEncoding="UTF-8"%>
	<div id="edit_div">
	<s:if test="eventName=='groupmgmt_insert'">
	<s:set name="actionURL" value="'/sysmgmt/groupmgmt/insert.action'"/>
	</s:if>
	<s:elseif test="eventName=='groupmgmt_update'">
	<s:set name="actionURL" value="'/sysmgmt/groupmgmt/update.action'"/>
	</s:elseif> 
	
	<s:form action="%{#actionURL}" onsubmit="return create_group_submit()" theme="simple">
	<s:hidden name="groups.id" />
	<table class="edit_group_table">
		<s:if test="eventName=='groupmgmt_insert'">
		<caption>新增群組</caption>
		</s:if>
		<s:elseif test="eventName=='groupmgmt_update'">
		<caption>修改群組</caption>
		</s:elseif> 
		<tfoot>
			<tr><td colspan="4">
				<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
				</td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td class="tdLabel"><label for="groups_sym" class="label">群組代碼:</label></td>
				<td colspan="3"><s:textfield id="groups_sym" key="groups.sym" size="30"/></td>
			</tr>
			<tr>
				<td class="tdLabel"><label for="groups_name" class="label">群組名稱:</label></td>
				<td colspan="3"><s:textfield id="groups_name" key="groups.name" size="30"/></td>
			</tr>
			<tr>
				<td class="tdLabel"><label for="groups_desc" class="label">群組說明:</label></td>
				<td colspan="3"><s:textfield id="groups_desc" key="groups.desc" size="30"/></td>
			</tr>
			<tr>
				<td class="tdLabel" rowspan="2"><label for="groups_functions" class="label">功能指派:</label></td>
				<td class="tdLabel1">所有功能</td>
				<td></td>
				<td class="tdLabel1">群組功能</td>
			</tr>
			<tr>
				<td>
					<s:select list="unselectFunctionsList"
						name="unselectFunctionsList"
						listKey="id"
						listValue="desc"
						id="unselect_functions"
						multiple="true"
						cssClass="edit_group_select"/>
				</td>
				<td>
					<span id="add"> &gt; </span><br>
					<span id="remove"> &lt; </span><br>
				</td>
				<td>
					<s:select list="groups.functionsList"
						name="functionsIdList"
						id="group_functions"
						multiple="true"
						listKey="id"
						listValue="desc"
						cssClass="edit_group_select"/>
				</td>
			</tr>
		</tbody>
    </table>
   </s:form>
   
   </div>