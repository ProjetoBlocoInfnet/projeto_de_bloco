<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../openDoc.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
	<a href="ControllerLogin"><button type="button" class="btn btn-default">Voltar</button></a>
	<br><br>
<!-- <form action="ControllerAgendamento" method="get">
		<input type="hidden" name="action" value="telaCadastro">
		<input type="submit" class="btn btn-info" value="Cadastrar Agendamento">
	</form> -->	
	<br>
	<form action="ControllerMediaHistorica" method="post" class="form-inline">
		<input type="hidden" name="action" value="consultar">		
		<div class="form-group">
		    <input type="text" name="valor" class="form-control" placeholder="Consultar por...">
				<select name="tipoConsulta" id="tipoConsulta" class="form-control">
					<option value="total">Média Total</option>
					<option value="curso">Curso</option>
					<option value="infra">Infra Estrutura</option>
					<option value="professor">Professor</option>
				</select>
			
		    	<input type="submit" class="btn btn-default" type="button" value="Consultar">
			
		</div>

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
  			<!-- Inicio montagem tipos de relatórios -->
	  		<c:choose>
		  		<c:when test="${requestScope.tipoRetorno == 'total' }">
		  		<!-- Montagem de tela Média geral -->
			  		<th>Avaliacao</th>
			  		<th>Data Inicio avaliação</th>
			  		<th>Data Fim avaliação</th>
			  		<th>Média Total</th>
			  		<th>Professor</th>
			  		</thead>
			  		<tbody>
			  		<c:if test="${requestScope.resultados != null && requestScope.resultados.size() > 0 }">
			  		<!-- inicio do loop -->
			  			<c:forEach items="${requestScope.resultados}" var="resultado">
				  		<tr>
				  			<td>${resultado.agendamentoAvaliacao.avaliacao.nome}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataInicio}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataFim}</td>
				  			<td>${resultado.media}</td>
				  			<td>${resultado.agendamentoAvaliacao.professor.nome}</td>
				  		</tr>
				  		</c:forEach>
				  	<!-- fim do loop -->
				  	</c:if>
				<!-- FIM - Montagem de tela Média geral -->
			  	</c:when>
		  		<c:when test="${requestScope.tipoRetorno == 'professor' }">
		  		<!-- Montagem de tela professor -->
			  		<th>Avaliacao</th>
			  		<th>Data Inicio avaliação</th>
			  		<th>Data Fim avaliação</th>
			  		<th>Média do Professor</th>
			  		<th>Professor</th>
			  		</thead>
			  		<tbody>
			  		<c:if test="${requestScope.resultados != null && requestScope.resultados.size() > 0 }">
			  		<!-- inicio do loop -->
			  			<c:forEach items="${requestScope.resultados}" var="resultado">
				  		<tr>
				  			<td>${resultado.agendamentoAvaliacao.avaliacao.nome}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataInicio}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataFim}</td>
				  			<td>${resultado.media}</td>
				  			<td>${resultado.agendamentoAvaliacao.professor.nome}</td>
				  		</tr>
				  		</c:forEach>
				  	<!-- fim do loop -->
				  	</c:if>
				<!-- FIM - Montagem de tela profesor -->
			  	</c:when>
		  		<c:when test="${requestScope.tipoRetorno == 'curso' }">
		  		<!-- Montagem de tela curso -->
			  		<th>Avaliacao</th>
			  		<th>Data Inicio avaliação</th>
			  		<th>Data Fim avaliação</th>
			  		<th>Média do Curso</th>
			  		<th>Curso</th>
			  		</thead>
			  		<tbody>
			  		<c:if test="${requestScope.resultados != null && requestScope.resultados.size() > 0 }">
			  		<!-- inicio do loop -->
			  			<c:forEach items="${requestScope.resultados}" var="resultado">
				  		<tr>
				  			<td>${resultado.agendamentoAvaliacao.avaliacao.nome}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataInicio}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataFim}</td>
				  			<td>${resultado.media}</td>
				  			<td>${resultado.agendamentoAvaliacao.curso.nome}</td>
				  		</tr>
				  		</c:forEach>
				  	<!-- fim do loop -->
				  	</c:if>
				<!-- FIM - Montagem de tela curso -->
			  	</c:when>
		  		<c:when test="${requestScope.tipoRetorno == 'infra' }">
		  		<!-- Montagem de tela infra -->
			  		<th>Avaliacao</th>
			  		<th>Data Inicio avaliação</th>
			  		<th>Data Fim avaliação</th>
			  		<th>Média da infra</th>
			  		</thead>
			  		<tbody>
			  		<c:if test="${requestScope.resultados != null && requestScope.resultados.size() > 0 }">
			  		<!-- inicio do loop -->
			  			<c:forEach items="${requestScope.resultados}" var="resultado">
				  		<tr>
				  			<td>${resultado.agendamentoAvaliacao.avaliacao.nome}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataInicio}</td>
				  			<td>${resultado.agendamentoAvaliacao.dataFim}</td>
				  			<td>${resultado.media}</td>
				  		</tr>
				  		</c:forEach>
				  	<!-- fim do loop -->
				  	</c:if>
				<!-- FIM - Montagem de tela infra -->
			  	</c:when>
	  		</c:choose>
	  		<!-- Fim montagem tipos de relatórios -->
  		</tbody>
	</table>
	</div>
	
	</div>

	
</div>

<jsp:include page="../footer.jsp" />