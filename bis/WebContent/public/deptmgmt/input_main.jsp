<%@page pageEncoding="UTF-8"%>
	<div id="edit_div">
	<s:if test="eventName=='insert'">
	<s:set name="actionURL" value="'/deptmgmt/insert.action'"/>
	</s:if>
	<s:elseif test="eventName=='update'">
	<s:set name="actionURL" value="'/deptmgmt/update.action'"/>
	</s:elseif> 
	
	<s:form action="%{#actionURL}" onsubmit="return new_dep_submit()">
	<s:hidden name="departments.id" />
	<table class="edit_dep_table">
		<s:if test="eventName=='insert'">
		<caption>新增分行</caption>
		</s:if>
		<s:elseif test="eventName=='update'">
		<caption>修改分行</caption>
		</s:elseif> 
		<tfoot>
			<tr><td colspan="2">
				<input type="submit" value="送出" onclick="return(confirm('確認送出申請？'))">
				</td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<s:textfield id="departments_code" key="departments.code" size="30"/>
			</tr>
			<tr>
				<s:textfield id="departments_name" key="departments.name" size="30"/>
			</tr>
			<tr>
				<s:select list="{'Y','N'}"
					id="departments_overseas_flag"
					label="%{getText('departments.overseas_flag')}"
					name="departments.overseas_flag"
					value="departments.overseas_flag"/>
			</tr>
			<tr>
        
			</tr>
		</tbody>
    </table>
   </s:form>
   
   </div>