<%@page pageEncoding="UTF-8"%>
	<div id="edit_div">
		<form action="/nova/batchexec/jobmgmt/changejob.action" id="ddd" method="post">
		<table class="edit_job_table">
				<caption>調整工作內容</caption>
			<tfoot>
				<tr>
					<td colspan="2">  
						<input type="submit" value="送出" onclick="var reply = confirm('確定送出?')">
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td class="tdLabel">原執行工作:</td>
					<td>
						<s:select theme="simple"
							list="jobsList"
							id="jobs_id"
							name="jobs.id"
							listKey="id"
							listValue="'(' + id + ') ' + name"/>
					</td>
				</tr>
				<tr>
					<td class="tdLabel">前一項工作:</td>
					<td>
						<s:select theme="simple"
							list="jobsList"
							headerKey="0"
							headerValue="(0) 無前項工作"
							id="jobs1_id"
							name="jobs1.id"
							listKey="id"
							listValue="'(' + id + ') ' + name"/>
					</td>
				</tr>     
			</tbody>
		</table>
		<div id="loading_gif" style="display: none; text-align:left"><img alt="Loading_s" src="./工作順序修改_files/loading_s.gif"> 處理中...</div>
	</form>
   
   </div>