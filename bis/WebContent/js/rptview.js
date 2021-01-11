function rpt_typ_select(obj) {
  var rpt_cat = [['全部', '']];
  if ($(obj).val() == 'ma_report') {
    $('.ma_report').fadeIn();
    $('.ca_report').fadeOut();

	$('#report_category_ca').hide();
	$('#report_category').hide();
	$('#report_category_ma').attr('style','visibility:visible');
	$('#report_category_ma').show();
  } else if ($(obj).val() == 'ca_report') {
    $('.ma_report').fadeOut();
    $('.ca_report').fadeIn();

	$('#report_category_ma').hide();
	$('#report_category').hide();
	$('#report_category_ca').attr('style','visibility:visible');
	$('#report_category_ca').show();
  } else {
    $('.ma_report').fadeIn();
    $('.ca_report').fadeIn();
	
	$('#report_category_ca').hide();
	$('#report_category_ma').hide();
	$('#report_category').attr('style','visibility:visible');
	$('#report_category').show();
  }
  var options = $('#report_category').prop('options');
}

function rpt_cat_select(obj) {

  //if ($('#report_type').val()) {
	//var rpt_typ = $('#report_type').val();
    //if ($(obj).val()) {
      //$('.' + rpt_typ).fadeOut(); 
      //$('.' + rpt_typ + '.cat_' + $(obj).val()).fadeIn();
    //} else {
      //$('.' + rpt_typ).fadeIn()
    //}
  if ($('#report_type').val() == 'ma_report') {
	  if ($(obj).val()) {
		  $('.ma_report').fadeOut();
		  var cate_id = report_num($(obj).val());
		  $('.ma_report.cat_'+ cate_id).fadeIn();
	  }else {
		  $('.ma_report').fadeIn();
	  }
  } else if ($('#report_type').val() == 'ca_report'){
	  
	  if ($(obj).val()) {
		  $('.ca_report').fadeOut();
		  var cate_id = report_num($(obj).val());
		  $('.ca_report.cat_'+ cate_id).fadeIn();		  
	  }else {
		  $('.ca_report').fadeIn();
	  }	  
  }
  else {
    if ($(obj).val()) {
      $('.ma_report').fadeOut();
      $('.ca_report').fadeOut();
      $('.rpt_type').fadeIn();
      //$('.cat_' + $(obj).val()).fadeIn();
      var cate_id = report_num($(obj).val());
      $('.cat_'+ cate_id).fadeIn();
    } else {
      $('.ma_report').fadeIn();
      $('.ca_report').fadeIn();
    }
  }
}

function report_num(categoryid){
	
	var cat_id = '';
	var lgth = categoryid.length;
	for (i = 0; i< lgth; i++){
		switch (categoryid.substr(i,1)) {
		case '0':
			cat_id = cat_id + '0'; break;
		case '1':
			cat_id = cat_id + '1'; break;
		case '2':
			cat_id = cat_id + '2'; break;
		case '3':
			cat_id = cat_id + '3'; break;
		case '4':
			cat_id = cat_id + '4'; break;
		case '5':
			cat_id = cat_id + '5'; break;
		case '6':
			cat_id = cat_id + '6'; break;
		case '7':
			cat_id = cat_id + '7'; break;
		case '8':
			cat_id = cat_id + '8'; break;
		case '9':
			cat_id = cat_id + '9'; break;		
		}		
	}
	return cat_id;
	
}

function yyyy_select(obj) {
  var options = $('#session_month').prop('options');
  $('#session_month option').remove();
  $.each(mm[$(obj).val()], function(idx, mon){
    options[options.length] = new Option(mon, mon);
  });
  mm_select($('#session_month'));
}

function mm_select(obj) {
  var options = $('#session_version').prop('options');
  $('#session_version option').remove();
  $.each(yyyymm[$('#session_year').val() + $(obj).val()], function(idx, sid){
    var text = $.inArray(sid, fix_vers) > -1 ? sid.toString() + ' 定版' : sid
    options[options.length] = new Option(text, sid);
  });
  // version_select($('#session_version'));
}
/* 
function version_select(obj) {
  if ($.inArray(parseInt($(obj).val()), fix_vers) > -1) {
    $('.fix_ver').show();
  } else {
    $('.fix_ver').hide();
  }
}
 */
function dl_report(name, mode, link) {
  var params = {
    datadate : $('#yyyySelect1').val() + $('#mmSelect1').val(),
    ssSeq : $('#sessionIdSelect1').val(),
    gmValue : ((mode == 'BRN' || mode == 'CCY') ? $('#' + name + '_' + mode).val() : '000'),
	rptId : name
  }
  
  //var idx=$(link).attr('href').indexOf("datadate");
  
  //alert(idx);
  //if(idx==-1)
  $(link).attr('href', $(link).attr('href').split('&')[0] + '&' + $.param(params));
}

