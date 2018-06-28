function closeDialog(dom){
	$(dom).hide();
}

$(function(){

	$('#start-time').datetimepicker({
		language:'zh', 
		format:'yyyy-mm-dd hh:ii',
		autoclose:'true',
		todayBtn:'true',
		todayHighlight:'true',
		showMeridian:'true',
		language:  'fr',
		minView:'day',
	});
	$('#end-time').datetimepicker({
		language:'zh', 
		format:'yyyy-mm-dd hh:ii',
		autoclose:'true',
		todayBtn:'true',
		todayHighlight:'true',
		showMeridian:'true',
		language:  'fr',
		minView:'day',
	});
})