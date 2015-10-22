<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../openDoc.jsp" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<img src="resources/img/logoInfnet3.png">  
		
		<ul id="menu" class="nav navbar-nav navbar-right">	 
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
	         Áreas  <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li>
	            	<a href="ControllerUsuario">
	            		<span class="glyphicon glyphicon-user" aria-hidden="true"> Usuários</span> 
	            	</a>
	            </li>
	            <li>
	            	<a href="ControllerQuestao">
	            		<span class="glyphicon glyphicon-list aria-hidden="true"> Questões</span> 
	            	</a>
	            </li>
	            <li>
	            	<a href="ControllerAvaliacao">
	            		<span class="glyphicon glyphicon-list-alt" aria-hidden="true"> Avaliações</span> 
	            	</a>
	            </li>
	            
	          </ul>
	        </li>
        	<li>
        		<a href="ControllerMediaHistorica" >
        			 Média Histórica <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
        		</a>
       		</li>
       		<li>
	       		<form id="logout" action="Logout" method="post" class="navbar-form navbar">
				  <div class="form-group">
				      <button type="submit" class="btn btn-primary">Logout</button>
				  </div>
				</form>
			</li>
      	</ul>      			  
	</div>	
	
</nav>
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerQuestao"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de Questões</h2>
		<hr>
		
		<form action="ControllerQuestao" method="post" class="form-horizontal">
			
			  <input type="hidden" name="action" value="cadastrar">
		
			  <div class="form-group">
			    <label for="questao" class="col-sm-2 control-label">Questão</label>
			    <div class="col-sm-10">
			      <textarea name="questao" class="form-control" id="questao" placeholder="Questão"></textarea>
			    </div>
			  </div>
			  		 		 
			  <div class="form-group">
			    <label for="categoria" class="col-sm-2 control-label">Categoria</label>
			    	<div class="col-sm-10">
						  <select name="categoria" id="categoria" class="form-control">
							  <option>Selecionar</option>
							  <c:forEach var="categoria" items="${categorias}">
							  		<option value="${categoria}">${categoria.categoria }</option>
							  </c:forEach>
						</select>
			  		</div>
			  </div>
			  
			  <div class="form-group">
			    <label for="tipoResposta" class="col-sm-2 control-label">Categoria</label>
			    	<div class="col-sm-10">
						  <select name="tipoResposta" id="tipoResposta" class="form-control">
							  <option>Selecionar</option>
							  <c:forEach var="tipo" items="${tipoResposta}">
							  		<option value="${tipo}">${tipo}</option>
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