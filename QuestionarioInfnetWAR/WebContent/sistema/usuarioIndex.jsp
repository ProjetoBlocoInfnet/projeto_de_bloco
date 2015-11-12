<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
	<a href="ControllerLogin"><button type="button" class="btn btn-default">Voltar</button></a>
	<br><br>
	<form action="" method="get">
		<input type="hidden" name="tela" value="telaCadastro">
		<input type="submit" class="btn btn-info" value="Cadastrar Usuário">
	</form>
	<br>
	<form action="ControllerUsuario" method="post">
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
  		<th>Matrícula</th>
  		<th>Nome</th>
  		<th>Login</th>
  		<th>E-mail</th>
  		<th>CEP</th>
  		<th>Endereço</th>
  		<th>Perfil</th>
  		<th>Ação</th>
  		</thead>
  		<tbody>
  			<c:forEach var="pessoa" items="${listaPessoa}" >
		  		<tr>
		  			<td>${pessoa.matricula }</td>  
		  			<td>${pessoa.nome }</td>  		
		  			<td>${pessoa.usuario.login}</td>  		
		  			<td>${pessoa.email }</td> 
		  			<td>${pessoa.cep }</td>
		  			<td>${pessoa.endereco }</td>
		  			<td>${pessoa.usuario.perfil.nomePerfil }</td>  	  				
		  			<td>
		  				<a href="ControllerUsuario?tela=telaAlterar&matricula=${pessoa.matricula}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> | 
		  				<a href="ControllerUsuario?tela=excluir&matricula=${pessoa.matricula}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> 	  				
		  			</td>
		  		</tr>
	  		</c:forEach>
  		</tbody>
	</table>
	</div>
	
	</div>

	
</div>

<jsp:include page="../footer.jsp" />