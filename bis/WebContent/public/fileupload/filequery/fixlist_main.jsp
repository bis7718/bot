<%@page pageEncoding="UTF-8"%>

<div id="content_wraps">
	<div style="text-align: left">
		<h1>總共<s:property value="fileInfoList.size()" />個檔案(<s:property value="folderPath" />)</h1>
	</div>

    <table class="data_table">
      <thead>
        <tr>
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
		    <s:url var="deletefile" action="deletefile" escapeAmp="false">
		      <s:param name="type">fix</s:param>
			  <s:param name="filename"><s:property value="fileName" /></s:param>
			</s:url>
		    <a href='<s:property value="#deletefile" />' onclick="return confirm('確定刪除檔案<s:property value="fileName" />?');">刪除</a>
		  </td>
		  <td style="text-align: left">
			<s:url var="download" action="download" escapeAmp="false">
		      <s:param name="type">fix</s:param>
			  <s:param name="filename"><s:property value="fileName" /></s:param>
			</s:url>
			 <a href='<s:property value="#download" />'><s:property value="fileName" /></a>
		  </td>
		  <td><s:property value="fileSize" /></td>
		  <td><s:date name="fileUpatetime" format="yyyy-MM-dd  HH:mm:ss " /></td>
		</s:iterator>       
      </tbody>
    </table>
</div>