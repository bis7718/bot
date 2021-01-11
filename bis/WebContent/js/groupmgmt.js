function valid_group_params(){
  if (!$('#groups_sym').val()){
    alert('群組代碼不可空白!!!');
    setTimeout(function(){ $('#groups_sym').focus(); }, 1);
    return false;
  }
  if (!$('#groups_name').val()){
    alert('群組名稱不可空白!!!');
    setTimeout(function(){ $('#groups_name').focus(); }, 1);
    return false;
  }
  return true
}

function create_group_submit(f){
  if (valid_group_params()) {
    //$('#group_users option').attr('selected', true);
    //$('#group_functions option').attr('selected', true);
    //$('#group_reports option').attr('selected', true);
    //$('input').attr('readonly', true);
    //$('select').attr('readonly', true);
	 $('#group_functions option').prop('selected', true);
    return true;
  } else {
    return false;
  }
}

function update_group_submit(){
  return create_group_submit();
}

$(function(){
	//unselect_functions 選單, 點選大項時, 自動選擇細項
	$("#unselect_functions").click(function() {
		$("#unselect_functions").find(":selected").each(function() {
			var a = this.text + ">";

			$("#unselect_functions option").each(function() {
				if (this.text.indexOf(a) >= 0)
					this.selected = true;

			});
		});
	});
	
	//移到右邊
	$('#add').click(function() {
		//獲取選中的選項，刪除並追加給對方
		$('#unselect_functions option:selected').appendTo('#group_functions');
	});
	
	//移到左邊
	$('#remove').click(function() {
		$('#group_functions option:selected').appendTo('#unselect_functions');
	});
});