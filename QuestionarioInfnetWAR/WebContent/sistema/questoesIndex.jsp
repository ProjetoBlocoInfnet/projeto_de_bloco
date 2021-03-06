<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
	<a href="ControllerLogin"><button type="button" class="btn btn-default">Voltar</button></a>
	<br><br>
	<form action="ControllerQuestao" method="get">
		<input type="hidden" name="tela" value="telaCadastro">
		<input type="submit" class="btn btn-info" value="Cadastrar Questão">
	</form>
	<br>
	<form action="ControllerQuestao" method="post">
		<input type="hidden" name="action" value="consultar">
		<div class="row">  
		  <div class="col-lg-6">
		    <div class="input-group">
		      <input type="text" name="textoQuestao" class="form-control" placeholder="Consultar por...">
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
	  		<th>Questão</th>
	  		<th>Categoria</th>
	  		<th>tipoResposta</th>
	  		<th>Status</th>
	  		<th>Ação</th>
  		</thead>
  		<tbody>
  			<c:forEach var="questao" items="${listaQuestao}">
		  		<tr>
		  			<td>${questao.textoQuestao}</td>  
		  			<td>${questao.categoria}</td>  		
		  			<td>${questao.tipoResposta}</td>
		  			<td>${questao.status}</td>   				
		  			<td>
		  				<a href="ControllerQuestao?tela=telaAlterar&idQuestao=${questao.idQuestao}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> | 
		  				<a href="ControllerQuestao?tela=excluir&idQuestao=${questao.idQuestao}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> 	  				
		  			</td>
		  		</tr>
	  		</c:forEach>
  		</tbody>
	</table>
	
</div>

<jsp:include page="../footer.jsp" />