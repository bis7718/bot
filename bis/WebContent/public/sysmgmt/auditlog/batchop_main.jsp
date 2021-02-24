<%@page pageEncoding="UTF-8"%>

<div align="left">
	<form action="batchop_query" method="post" target="_blank">
		<h2>線上查詢:</h2>
		開始時間:<input type="date" name="batch_query_startDate" id="batch_query_startDate">
		結束時間:<input type="date" name="batch_query_endDate" id="batch_query_endDate">
		<input type="submit" value="送出" onclick="return(Check_query_date(3))">
	</form> <br>
	
	<form action="batchop_download" method="post" target="_blank">
		<h2>匯出EXCEL:</h2>
		開始時間:<input type="date" name="batch_download_startDate" id="batch_download_startDate">
		結束時間:<input type="date" name="batch_download_endDate" id="batch_download_endDate">
		<input type="submit" value="送出" onclick="return(Check_query_date(4))">
	</form>
</div>