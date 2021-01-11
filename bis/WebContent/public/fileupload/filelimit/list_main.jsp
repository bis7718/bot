<%@page pageEncoding="UTF-8"%>

<div id="content_wraps">
	<h1><b>檔 案 列 表</b></h1>
	<hr>

	<table class="data_tablea">
      <thead>
        <tr>
          <th>ID</th>
		  <th>下載檔名</th>
		  <th>刪除</th>
        </tr>
      </thead>
      <tbody>
		<s:iterator value="fileDownListsList" status="status">
			<s:if test="#status.even"><tr class="even_row"></s:if>
			<s:else><tr class=""></s:else>  
				<td><s:property value="id"/></td>
				<td><s:property value="file_names"/></td>
				<td>
					<s:if test='enable=="N"'>
						<a href='/nova//fileupload/filelimit/delete.action?id=<s:property value="id"/>'
						onclick='return confirm("確定送出刪除<s:property value='file_names'/>申請");'>
						刪除
						</a>
					</s:if>
					<s:elseif test='enable=="Y"'>等待覆核刪除</s:elseif> 
				</td>
			</tr>
		</s:iterator>
    </table>
   
</div>