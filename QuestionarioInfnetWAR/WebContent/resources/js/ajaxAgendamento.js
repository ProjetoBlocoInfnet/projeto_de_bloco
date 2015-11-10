/*
 * Ajax para carregar os módulos
 * 
 */	
function getModulos(){	
	var idCurso = $('#curso').val();		
    $.ajax({
        url: "ControllerAgendamento?list=listarModulos",
        type: 'GET',
        dataType: 'json',
        data: {idCurso: idCurso},
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) { 
            var option = '<option value="">Selecione o Módulo</option>';
            $.each(data, function (index, modulo) { 
            	option += '<option value="'+modulo.idModulo+'">'+modulo.nomeModulo+'</option>'; 
            }); 
            $("#modulo").html(option).show();
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}

