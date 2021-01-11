<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
	
	<div id="ses_content_wraps">
	<div id="select_div">
		<s:set name="actionURL" value="'/batchexec/batchmgmt/sessionall.action'"/>
		<s:form action="%{#actionURL}" onsubmit="return true" theme="simple">
		 <h3>風險管理系統批次作業申請單
			(報表基準月年份：
			<select id="yyyySelect1" name="yyyySelect1" onchange=""></select>
			月份：
			<select id="mmSelect1" name="mmSelect1" onchange=""></select>
		</h3>
		</s:form>
	</div>

	<style>
		.oldses_table {width: 95%; font-size: 13px; margin: 0 auto 1em;text-align:center; border:1px solid black; border-collapse:collapse}
		.oldses_table th { padding: 6px; border:1px solid black; background-color: #CDCDB4; border-collapse:collapse}
		.oldses_table td {padding: 6px; border:1px solid black;border-collapse:collapse}
		.oldses_table .even_row
		.oldses_table tbody tr:hover
		.oldses_table tfoot {border:1px solid black; border-collapse:collapse}
		.oldses_table input {
			border-top-width: 0px;
			border-right-width: 0px;
			border-bottom-width: 0px;
			border-left-width: 0px;
			border-top-style: dashed;
			border-right-style: dashed;
			border-bottom-style: dashed;
			border-left-style: dashed;
			border-top-color: #000000;
			border-right-color: #000000;
			border-bottom-color: #000000;
			border-left-color: #000000;
		}
		.oldses_table textarea {
			border-top-width: 0px;
			border-right-width: 0px;
			border-bottom-width: 0px;
			border-left-width: 0px;
			border-top-style: dashed;
			border-right-style: dashed;
			border-bottom-style: dashed;
			border-left-style: dashed;
			border-top-color: #000000;
			border-right-color: #000000;
			border-bottom-color: #000000;
			border-left-color: #000000;
			resize:none;
			overflow:hidden;
		}
	</style>
	
	<div id="loading_bar" style="margin: 1em auto;"><img alt="Loading_bar" src="/nova/images/loading_bar.gif"></div>
	<div id="sessions_div" style="margin: 1em 0px;">
	
	<s:set name="actionURL" value="'/batchexec/batchmgmt/updateremark.action'"/>
	<s:form action="%{#actionURL}" onsubmit="return remark_submit()">
	
	<table class="oldses_table">
      <thead>
        <tr>
          <th>版本編號</th>
		  <th>經辦</th>
		  <th>覆核者</th>
          <th>開始時間</th>
          <th>結束時間</th>
          <th>定版</th>
          <th>刪除</th>
          <th>備註</th>
        </tr>
      </thead>
      <tbody id="resultDiv">
		
      </tbody>
    </table>
	
	
	<pre>   經辦:                             覆核:                        資訊負責人:
	
	
	</pre>
	
	<div align="center" >
		<input type="submit" value="儲存">
	</div>
	
	</s:form>
</div>
  
  
  </div>