<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="openDoc.jsp" />


<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container">
		<img src="resources/img/logoInfnet3.png"> 
		
		<form action="ControllerLogin" method="post" class="navbar-form navbar-right" id="formLogin">
		  <div class="form-group">
		    <label class="sr-only" for="login">Login</label>
		    <input type="text" class="form-control" name="login" id="login" placeholder="Login">
		  </div>
		  <div class="form-group">
		    <label class="sr-only" for="senha">Senha</label>
		    <input type="password" class="form-control" name="senha" id="senha" placeholder="Senha">
		  </div>
		  <div class="checkbox" id="esqueceuSenha" name="esqueceuSenha">
		    <label>
		      <input type="checkbox" value="S"> Esqueceu a senha?
		    </label>
		  </div>
		  <button type="submit" class="btn btn-primary">Login</button>
		</form> 
	</div>
	
	
</nav>

<div id="containerSlider" class="container-fluid">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> 

	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img class="img-responsive" src="resources/img/2.jpg">
	    </div>
	    <div class="item">
	      <img class="img-responsive" src="resources/img/3.jpg">
	    </div>
	    <div class="item">
	      <img class="img-responsive" src="resources/img/8.jpg">
	    </div>
	  </div> 
	</div>
</div>
<div id="footer" class="container-fluid"></div>
<jsp:include page="footer.jsp" />