<%@page pageEncoding="UTF-8"%>

<div id="content_wraps">
	<div style="text-align: left">
		<h1>總共<s:property value="fileInfoList.size()" />個檔案(<s:property value="filePath" />)</h1>
	</div>
	<div style="text-align: center">
	<s:set name="sFunctionURL" value="'/batchexec/filemgmt/'"/>
	<s:set name="actionURL" value="#sFunctionURL+'deletefileall.action'"/>
	<s:form id="dep_f" action="%{#actionURL}" onsubmit="return delete_file_submit()" theme="simple">
	
	全選:<input type="checkbox" id="chkAll" onclick="select_all()"><input type="submit" value="刪除" onclick='return confirm("確定刪除多個檔案？");'>
	</div>
    <table id="tb1" class="data_table">
      <thead>
        <tr>
          <th>勾選</th>
          <th>刪除檔案</th>
          <th>檔案</th>
          <th>檔案大小</th>
          <th>更新時間</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="fileInfoList" status="status">
		  <s:if test="#status.even"><tr class="even_row"></s:if>
		  <s:else><tr class=""></s:else>
		  <td>
			<s:checkbox id="job_%{fileName}" name="idList" value="false" fieldValue="%{fileName}"/>
		  </td>
		  <td>
		    <s:url var="deletefile" action="deletefile" escapeAmp="false">
			  <s:param name="filename"><s:property value="fileName" /></s:param>
			</s:url>
		    <a href='<s:property value="#deletefile" />' onclick="return confirm('確定刪除檔案<s:property value="fileName" />?');">刪除</a>
		  </td>
		  <td>
			<s:url var="downloadlog" action="downloadlog" escapeAmp="false">
		    <s:param name="filename"><s:property value="fileName" /></s:param>
			</s:url>
			<a href="<s:property value="#downloadlog" />" ><s:property value="fileName" /></a>
		  </td>
		  <td><s:property value="fileSize" /></td>
		  <td><s:date name="fileUpatetime" format="yyyy-MM-dd  HH:mm:ss " /></td>
		</s:iterator>       
      </tbody>
    </table>
    </s:form>
</div>