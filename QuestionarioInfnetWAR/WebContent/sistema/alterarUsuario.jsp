<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerUsuario"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alterar Usuário</h2>
		<hr>
		<form action="ControllerUsuario" method="post" class="form-horizontal">
		
		  <input type="hidden" name="action" value="alterar" />
		  <input type="hidden" name="matricula" value="${pessoa.matricula }" />
		
		  <div class="form-group">
		    <label for="login" class="col-sm-2 control-label">Login</label>
		    <div class="col-sm-10">
		      <input type="text" name="login" class="form-control" id="login" placeholder="Login" value="${pessoa.usuario.login }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="senha" class="col-sm-2 control-label">Senha</label>
		    <div class="col-sm-10">
		      <input type="password" name="senha" class="form-control" id="senha" placeholder="Senha">
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">E-mail</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email" placeholder="E-mail" value="${pessoa.email }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <input type="text" name="nome" class="form-control" id="nome" placeholder="Nome" value="${pessoa.nome }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="cep" class="col-sm-2 control-label">CEP</label>
		    <div class="col-sm-10">
		      <input type="text" name="cep" class="form-control" id="cep" placeholder="CEP" value="${pessoa.cep }">
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="endereco" class="col-sm-2 control-label">Endereço</label>
		    <div class="col-sm-10">
		      <input type="text" name="endereco" class="form-control" id="endereco" placeholder="Endere�o" value="${pessoa.endereco }">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="perfil" class="col-sm-2 control-label">Perfil</label>
		    	<div class="col-sm-10">
					  <select name="perfil" id="perfil" class="form-control">
					   <c:forEach var="perfil" items="${listaPerfil}">
							  		<option value="${perfil.idPerfil}" ${pessoa.usuario.perfil.idPerfil eq perfil.idPerfil ? 'selected="selected"' : '' }>${perfil.nomePerfil}</option>
					</c:forEach>
					</select>
		  		</div>
		  </div>
		  
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Alterar</button>
		    </div>
		  </div>
		</form>
	
	</div>

	
</div>

<jsp:include page="../footer.jsp" />