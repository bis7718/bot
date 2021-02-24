<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="content_wraps">
	<div style="text-align: left">
		<h1>總共${fn:length(fileInfoList)}個檔案(${filePath})</h1>
	</div>
	<div style="text-align: center">
		<form action="delete" onsubmit="return delete_file_submit()">
			全選: <input type="checkbox" id="chkAll" onclick="select_all()">
			<input type="submit" value="刪除"
				onclick='return confirm("確定刪除多個檔案？");'>

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
					<c:forEach items="${fileInfoList}" var="fileInfo">
						<tr class="">
							<td><input id="${fileInfo.fileName}" type="checkbox" value="1"></td>
							<td><a href='delete?fileName=${fileInfo.fileName}' onclick="return confirm('確定刪除檔案${fileInfo.fileName}?');">刪除</a></td>
							<td><a href='download?fileName=${fileInfo.fileName}' target="_blank">${fileInfo.fileName}</a></td>
							<td>${fileInfo.fileSize}</td>
							<fmt:formatDate value="${fileInfo.fileUpatetime}" type="date" pattern="yyyy-MM-dd  HH:mm:ss " var="formattedDate"/>
							<td>${formattedDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</div>