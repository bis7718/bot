$(function () {
	$('#date1').datepicker($.datepicker.regional['zh-TW']);
	$('#date2').datepicker($.datepicker.regional['zh-TW']);
	$('#date3').datepicker($.datepicker.regional['zh-TW']);
	$('#date4').datepicker($.datepicker.regional['zh-TW']);
});

function Check_query_date(type) {
		var query_startDate = document.getElementById("query_startDate").value;
		var query_endDate = document.getElementById("query_endDate").value;
		var download_startDate = document.getElementById("download_startDate").value;
		var download_endDate = document.getElementById("download_endDate").value;
		var answer = false;
		if (answer == false) {
			if (type == "1") {
				if (query_startDate == "" || query_endDate == "") {
					alert("開始時間和結束時間請勿空白");
					answer = false;
				} else if (query_endDate < query_startDate) {
					alert("結束時間請勿早於開始時間");
					answer = false;
				} else {
					answer = confirm('確定執行動作嗎?');
				}
			} else if (type == "2") {
				if (download_startDate == "" || download_endDate == "") {
					alert("開始時間和結束時間請勿空白");
					answer = false;
				} else if (download_endDate < download_startDate) {
					alert("結束時間請勿早於開始時間");
					answer = false;
				} else {
					answer = confirm('確定執行動作嗎?');
				}
			} else if (type == "3") {
				if (batch_query_startDate == "" || batch_query_endDate == "") {
					alert("開始時間和結束時間請勿空白");
					answer = false;
				} else if (batch_query_endDate < batch_query_startDate) {
					alert("結束時間請勿早於開始時間");
					answer = false;
				} else {
					answer = confirm('確定執行動作嗎?');
				}
			} else if (type == "4") {
				if (batch_download_startDate == "" || batch_download_endDate == "") {
					alert("開始時間和結束時間請勿空白");
					answer = false;
				} else if (batch_download_endDate < batch_download_startDate) {
					alert("結束時間請勿早於開始時間");
					answer = false;
				} else {
					answer = confirm('確定執行動作嗎?');
				}
			} 
		}
		return (answer)
	}