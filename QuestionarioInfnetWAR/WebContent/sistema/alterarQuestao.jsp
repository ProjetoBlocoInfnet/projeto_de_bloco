
<jsp:include page="../openDoc.jsp" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<img src="resources/img/logoInfnet3.png">  
		
		<ul id="menu" class="nav navbar-nav navbar-right">	 
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
	         �reas  <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li>
	            	<a href="ControllerUsuario">
	            		<span class="glyphicon glyphicon-user" aria-hidden="true"> Usu�rios</span> 
	            	</a>
	            </li>
	            <li>
	            	<a href="ControllerQuestao">
	            		<span class="glyphicon glyphicon-list aria-hidden="true"> Quest�es</span> 
	            	</a>
	            </li>
	            <li>
	            	<a href="ControllerAvaliacao">
	            		<span class="glyphicon glyphicon-list-alt" aria-hidden="true"> Avalia��es</span> 
	            	</a>
	            </li>
	            
	          </ul>
	        </li>
        	<li>
        		<a href="ControllerMediaHistorica" >
        			 M�dia Hist�rica <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
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
		
		<h2>Alterar de Quest�o</h2>
		<hr>
		<form class="form-horizontal">
		  <div class="form-group">
		    <label for="login" class="col-sm-2 control-label">Quest�o</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="login" placeholder="Quest�o"></textarea>
		    </div>
		  </div>
		  		 		 
		  <div class="form-group">
		    <label for="permissao" class="col-sm-2 control-label">Categoria</label>
		    	<div class="col-sm-10">
					  <select name="permissao" id="permissao" class="form-control">
						  <option>Selecionar</option>
						  <option>Professor</option>
						  <option>Equipamentos</option>
						  <option>Curso</option>
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