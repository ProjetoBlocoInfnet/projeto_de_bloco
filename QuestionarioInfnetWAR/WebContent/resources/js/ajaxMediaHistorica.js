$(document).ready(function(){	
	
	//$("#valor").attr('disabled','disabled'); 
	$("#valor").hide();
	
	$(this).on("change","#formConsulta .form-group #tipoConsulta",function(){
	
		var retorno = $(this).val();
	
		if( retorno == "total")
		{
			//$('#valor').attr('disabled','disabled'); 
			$("#valor").fadeOut();
		}
		else
		if( retorno == "curso")
		{
			//$('#valor').removeAttr('disabled');
			$("#valor").fadeIn();
		}
		else
		if( retorno == "infra")
		{
			$('#valor').attr('disabled','disabled'); 
			$("#valor").fadeOut();
		}
		else
		if( retorno == "professor")
		{
			$('#valor').removeAttr('disabled');
			$("#valor").fadeIn();
		}
	});
});