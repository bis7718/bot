function valid_dep_params(){
var val=$('#departments_code').val();
var flag=$('#departments_overseas_flag').val();
	if (!$('#departments_code')[0].value){
    alert('分行代碼不可空白!!!');
    setTimeout(function(){ $('#departments_code').focus(); }, 1);
    return false;
  }
   if(!val.match(/^[0-9]*$/)){
    alert('分行代碼請填入數字!!!');
    setTimeout(function(){ $('#departments_code').focus(); }, 1);
    return false;
  
  }
  if(val.length!=3){
    alert('分行代碼請填入3碼數字!!!');
    setTimeout(function(){ $('#departments_code').focus(); }, 1);
    return false;
}
  if (!$('#departments_name')[0].value){
    alert('分行名稱不可空白!!!');
    setTimeout(function(){ $('#departments_name').focus(); }, 1);
    return false;
  }
  if (!$('#departments_overseas_flag').val()){
    alert('是否為海外分行(Y/N)!!!');
    setTimeout(function(){ $('#departments_overseas_flag').focus(); }, 1);
    return false;
  }
 return true
}
function new_dep_submit(){
  if (valid_dep_params()) {
    return true;
  } else {
    return false;
  }
}
function update_dep_submit(){

return new_dep_submit();
}

function Check() {
		var dept_code = document.getElementById("departments_code").value;
		var dept_name = document.getElementById("departments_name").value;
		var regex = /^[0-9]*$/;
		if (dept_code.length == 0 || dept_name.length == 0) {
			alert('分行代碼和分行名稱不可空白!!!');
			return false;
		} else if (!regex.test(dept_code)) {
			alert('分行代碼請填入數字!!!');
			return false;
		} else if (dept_code.length != 3) {
			alert('分行代碼請填入3碼數字!!!');
			return false;
		}
		return true;
	}
