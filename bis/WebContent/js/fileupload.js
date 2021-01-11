function dep_select(obj) {
  var options = $('#file_code').prop('options');
  $('#file_code option').remove();
  $.each(dep_files[$(obj).val()], function(idx, file){
    options[options.length] = new Option(file[0], file[1]);
  });
  dl_temp($("#file_link"));
}

function dl_temp(link) {
  var params = {
    format : 'xls',
    file_code : $('#file_code').val()
  };
  alert('param : ' + $.param(params))
  $(link).attr('href', $(link).attr('href').split('?')[0] + '?' + $.param(params));
}

function do_submit() {
  //var file_in = $.trim($('#uploadfile_upload').val().split('.')[0].toUpperCase());
  var file_in = $.trim($('#uploadfile_upload').val().toUpperCase().replace('.CSV',''));
  var file_out = $.trim($('#uploadfile_uploadFilesId').find(':selected').text().split(' ')[0]);
  
  file_in = file_in.substring(file_in.indexOf('RISK',0),file_in.length);
  
  //alert('file_in: ' + file_in);
  //alert('file_out: ' + file_out);
  //alert('file_in.indexOf(file_out,0): ' + file_in.indexOf(file_out,0));
  
  if (file_in.indexOf(file_out,0) >= 0) {
    return true
  } else {
    alert('檔案名稱有誤，請檢查');
    return false;
  }
}




function select_all(formName, elementName, selectAllName) {
	if(document.forms[formName].elements[selectAllName].checked)
	for(var i = 0; i < document.forms[formName].elements[elementName].length; i++)
	document.forms[formName].elements[elementName][i].checked = true;
	else
	for(var i = 0; i < document.forms[formName].elements[elementName].length; i++)
	document.forms[formName].elements[elementName][i].checked = false;
	}

  // function checkFile() {
	     // var val=$('#filename').val();
	     // var re = /\.(CSV|csv)$/i;  //允許檔案的副檔名
		 // for(var i = 0; i < val.length; i++) {
	    // if(val.charCodeAt(i) < 0x4E00 || val.charCodeAt(i) > 0x9FA5){
		// alert('#filename');
   // alert('不可上傳中文檔名');
    // setTimeout(function(){ $('#filename').focus(); }, 1);
    // return false;
       // break;

      // }
  
	     // }
		  // return true
	 // } 

// function checkFile() {
 // var val=$('#filename').val();
// var re = /^[u4E00-u9FA5]+$/;
// if(!re.test(val)){
// alert('不可上傳中文檔名'); 
// alert(val);
// return false;
// }
// return true;
// } 

$(document).ready(function(){
	changeLink2();
	//$("#FileUpload_departments").attr("onchange","changeLink1(this.selectedIndex)");
	//$("#FileUpload_uploadFiles").attr("onchange","changeLink2()");
	$("#uploadfile_departmentsCode").attr("onchange","changeLink1(this.selectedIndex)");
	$("#uploadfile_uploadFilesId").attr("onchange","changeLink2()");
});


function changeLink1(selectedIndex){
	//FileUpload_departmentsRedirect(selectedIndex);
	uploadfile_departmentsCodeRedirect(selectedIndex);
	changeLink2();
}

function changeLink2() {
	var checkMethod_upload = "/fileupload/filemgmt/upload.action";
	//var methodInvoked=$('#methodInvoked').text().trim();
	var methodInvoked=$('#methodInvoked').text();
	
	//alert(methodInvoked);
	
	
	if(checkMethod_upload == methodInvoked)
	{
		var selectText=$("#uploadfile_uploadFilesId").find("option:selected").text();
		var fileCode = selectText.split(" ")[0];
		$("#file_link_1").attr("href","/nova/fileupload/filemgmt/exampledownload?filename="+fileCode+".xls");
        $("#file_link").attr("href","/nova/fileupload/filemgmt/exampledownload?filename="+fileCode+".ods");
		
		//var hrefa = $("#file_link").attr("href");
	
		//alert(selectText);
		//alert(fileCode);
		//alert(hrefa);
	}
}


