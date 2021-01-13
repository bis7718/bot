<%@page pageEncoding="UTF-8"%>

<div id="edit_div">
	<form id="dep_f" method="post" action="/nova/fileupload/filelimit/insert.action">
		<table class="edit_filedown_table">
			<tbody>
				<tr>
					<td class="left_col">檔案名稱</td>
					<td>
						<input id="file_file_names" name="fileDownLists.file_names" size="30" type="text">
					</td>
					<td>
						<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
					</td>
				</tr>
		
			</tbody>
		</table>
	</form>
</div>