/**
 * 
 */
function getModulos()
{
	var idCurso = $('#curso').val();
	alert(idCurso)
    $.ajax({
        url: "ControllerAgendamento?list=listarModulos",
        type: 'GET',
        dataType: 'json',
        data: {idCurso: idCurso},// assim que se passa 
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) {
            $("#modulo:has(option)").remove();
            $("#modulo").append("<option value=\"\">Selecionar</option>");
 
            $.each(data, function (index, modulo) {
 
                $("#modulo").append($("'<option value='"+modulo.idModulo+"'>"+modulo.nomeModulo+"</option>"));
 
            }); 
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}