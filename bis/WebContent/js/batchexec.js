// batch option

function run_submit() {
  var val = $('#dataDate').val();
  
  if (val && val.match(/\d{8}/)) {
	$('#loading_gif').show();
    BatchManagementAction.batchrun(val, populateMsg); 
  } else {
	alert('資料日期有誤，請檢查');
  }
}

function populateMsg(msg){
	alert(msg);
	$('#loading_gif').hide();
	$('#loading_gif1').hide();
	$('#loading_gif2').hide();
	$('#loading_gif3').hide();
	$('#loading_gif4').hide();
}

function BatchCriterion1() {
    var yyyy, mm, id, input, ftp, fix;
}

BatchCriterion1.prototype.setValues = function (yyyy, mm, id, input, ftp, fix) {
    this.yyyy = yyyy;
    this.mm = mm;
	this.id = id;
	
	this.input = input;
    this.ftp = ftp;
	this.fix = fix;
}

function rerun_submit() {
	var yyyy = $('#yyyySelect1').val();
	var mm = $('#mmSelect1').val();
	var id = $('#sessionIdSelect1').val();

	var input = $('#session_input').prop("checked")?'1':'0';
	var ftp = $('#session_ftp').prop("checked")?'1':'0';
	var fix = $('#session_fix').prop("checked")?'1':'0';
	
	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm, id, input, ftp, fix);
	$('#loading_gif1').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.batchrerun(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);
	//alert('yyyy/mm/dd input, ftp, fix: ' + yyyy + ',' + mm + ',' + dd + ',' + input + ',' + ftp + ',' + fix);
	$('#loading_gif1').hide();
}

function csv_submit() {
	var yyyy = $('#yyyySelect2').val();
	var mm = $('#mmSelect2').val();
	var id = $('#sessionIdSelect2').val();

	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm, id);
	$('#loading_gif2').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.createcsv(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);
	
	$('#loading_gif2').hide();
  
}

function fixver_submit() {
	var yyyy = $('#yyyySelect3').val();
	var mm = $('#mmSelect3').val();
	var id = $('#sessionIdSelect3').val();

	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm, id);
	$('#loading_gif3').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.fixversion(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);

	$('#loading_gif3').hide();
}

function deleteold_submit() {
	var yyyy = $('#yyyySelect4').val();
	var mm = $('#mmSelect4').val();
	var id = $('#sessionIdSelect4').val();
	
	var input = $('#del_src_ver').prop("checked")?'1':'0'; //2014.7.10 同時刪除來源檔與版本資訊

	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm, id, input);
	$('#loading_gif4').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.deleteversion(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);

	$('#loading_gif4').hide();
}

function deleteold13M_submit() {
	var yyyy = $('#yyyySelect5').val();
	var mm = $('#mmSelect5').val();

	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm);
	$('#loading_gif5').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.delete13M(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);

	$('#loading_gif5').hide();
}

function encrypt_submit() {
	var yyyy = $('#yyyySelect6').val();
	var mm = $('#mmSelect6').val();
	var id = $('#sessionIdSelect6').val();
	
	var input = $('#regen_random').prop("checked")?'1':'0';

	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm, id, input);
	$('#loading_gif6').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.encrypt(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);

	$('#loading_gif6').hide();
}

function transfer_submit() {
	var yyyy = $('#yyyySelect7').val();
	var mm = $('#mmSelect7').val();
	var id = $('#sessionIdSelect7').val();

	var ct = new BatchCriterion1();
 
	ct.setValues(yyyy, mm, id);
	$('#loading_gif7').show();
	
	dwr.engine.setAsync(false);//DWREngine.setAsync(false);
	BatchManagementAction.transfer(ct, populateMsg);
	dwr.engine.setAsync(true);//DWREngine.setAsync(true);

	$('#loading_gif7').hide();
}

// job list
function update_job_submit(){
  if (valid_job_params()) {
    return true;
  } else {
    return false;
  }
}
function valid_job_params(){
  if (!$('#job_name').val()){
    alert('顯示名稱不可空白!!!');
    setTimeout(function(){ $('#job_name').focus(); }, 1);
    return false;
  }
  if (!$('#job_action').val()){
    alert('動作不可為空白!!!');
    setTimeout(function(){ $('#job_action').focus(); }, 1);
    return false;
  }
  return true
}

function new_job_submit(){
 if (nvalid_job_params()) {
    return true;
  } else {
    return false;
  }
}

function nvalid_job_params(){
  var val=$('#jobs_id').val();
  if (!$('#jobs_id').val()){
    alert('id不可為空白!!!');
    setTimeout(function(){ $('#jobs_id').focus(); }, 1);
    return false;
  }
  if(!val.match(/^[0-9]*$/)){
    alert('請填入數字!!!');
    setTimeout(function(){ $('#jobs_id').focus(); }, 1);
    return false;
  
  }
  if(val.length>3){
    alert('請填入3碼數字!!!');
    setTimeout(function(){ $('#jobs_id').focus(); }, 1);
    return false;
  
  }
  
  if (!$('#jobs_name').val()){
    alert('顯示名稱不可空白!!!');
    setTimeout(function(){ $('#jobs_name').focus(); }, 1);
    return false;
  }
  
  return true
}

var yyyySelectStr="yyyySelect";
var mmSelectStr="mmSelect";
var sessionIdSelectStr="sessionIdSelect";
var idx;

$(document).ready(function(){
//window.onload=function() {
    var checkMethod_op = "/batchexec/batchmgmt/op.action";
	var checkMethod_sessionlist = "/batchexec/batchmgmt/sessionlist.action";
	var checkMethod_sessionall = "/batchexec/batchmgmt/sessionall.action";
	var checkMethod_result = "/batchexec/filemgmt/result.action";
	var checkMethod_archive = "/fileupload/filequery/archive.action";
	var checkMethod_rptview = "/rptview/list.action";
	
	//var methodInvoked=$('#methodInvoked').text().trim();
	var methodInvoked=$('#methodInvoked').text();
	//alert(methodInvoked);
	if(checkMethod_op == methodInvoked)
	{
		$('#select_div').hide();
		$('#loading_bar').show();
		dwr.engine.setAsync(false);//DWREngine.setAsync(false);

		initYyyyMm('X');

		for (i=1; i<=7; i=i+1)
		{
			//alert("ready_i: " + i);
			idx=i;
			//alert("ready_idx: " + idx);
	
			BatchManagementAction.getYyyyList(populateYyyy); 
		}
		
		$('#select_div').show();
		$('#loading_bar').hide();
		dwr.engine.setAsync(true);//DWREngine.setAsync(true);
		
		$('#sessionIdSelect7 option').each(function(i, item) {
			//alert($(item).val());
			//將來源檔案搬至UAT環境: 去除 id >= 10000 的選項
			if(parseInt($(item).val()) >= 10000)
				$(item).remove();  
		});
	}
	
	if(checkMethod_result == methodInvoked ||
		checkMethod_archive == methodInvoked ||
		checkMethod_rptview == methodInvoked)
	{
		$('#select_div').hide();
		$('#loading_bar').show();
		dwr.engine.setAsync(false);//DWREngine.setAsync(false);

		initYyyyMm('X');
		
		idx=1;
		BatchManagementAction.getYyyyList(populateYyyy); 
		
		$('#select_div').show();
		$('#loading_bar').hide();
		dwr.engine.setAsync(true);//DWREngine.setAsync(true);
	}
	
	if(checkMethod_sessionlist == methodInvoked)
	{
		$('#sessions_div').hide();
		$('#loading_bar').show();
		
		dwr.engine.setAsync(false);//DWREngine.setAsync(false);
		init('X','N');
		idx=1;
		BatchManagementAction.getYyyyList(populateYyyy); 
		
		listSession();
		
		$('#sessions_div').show();
		$('#loading_bar').hide();
		dwr.engine.setAsync(true);//DWREngine.setAsync(true);
		
		var yyyyQuery = document.getElementById("yyyySelect1");
		var mmQuery = document.getElementById("mmSelect1");
	
		yyyyQuery.onchange = function () {
			dwr.engine.setAsync(false);//DWREngine.setAsync(false);
			refreshMm(1);
			listSession();
			dwr.engine.setAsync(true);//DWREngine.setAsync(true);
		}
	
		mmQuery.onchange = function () {
			listSession();
		}
		
		
	}
	
	if(checkMethod_sessionall == methodInvoked)
	{
		$('#sessions_div').hide();
		$('#loading_bar').show();
		
		dwr.engine.setAsync(false);//DWREngine.setAsync(false);
		init('','Y');
		idx=1;
		BatchManagementAction.getYyyyList(populateYyyy); 

		listAllSession();
		$('#sessions_div').show();
		$('#loading_bar').hide();
		dwr.engine.setAsync(true);//DWREngine.setAsync(true);
		
		var yyyyQuery = document.getElementById("yyyySelect1");
		var mmQuery = document.getElementById("mmSelect1");
	
		yyyyQuery.onchange = function () {
			dwr.engine.setAsync(false);//DWREngine.setAsync(false);
			refreshMm(1);
			listAllSession();
			dwr.engine.setAsync(true);//DWREngine.setAsync(true);
		}
	
		mmQuery.onchange = function () {
			listAllSession();
		}
		
		
	}
	
//};	
});

function init(setDisabled, setIsNoMap) {
	function BatchCriterion() {
        var disabled;
		var isNoMap;
    }
	
	BatchCriterion.prototype.setValues = function (disabled, isNoMap) {
        this.disabled = disabled;
		this.isNoMap = isNoMap;
    }
	
	var ct = new BatchCriterion();
	ct.setValues(setDisabled, setIsNoMap);

    BatchManagementAction.init(ct);
}

function initYyyyMm(setDisabled) {
	function BatchCriterion() {
        var disabled;
    }
	
	BatchCriterion.prototype.setValues = function (disabled) {
        this.disabled = disabled;
    }
	
	var ct = new BatchCriterion();
	ct.setValues(setDisabled);

    BatchManagementAction.initYyyyMm(ct);
}

function listSession() {
	function BatchCriterion() {
        var yyyy, mm, isNoMap;
    }
	
	BatchCriterion.prototype.setValues = function (yyyy, mm, isNoMap) {
        this.yyyy = yyyy;
        this.mm = mm;
		this.isNoMap = isNoMap;
    }
	
	var ct = new BatchCriterion();
 
        //設定使用者輸入的值
        //dwr.util是DWR提供的javascript工具
        //alert(dwr.util.getValue("yyyySelect1"));
		//alert(dwr.util.getValue("mmSelect1"));
		ct.setValues(dwr.util.getValue("yyyySelect1"),
                     dwr.util.getValue("mmSelect1"),
					 "N");
					 
		//送出篩選條件
        //直接呼叫後端BatchManagementAction class的method
        //第一個參數是使用者輸入的條件
        //第二個參數是callback要執行的程式碼
        BatchManagementAction.getSessionList(ct, function (data) {

            //var resultDiv = document.getElementById("resultDiv");
            var nInnerHTML = '';

            //先清空原有的查詢結果
			//2014.4.3 IE8 問題
			//IE8無法在ready中使用innerHTML
            //resultDiv.innerHTML = nInnerHTML;
			$("#resultDiv").html(nInnerHTML);
			
            //把回傳的List解開
			//id由大到小排序
            for (var i = 0;i < data.length;i++) {
                //alert(data[i]);
				var totalCount = parseInt(data[i]['successJobCount']) + parseInt(data[i]['failJobCount']);
				var fix_ver_cht = '';

				if(data[i]['fix_ver'] == 'Y')
					fix_ver_cht = '是';
				
				nInnerHTML += '<tr class="">' +
					'<td>' + data[i]['users'] + '</td>' +
					'<td><a href="/nova/batchexec/batchmgmt/sessionjoblist.action?sessionId='+data[i]['id']+'" target="_blank">' + data[i]['id'] + '</a></td>' +
					'<td>' + data[i]['datadate_s'] + '</td>' +
					
					'<td>' + totalCount + '</td>' +
					'<td>' + data[i]['successJobCount'] + '</td>' +
					'<td>' + data[i]['failJobCount'] + '</td>' +
					
					'<td>' + data[i]['start_on_s'] + '</td>' +
					'<td>' + data[i]['stop_at_s'] + '</td>' +
					'<td>' + data[i]['status'] + '</td>' +
					'<td>' + fix_ver_cht + '</td>' +
					'<td><a href="/nova/batchexec/batchmgmt/sessionloglist.action?sessionId='+data[i]['id']+'" target="_blank">查詢</a></td>' +
					'</tr>';
            }

            //resultDiv.innerHTML = nInnerHTML;
			$("#resultDiv").html(nInnerHTML);
        });
	
}

function listAllSession() {
	function BatchCriterion() {
        var yyyy, mm, isNoMap;
    }
	
	BatchCriterion.prototype.setValues = function (yyyy, mm, isNoMap) {
        this.yyyy = yyyy;
        this.mm = mm;
		this.isNoMap = isNoMap;
    }
	
	var ct = new BatchCriterion();
 
        //設定使用者輸入的值
        //dwr.util是DWR提供的javascript工具
        //alert(dwr.util.getValue("yyyySelect1"));
		//alert(dwr.util.getValue("mmSelect1"));
		ct.setValues(dwr.util.getValue("yyyySelect1"),
                     dwr.util.getValue("mmSelect1"),
					 "Y");
					 
		//送出篩選條件
        //直接呼叫後端BatchManagementAction class的method
        //第一個參數是使用者輸入的條件
        //第二個參數是callback要執行的程式碼
        BatchManagementAction.getSessionList(ct, function (data) {
            //var resultDiv = document.getElementById("resultDiv");
            var nInnerHTML = '';
 
            //先清空原有的查詢結果
			//2014.4.3 IE8 問題
			//IE8無法在ready中使用innerHTML
            //resultDiv.innerHTML = nInnerHTML;
			$("#resultDiv").html(nInnerHTML);
 
			//var k = eval(data.length-1);

            //把回傳的List解開
            //for (var i = 0;i < data.length;i++) {
			//id由小到大排序
			for (var i = eval(data.length); i-- ;) {
				//alert(data[i]);
				//var totalCount = parseInt(data[i]['successJobCount']) + parseInt(data[i]['failJobCount']);
				var fix_ver_cht = '';
				var disabled_cht = '';
				var users_str = '';
				var approve_user_str = '';
				var remark_str = '';
				
				if(data[i]['fix_ver'] == 'Y')
					fix_ver_cht = '是';
					
				if(data[i]['disabled'] == 'V')
					disabled_cht = '已刪除';
				
				if(data[i]['users'] != null)
					users_str = data[i]['users'];
				
				if(data[i]['approve_user'] != null)
					approve_user_str = data[i]['approve_user'];
				
				//remark_str = '<input name="remark_'+data[i]['id']+'" type="text" value="'+data[i]['remark']+'">';
				remark_str = '<textarea name="remark_'+data[i]['id']+'" rows="3" cols="20">'+data[i]['remark']+'</textarea>';
				
				nInnerHTML += '<tr class="">' +
					//'<td><a href="/nova/batchexec/batchmgmt/sessionjoblist.action?sessionId='+data[i]['id']+'" target="_blank">' + data[i]['id'] + '</a></td>' +
					'<td>' + data[i]['id'] + '</td>' +
					'<td>' + users_str + '</td>' +
					'<td>' + approve_user_str + '</td>' +
					
					'<td>' + data[i]['start_on_s'] + '</td>' +
					'<td>' + data[i]['stop_at_s'] + '</td>' +
					'<td>' + fix_ver_cht + '</td>' +
					'<td>' + disabled_cht + '</td>' +
					'<td>' + remark_str + '</td>' +
					'</tr>';
            }
 
            //resultDiv.innerHTML = nInnerHTML;
			$("#resultDiv").html(nInnerHTML);
        });
	
}
 
function populateYyyy(list){
	//alert("populateYyyy: " + idx);
	dwr.util.removeAllOptions(yyyySelectStr+idx);
	dwr.util.addOptions(yyyySelectStr+idx, list);
	refreshMm();
}

function refreshMm(idx_in) {
	if(idx_in != null)
		idx=idx_in;
	
	//alert("refreshMm: " + idx);
	var yyyy = $("#"+yyyySelectStr+idx).val();
	BatchManagementAction.getMmList(yyyy,populateMm); 	
}

function populateMm(list){
	//alert("populateMm: " + idx);
	dwr.util.removeAllOptions(mmSelectStr+idx);
    dwr.util.addOptions(mmSelectStr+idx, list);
	
	//alert($("#"+sessionIdSelectStr+idx).length);
	
	if($("#"+sessionIdSelectStr+idx).length)
		refreshSessionId(idx);
}

function refreshSessionId(idx_in) {
	if(idx_in != null)
		idx=idx_in;
	
	//alert("refreshSessionId: " + idx);
	var yyyy = $("#"+yyyySelectStr+idx).val();
	var mm = $("#"+mmSelectStr+idx).val();
	
	BatchManagementAction.getSessionIdList(yyyy,mm,populateSessionId); 	
}

function populateSessionId(list){
	//alert("populateSessionId: " + idx);
	dwr.util.removeAllOptions(sessionIdSelectStr+idx);
	dwr.util.addOptions(sessionIdSelectStr+idx, list, 'value', 'text');
}

function remark_submit() {
	debugger;
	var isConfirm = confirm('確認儲存？');
	if(isConfirm) {
		$('#sessions_div').hide();
		debugger;
		$('#loading_bar').show();
	}
		debugger;
	if(isConfirm) {
		alert('開始儲存...請稍候');
		var remarkArray = new Array();
		//alert("remark");
		$("textarea[name^=remark]").each(function() {
			//alert($(this).attr("name")+'_'+$(this).val());
			remarkArray.push($(this).attr("name")+'_'+$(this).val());
		});
	
		dwr.engine.setAsync(false);//DWREngine.setAsync(false);
		BatchManagementAction.updateremark(remarkArray, listAllSession);
	
		$('#sessions_div').show();
		$('#loading_bar').hide();
		dwr.engine.setAsync(true);//DWREngine.setAsync(true);
		alert('儲存完成');
	}
	return false;
}

function sessionrun_submit() {
	document.ses_f.submit();
	document.ses_f.ses_s.disabled=true;
}

function select_all(){
    var e = $("#chkAll")[0].checked;
    $("#tb1 input:checkbox").each(function(){               
        this.checked = e;
    });
}

function delete_file_submit(){
	   return true;
}