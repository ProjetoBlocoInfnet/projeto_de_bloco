/*
 * Ajax para carregar os módulos
 * 
 */	
function getModulosTurmas(){	
	var idCurso = $('#curso').val();		
    $.ajax({
        url: "ControllerAgendamento?list=listarModulos",
        type: 'GET',
        dataType: 'json',
        data: {idCurso: idCurso},
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) { 
            var option = '<option value="">Selecionar</option>';
            $.each(data, function (index, modulo) { 
            	option += '<option value="'+modulo.idModulo+'">'+modulo.nomeModulo+'</option>'; 
            }); 
            $("#modulo").html(option).show();
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
    
    $.ajax({
		url: "ControllerAgendamento?list=listarTurmas",
		type: 'GET',
		dataType: 'json',
		data: {idCurso: idCurso},
		contentType: 'application/json',
		mimeType: 'application/json',
		
		success: function (data) { 
		    var option = '<option value="">Selecionar</option>';
		    var optionProfessor = '<option value="">Selecione um modulo antes</option>';
		    $.each(data, function (index, turma) { 
		    	option += '<option value="'+turma.idTurma+'">'+turma.nomeTurma+'</option>'; 
		    }); 
		    $("#turma").html(option).show();
		    $("#professor").html(optionProfessor).show();
		},
		error:function(data,status,er) {
		    alert("error: "+data+" status: "+status+" er:"+er);
		}
	});
}

function getProfessores(){	
	var idModulo = $('#modulo').val();		
    $.ajax({
        url: "ControllerAgendamento?list=listarProfessores",
        type: 'GET',
        dataType: 'json',
        data: {idModulo: idModulo},
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) { 
            var option = '<option value="">Selecionar</option>';
            $.each(data, function (index, professor) { 
            	option += '<option value="'+professor.matricula+'">'+professor.nome+'</option>'; 
            }); 
            $("#professor").html(option).show();
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}


/*
function getTurmas(){	
	var idCurso = $('#curso').val();		
    $.ajax({
		url: "ControllerAgendamento?list=listarTurmas",
		type: 'GET',
		dataType: 'json',
		data: {idCurso: idCurso},
		contentType: 'application/json',
		mimeType: 'application/json',
		
		success: function (data) { 
		    var option = '<option value="">Selecionar</option>';
		    $.each(data, function (index, turma) { 
		    	option += '<option value="'+turma.idTurma+'">'+turma.nomeTurma+'</option>'; 
		    }); 
		    $("#turma").html(option).show();
		},
		error:function(data,status,er) {
		    alert("error: "+data+" status: "+status+" er:"+er);
		}
	});
}*/