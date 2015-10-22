
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
		<a href="index.jsp"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de Avaliações</h2>
		<hr>
		<form class="form-horizontal">
		  <div class="form-group">
		    <label for="login" class="col-sm-2 control-label">Avaliacao</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="avaliacao" placeholder="avaliacao">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="senha" class="col-sm-2 control-label">Curso</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="curso" placeholder="Curso">
		    </div>
		  </div>
		 		 
		  <div class="form-group">
		    <label for="permissao" class="col-sm-2 control-label">Questões</label>
		    	<div class="col-sm-10">
					  <select name="questoes" id="questoes" multiple="multiple" class="form-control">
					  <option>Como o professor foi ? | Professor</option>
					  <option>Os equipamentos estavam em bom estado? | Equipamentos</option>
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