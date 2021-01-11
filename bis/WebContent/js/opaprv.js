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
  $(link).attr('href', $(link).attr('href').split('?')[0] + '?' + $.param(params));
}

function do_submit() {
  if ($('#attachment_file').val().toUpperCase().indexOf($('#file_code').val(), 0) > -1) {
    return true
  } else {
    alert('檔案名稱有誤，請檢查');
    return false;
  }
}

function approvechange_status(log_id, act_sym) {
  if(confirm('確定執行動作嗎?')){
    $('#act_' + log_id).hide();
    $('#act_' + log_id + '_loading').show();
    $.ajax({
      cache: false,
      url: "/approves/approvechange_status",
      data: { id: log_id, act: act_sym }
    }).done(function( msg ) {
      if (msg != 'OK') {
        // '執行失敗'
        alert( msg );
        return false;
      } else {
        // '執行成功'
        alert('執行成功');
        $('#act_' + log_id).text('執行成功');
        return true;
      }
    }).fail(function( jqXHR, exception ) {
      // '執行失敗'
      if (exception === 'abort') {
          alert( "執行已停止" ); 
      } else {
          alert( jqXHR.responseText );
      }
      return false;
    }).always(function() {
      $('#act_' + log_id).show();
      $('#act_' + log_id + '_loading').hide();
    });
  } else {
    return false
  }


}





function downfiledelete_status(log_id, act_sym) {
  if(confirm('確定執行動作嗎?')){
    $('#act_' + log_id).hide();
    $('#act_' + log_id + '_loading').show();
    $.ajax({
      cache: false,
      url: "/approves/downfiledelete_status",
      data: { id: log_id, act: act_sym }
    }).done(function( msg ) {
      if (msg != 'OK') {
        //'執行失敗'
        alert( msg );
        return false;
      } else {
        '執行成功'
        alert('執行成功');
        $('#act_' + log_id).text('執行成功');
        return true;
      }
    }).fail(function( jqXHR, exception ) {
      //'執行失敗'
      if (exception === 'abort') {
          alert( "執行已停止" ); 
      } else {
          alert( jqXHR.responseText );
      }
      return false;
    }).always(function() {
      $('#act_' + log_id).show();
      $('#act_' + log_id + '_loading').hide();
    });
  } else {
    return false
  }


}
function uploadchange_status(log_id, act_sym) {
  if(confirm('確定執行動作嗎?')){
    $('#act_' + log_id).hide();
    $('#act_' + log_id + '_loading').show();
    $.ajax({
      cache: false,
      url: "/approves/uploadchange_status",
      data: { id: log_id, act: act_sym }
    }).done(function( msg ) {
      if (msg != 'OK') {
        // '執行失敗'
        alert( msg );
        return false;
      } else {
        // '執行成功'
        alert('執行成功');
        $('#act_' + log_id).text('執行成功');
        return true;
      }
    }).fail(function( jqXHR, exception ) {
      // '執行失敗'
      if (exception === 'abort') {
          alert( "執行已停止" ); 
      } else {
          alert( jqXHR.responseText );
      }
      return false;
    }).always(function() {
      $('#act_' + log_id).show();
      $('#act_' + log_id + '_loading').hide();
    });
  } else {
    return false
  }


}

function sysuploadfilechange_status(log_id, act_sym) {
  if(confirm('確定執行動作嗎?')){
    $('#act_' + log_id).hide();
    $('#act_' + log_id + '_loading').show();
    $.ajax({
      cache: false,
      url: "/approves/sysuploadfilechange_status",
      data: { id: log_id, act: act_sym }
    }).done(function( msg ) {
      if (msg != 'OK') {
        // '執行失敗'
        alert( msg );
        return false;
      } else {
        // '執行成功'
        alert('執行成功');
        $('#act_' + log_id).text('執行成功');
        return true;
      }
    }).fail(function( jqXHR, exception ) {
      // '執行失敗'
      if (exception === 'abort') {
          alert( "執行已停止" ); 
      } else {
          alert( jqXHR.responseText );
      }
      return false;
    }).always(function() {
      $('#act_' + log_id).show();
      $('#act_' + log_id + '_loading').hide();
    });
  } else {
    return false
  }


}

function select_all(){
            var e = $("#chkAll")[0].checked;
            $("#tb1 input:checkbox").each(function(){               
                this.checked = e;
            });
        }