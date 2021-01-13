<%@page pageEncoding="UTF-8"%>

	<div id="content_wraps">
	<div id="loading_bar" style="margin: 1em auto;text-align: center;"><img alt="Loading_bar" src="/nova/images/loading_bar.gif"></div>
	<div id="select_div">
	
	<form action="/nova/batchexec/filemgmt/tarlist.action" method="post" target="_blank">
		<h2>批次執行結果檔案下載</h2>
			年份：
			<select id="yyyySelect1" name="yyyySelect" onchange="refreshMm(1)"></select>
			月份：
			<select id="mmSelect1" name="mmSelect" onchange="refreshSessionId(1)"></select>
			版本：
			<select id="sessionIdSelect1" name="sessionIdSelect"></select>
		<input name="commit" type="submit" value="送出">
		<div id="loading_gif2" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
	</form>
  </div>
	</div>