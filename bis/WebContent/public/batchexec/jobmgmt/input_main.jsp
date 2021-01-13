<%@page pageEncoding="UTF-8"%>
	<div id="edit_div">
	<s:if test="eventName=='insert'">
	<s:set name="actionURL" value="'/batchexec/jobmgmt/insert.action'"/>
	</s:if>
	<s:elseif test="eventName=='update'">
	<s:set name="actionURL" value="'/batchexec/jobmgmt/update.action'"/>
	</s:elseif> 
	
	<s:form action="%{#actionURL}" onsubmit="return new_job_submit()">

	<table class="edit_job_table">
		<s:if test="eventName=='insert'">
		<caption>新增工作</caption>
		</s:if>
		<s:elseif test="eventName=='update'">
		<caption>修改工作內容</caption>
		</s:elseif> 
		<tfoot>
			<tr><td colspan="2">
				<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
				</td>
			</tr>
		</tfoot>
		<tbody>
			<s:if test="eventName=='insert'">
				<s:textfield id="jobs_id" key="jobs.id" size="30"/>
			</s:if>
			<s:elseif test="eventName=='update'">
				<tr>
					<td class="tdLabel"><label for="jobs_id" class="label">ID:</label></td>
					<td class="font13">
						<s:property value="jobs.id"/>
						<s:hidden name="jobs.id" id="jobs_id" />
					</td>
				</tr>
			</s:elseif> 
			<s:hidden name="jobs.object_type" value="1" />			
			<s:textfield id="jobs_name" key="jobs.name" size="30"/>
			<s:select list="jobWorksList"
					id="jobs_action"
					key="jobs.action"
					name="jobs.action"
					listKey="job_action"
					listValue="job_action"
					value="jobs.action"/>
			
			<s:textarea id="jobs_command" key="jobs.command" rows="3" cols="25" cssClass="fontTA"/>
			
			<s:if test="eventName=='update'">
			<tr>
				<td class="tdLabel">
					<label for="jobs_enable" class="label"><s:property value="getText('jobs.enable')"/>:</label>
				</td>
				<td>
					<s:if test='%{jobs.enable=="OPEN"}'>
						<s:checkbox theme="simple" name="jobs.enable" value="true" fieldValue="%{jobs.enable}" />
					</s:if>  
					<s:else>
						<s:checkbox theme="simple" name="jobs.enable" value="false" fieldValue="OPEN"/>
					</s:else> 
				</td>
			</tr>
			</s:if>
		</tbody>
    </table>
   </s:form>
   
   </div>