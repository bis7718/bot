
function valid_user_params(){
  if (!$('#users_code').val()){
    alert('員工編號不可空白!!!');
    setTimeout(function(){ $('#user_code').focus(); }, 1);
    return false;
  }
  if (!$('#users_name').val()){
    alert('顯示名稱不可空白!!!');
    setTimeout(function(){ $('#user_name').focus(); }, 1);
    return false;
  }
  if (!$('#user_departments').val()){
    alert('所屬部門不可空白!!!');
    setTimeout(function(){ $('#user_department').focus(); }, 1);
    return false;
  }
  if ($('#user_groups option').length == 0){
    alert('群組不可空白!!!');
    setTimeout(function(){ $('#group_names').focus(); }, 1);
    return false;
  }
  return true
}

function create_user_submit(){
  if (valid_user_params()) {
    $('#user_groups option').prop('selected', true);
    return true;
  } else {
    return false;
  }
}

function new_user_submit(){
	  if (valid_user_params()) {
	    return true;
	  } else {
	    return false;
	  }
	}

function update_user_submit(){
  return create_user_submit();
}

function delete_user_submit(){
	   return true;
}

function select_all(){
    var e = $("#chkAll")[0].checked;
    $("#tb1 input:checkbox").each(function(){               
        this.checked = e;
    });
}

$(function(){
	//移到右邊
	$('#add').click(function() {
		//獲取選中的選項，刪除並追加給對方
		$('#unselect_groups option:selected').appendTo('#user_groups');
	});
	
	//移到左邊
	$('#remove').click(function() {
		$('#user_groups option:selected').appendTo('#unselect_groups');
	});
});
