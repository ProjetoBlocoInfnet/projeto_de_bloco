<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<img src="resources/img/logoInfnet3.png">  
		
		<ul id="menu" class="nav navbar-nav navbar-right">	 
	        <li class="dropdown principal">
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
	            		<span class="glyphicon glyphicon-list" aria-hidden="true"> Questões</span> 
	            	</a>
	            </li>
	            <li>
	            	<a href="ControllerAvaliacao">
	            		<span class="glyphicon glyphicon-list-alt" aria-hidden="true"> Avaliações</span> 
	            	</a>
	            </li>
	             <li>
	            	<a href="ControllerModulo">
	            		<span class="glyphicon glyphicon-th" aria-hidden="true"> Módulo</span> 
	            	</a>
	            </li>
	            <li>
	            	<a href="ControllerTurma">
	            		<span class="glyphicon glyphicon-education" aria-hidden="true"> Turma</span> 
	            	</a>
	            </li>
	             <li>
	            	<a href="ControllerCurso">
	            		<span class="glyphicon glyphicon-book" aria-hidden="true"> Curso</span> 
	            	</a>
	            </li>
	            
	          </ul>
	        </li>	        
        	<li class="principal">
        		<a href="ControllerMediaHistorica" >
        			 Média Histórica <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
        		</a>
       		</li>
			
       		<li class="principal">
        		<a href="ControllerAgendamento" >
        			 Agendamento <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
        		</a>
       		</li>
       		<li class="barra"></li>
       		<li>
       			
	       		<form id="logout" action="ControllerLogout" method="post" class="navbar-form navbar">
				  <div class="form-group">
				      <p id="userLogado"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> : ${pessoa.usuario.login} </p> 
				      <button type="submit" class="btn btn-primary">Logout</button>
				  </div>
				</form>
			</li>
      	</ul>      				  
	</div>	
	
	
</nav>