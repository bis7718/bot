<%@page pageEncoding="UTF-8"%>

<div id="content_wraps">
	<div id="upload_wrap">
	<s:form action="/fileupload/filemgmt/uploadfile.action" theme="simple" enctype="multipart/form-data" method="post" onsubmit="return do_submit()">
	<table class="upload_table">
		<tbody>
			<tr>
				<td class="left">選擇單位：</td>
				<td class="right" rowspan="2">
					<s:doubleselect name="departmentsCode"
						list="departmentsList"
						listKey="code"
						listValue="code+' '+name"
						value="code"
						doubleName="uploadFilesId"
						doubleList="uploadFilesList"
						doubleListKey="id"
						doubleListValue="code+' '+name"
						/>
				</td>
			</tr>
			<tr>
				<td class="left">檔案名稱：</td>
                                <td class="left">
                                </td>
			</tr>
			<tr>
				<td class="left">檔案路徑：</td>
				<td class="right">
					<s:file name="upload" label="瀏覽"></s:file>
					<s:submit value="上傳"></s:submit>
                                        <a id="file_link_1" href="/nova/fileupload/filemgmt/exampledownload?filename=RISK-BR008-BOND-ACCUMLOSS.xls">範例下載-xls</a>
                                        <a id="file_link" href="/nova/fileupload/filemgmt/exampledownload?filename=RISK-BR008-BOND-ACCUMLOSS.ods">範例下載-ods</a>
				</td>
			</tr>
		</tbody>
	</table>
	</s:form>
	</div>
</div>
