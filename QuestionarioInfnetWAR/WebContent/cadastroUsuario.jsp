
<jsp:include page="openDoc.jsp" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<img src="resources/img/logoInfnet3.png">  
		
		<ul id="menu" class="nav navbar-nav navbar-right">	 
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">�rea <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Usu�rios</a></li>
	            <li><a href="#">Quest�es</a></li>
	            <li><a href="#">Avalia��es</a></li>
	          </ul>
	        </li>
        	<li><a href="#" >M�dia Hist�rica</a></li>
      	</ul>
      					  
	</div>	
	
</nav>
  

<div id="container" class="container-fluid">

	<div class="container">
	
		<h2>Cadastro de Usu�rios</h2>
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
		    <label for="matricula" class="col-sm-2 control-label">Matr�cula</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="matricula" placeholder="Matr�cula">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="permissao" class="col-sm-2 control-label">Permiss�o</label>
		    	<div class="col-sm-10">
					  <select name="permissao" id="permissao" class="form-control">
					  <option>Aluno</option>
					  <option>Administrador</option>
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

<jsp:include page="footer.jsp" />