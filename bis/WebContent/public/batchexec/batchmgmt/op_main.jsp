<%@page pageEncoding="UTF-8"%>

	<div id="content_wraps">
	<div id="loading_bar" style="margin: 1em auto;text-align: center;"><img alt="Loading_bar" src="/nova/images/loading_bar.gif"></div>
	<div id="select_div">
	
	<form action="/batchexec/batchmgmt/batchrun.action" method="post" onsubmit="run_submit(); return false">
		<h2>一般批次</h2>
			資料日期 (YYYYMMDD)：
		<s:textfield id="dataDate" name="dataDate" theme="simple"/>
		<s:submit theme="simple" onclick="return confirm('確定申請一般批次')" value="送出" />
		<div id="loading_gif" style="display: none; text-align:left">
			<img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...
		</div>
	</form>
	
	<br>
	<form action="/batchexec/batchmgmt/batchrerun.action" method="post" onsubmit="rerun_submit(); return false">
		<h2>重跑批次</h2>
			年份：
			<select id="yyyySelect1" name="yyyySelect1" onchange="refreshMm(1)"></select>
			月份：
			<select id="mmSelect1" name="mmSelect1" onchange="refreshSessionId(1)"></select>
			版本：
			<select id="sessionIdSelect1" name="sessionIdSelect1"></select>
    <input name="commit" onclick="return confirm('確定申請重跑批次')" type="submit" value="送出">
	<p>請勾選要移動的資料夾:
		<input checked="checked" id="session_input" type="checkbox" value="1"> 人工檔案
		<input checked="checked" id="session_ftp" type="checkbox" value="1"> 系統檔案
		<input checked="checked" id="session_fix" type="checkbox" value="1"> Fix檔案
	</p>
    <div id="loading_gif1" style="display: none; text-align:left">
		<img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...
	</div>
  </form>
  <br>
  
  <form action="/batchexec/batchmgmt/createcsv.action" method="post" onsubmit="csv_submit(); return false">
		<h2>產生CSV檔案</h2>
			年份：
			<select id="yyyySelect2" name="yyyySelect2" onchange="refreshMm(2)"></select>
			月份：
			<select id="mmSelect2" name="mmSelect2" onchange="refreshSessionId(2)"></select>
			版本：
			<select id="sessionIdSelect2" name="sessionIdSelect2"></select>
    <input name="commit" onclick="return confirm('確定申請產生CSV')" type="submit" value="送出">
    <div id="loading_gif2" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
  </form>
  <br>
  <form action="/batchexec/batchmgmt/fixversion.action" method="post" onsubmit="fixver_submit(); return false">
		<h2>定版</h2>
			年份：
			<select id="yyyySelect3" name="yyyySelect3" onchange="refreshMm(3)"></select>
			月份：
			<select id="mmSelect3" name="mmSelect3" onchange="refreshSessionId(3)"></select>
			版本：
			<select id="sessionIdSelect3" name="sessionIdSelect3"></select>
    <input name="commit" onclick="return confirm('確定申請定版')" type="submit" value="送出">
    <div id="loading_gif3" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
  </form>
  <br>
  <form action="/batchexec/batchmgmt/deleteversion.action" method="post" onsubmit="deleteold_submit(); return false">
		<h2>刪除舊資料</h2>
			年份：
			<select id="yyyySelect4" name="yyyySelect4" onchange="refreshMm(4)"></select>
			月份：
			<select id="mmSelect4" name="mmSelect4" onchange="refreshSessionId(4)"></select>
			版本：
			<select id="sessionIdSelect4" name="sessionIdSelect4"></select>
  <input name="commit" onclick="return confirm('確定申請刪除')" type="submit" value="送出">
    <div id="loading_gif4" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
  </form>
  <p>
		<input checked="checked" id="del_src_ver" type="checkbox" value="1"> 同時刪除來源檔與版本資訊
  </p>
  <br>
  <form action="/batchexec/batchmgmt/delete13M.action" method="post" onsubmit="deleteold13M_submit(); return false">
		<h2>刪除13個月前舊資料</h2>
			年份：
			<select id="yyyySelect5" name="yyyySelect5" onchange="refreshMm(5)"></select>
			月份：
			<select id="mmSelect5" name="mmSelect5" onchange="refreshSessionId(5)"></select>
  <input name="commit" onclick="return confirm('確定申請刪除')" type="submit" value="送出">
    <div id="loading_gif5" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
  </form>
  <br>
  <form action="/batchexec/batchmgmt/encrypt.action" method="post" onsubmit="encrypt_submit(); return false">
		<h2>資料遮蔽</h2>
			年份：
			<select id="yyyySelect6" name="yyyySelect6" onchange="refreshMm(6)"></select>
			月份：
			<select id="mmSelect6" name="mmSelect6" onchange="refreshSessionId(6)"></select>
			版本：
			<select id="sessionIdSelect6" name="sessionIdSelect6"></select>
  <input name="commit" onclick="return confirm('確定申請遮蔽')" type="submit" value="送出">
    <div id="loading_gif6" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
  </form>
  <p>
		<input checked="checked" id="regen_random" type="checkbox" value="1"> 是否重新產生亂數值
  </p>
  <br>
  <form action="/batchexec/batchmgmt/transfer.action" method="post" onsubmit="transfer_submit(); return false">
		<h2>將來源檔案搬至UAT環境</h2>
			年份：
			<select id="yyyySelect7" name="yyyySelect7" onchange="refreshMm(7)"></select>
			月份：
			<select id="mmSelect7" name="mmSelect7" onchange="refreshSessionId(7)"></select>
			版本：
			<select id="sessionIdSelect7" name="sessionIdSelect7"></select>
  <input name="commit" onclick="return confirm('確定申請搬移')" type="submit" value="送出">
    <div id="loading_gif7" style="display: none; text-align:left"><img alt="Loading_s" src="/nova/images/loading_s.gif"> 處理中...</div>
  </form>
  </div>
	</div>