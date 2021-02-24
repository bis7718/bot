<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="content_wraps">
		<div style="text-align: left">
		<h1>總共${fn:length(fileInfoList)}個檔案()</h1>
	</div>

    <table class="data_table">
      <thead>
        <tr>
          <th>檔案</th>
          <th>檔案大小</th>
          <th>更新時間</th>
		  <th>檔案下載</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="fileInfoList" status="status">
		  <s:if test="#status.even"><tr class="even_row"></s:if>
		  <s:else><tr class=""></s:else>
			
		  <td><s:property value="fileName" /></td>
		  <td><s:property value="fileSize" /></td>
		  <td><s:date name="fileUpatetime" format="yyyy-MM-dd  HH:mm:ss " /></td>
		  <td>
		    <s:url var="downloadtar" action="downloadtar" escapeAmp="false">
		    <s:param name="filename"><s:property value="fileName" /></s:param>
			<s:param name="sessionIdSelect"><s:property value="sessionIdSelect" /></s:param>
		    </s:url>
		    <a href="<s:property value="#downloadtar" />" >下載</a>
		  </td>
		</s:iterator>       
      </tbody>
    </table>
	
	</div>