<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="/sistema/index.jsp"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de Usuários</h2>
		<hr>
		<form class="form-horizontal">
		  <div class="form-group">
		    <label for="login" class="col-sm-2 control-label">Login</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="login" placeholder="Login">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="senha" class="col-sm-2 control-label">Senha</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="senha" placeholder="Senha">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <input type="tyext" class="form-control" id="senha" placeholder="Nome">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="cep" class="col-sm-2 control-label">CEP</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="cep" placeholder="CEP">
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="endereco" class="col-sm-2 control-label">Endereço</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="endereco" placeholder="Endereço">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="perfil" class="col-sm-2 control-label">Perfil</label>
		    	<div class="col-sm-10">
					  <select name="perfil" id="perfil" class="form-control">
					   <c:forEach var="perfil" items="${listaPerfil}">
							  		<option value="${perfil.idPerfil}">${perfil.nomePerfil}</option>
					</c:forEach>
					</select>
		  		</div>
		  </div>
		  
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Cadastrar</button>
		    </div>
		  </div>
		</form>
	
	</div>

	
</div>

<jsp:include page="../footer.jsp" />