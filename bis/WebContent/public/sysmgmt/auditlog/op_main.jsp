<%@page pageEncoding="UTF-8"%>

<div align="left">
	<form action="op_query" method="post" target="_blank">
		<h2>線上查詢:</h2>
		開始時間:<input type="date" name="query_startDate" id="query_startDate">
		結束時間:<input type="date" name="query_endDate" id="query_endDate">
		<input type="submit" value="送出" onclick="return(Check_query_date(1))">
	</form>
	<br>

	<form action="op_download" method="post" target="_blank">
		<h2>匯出EXCEL:</h2>
		開始時間:<input type="date" name="download_startDate"
			id="download_startDate"> 結束時間:<input type="date"
			name="download_endDate" id="download_endDate"> <input
			type="submit" value="送出" onclick="return(Check_query_date(2))">
	</form>
</div>