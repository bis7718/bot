<%@page pageEncoding="UTF-8"%>

<div align="left">
	<form action="/nova/sysmgmt/auditlog/query.action" method="post" target="_blank">
		<h2>線上查詢:</h2>
		開始時間:<input type="text" name="startDate" id="date1">
		結束時間:<input type="text" name="endDate" id="date2">
		<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
	</form> <br>
	
	<form id="dep_f" method="post" action="/nova/sysmgmt/auditlog/download.action">
		<h2>匯出EXCEL:</h2>
		開始時間:<input type="text" name="startDate" id="date3">
		結束時間:<input type="text" name="endDate" id="date4">
		<input type="submit" value="送出" onclick="return(confirm('確認送出？'))">
	</form>
</div>