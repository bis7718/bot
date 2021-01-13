<%@page pageEncoding="UTF-8"%>

<div id="content_wraps">

  <div id="upload_wrap">
   <s:form action="/fileupload/filemgmt/uploadsysfile.action" theme="simple" enctype="multipart/form-data" method="post"> 
    <table class="upload_table">
 
      <tbody>
	    <tr>
          <td class="left"> 檔案路徑： </td>
          <td class="right">
		    <s:file name="upload" label="瀏覽"></s:file>
			<s:submit value="上傳"></s:submit>
			<input name="isNotCsv" type="checkbox" value="isNotCsv">
			<b>非csv檔案</b>
		  </td>
        </tr> 
      </tbody></table>
      <font style="text-align:left"><h5>註1:csv檔案請加.csv</h5></font>
	  <font style="text-align:left"><h5>註2:特殊檔案請勾選非csv檔案</h5></font>
   </s:form>
  </div>
</div>