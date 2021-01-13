<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<div id="ses_content_wraps">
	<div id="select_div">
		<s:set name="actionURL" value="'/batchexec/batchmgmt/sessionlist.action'"/>
		<s:form action="%{#actionURL}" onsubmit="return true" theme="simple">
		年份：
		<select id="yyyySelect1" name="yyyySelect1" onchange=""></select>
		月份：
		<select id="mmSelect1" name="mmSelect1" onchange=""></select>
		</s:form>
	</div>
	<div id="loading_bar" style="margin: 1em auto;"><img alt="Loading_bar" src="/nova/images/loading_bar.gif"></div>
	<div id="sessions_div" style="margin: 1em 0px;">
  
	<p align="left">狀態:0(已經建立批次號碼尚未執行工作項目)<br>
    狀態:1(正在執行工作項目)<br>
    狀態:2(完成批次作業)<br>
    </p>
	
	<table class="data_table">
      <thead>
        <tr>
          <th>執行者</th>
          <th>版本編號</th>
          <th>日期</th>
          <th>工作總數</th>
          <th>完成工作</th>
          <th>失敗工作</th>
          <th>開始時間</th>
          <th>結束時間</th>
          <th>狀態</th>
          <th>定版</th>
          <th>查詢資料檢核的log</th>
        </tr>
      </thead>
      <tbody id="resultDiv">
		
      </tbody>
    </table>
</div>
  
  
  </div>