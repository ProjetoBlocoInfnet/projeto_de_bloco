
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
	<a href="ControllerLogin"><button type="button" class="btn btn-default">Voltar</button></a>
	<br><br>
	<form action="ControllerAgendamento" method="get">
		<input type="hidden" name="action" value="telaCadastro">
		<input type="submit" class="btn btn-info" value="Cadastrar Agendamento">
	</form>
	<br>
	<form action="ControllerAgendamento" method="post">
		<input type="hidden" name="action" value="consultar">
		<div class="row">  
		  <div class="col-lg-6">
		    <div class="input-group">
		      <input type="text" name="nome" class="form-control" placeholder="Consultar por...">
		      <span class="input-group-btn">
		        <input type="submit" class="btn btn-default" type="button" value="Consultar">
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	</form>
	<hr>
	
	<c:choose>
		<c:when test="${result_ok != null}">
			<div class="alert alert-success" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<strong>${result_ok}</strong>
			</div>
		</c:when>
		<c:when test="${result_error != null}">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<strong>${result_error}</strong>
			</div>
		</c:when>		
	</c:choose>
	
	<div >
	<table class="table table-hover">
  		<thead>
  		<th>ID Agendamento</th>
  		<th>ID Avalia��o</th>
  		<th>Status</th>
  		<th>Data Inicio</th>
  		<th>Data Fim</th>
  		<th>ID Turma</th>
  		<th>Curso</th>
  		<th>M�dulo</th>
  		<th>Professor</th>
  		</thead>
  		<tbody>
  		<c:if test="${requestScope.agendamentos != null && requestScope.agendamentos.size() > 0 }">
  		<!-- inicio do loop -->
  			<c:forEach items="${requestScope.agendamentos}" var="agendamento">
	  		<tr>
	  			
	  			<td>${agendamento.idAgendamento}</td>
	  			<td>${agendamento.avaliacao.idAvaliacao}</td>
	  			<td>${agendamento.status}</td>
	  			<td>${agendamento.dataInicio}</td>
	  			<td>${agendamento.dataFim}</td>
	  			<td>${agendamento.turma.idTurma}</td>
	  			<td>${agendamento.curso.nome}</td>
	  			<td>${agendamento.modulo.nomeModulo}</td>
	  			<td>${agendamento.professor.nome}</td>

	  			<td>
	  				<a href="ControllerAgendamento?action=editar&id=${avaliacao.idAgendamento}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> | 
	  				<a href="ControllerAgendamento?action=excluir&id=${avaliacao.idAgendamento}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> 	  				
	  			</td>
	  		</tr>
	  		</c:forEach>
	  	<!-- fim do loop -->
	  	</c:if>
  		</tbody>
	</table>
	</div>
	
	</div>

	
</div>

<jsp:include page="../footer.jsp" />