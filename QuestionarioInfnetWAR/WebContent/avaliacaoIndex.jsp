
<jsp:include page="openDoc.jsp" />

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
	<form action="ControllerAvaliacao" method="post">
		<input type="hidden" name="action" value="telaCadastro">
		<input type="submit" class="btn btn-info" value="Cadastrar Avalia��o">
	</form>
	<br>
	<form action="ControllerAvaliacao" method="post">
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
	
	<div >
	<table class="table table-hover">
  		<thead>
  		<th>Id</th>
  		<th>Avalia��o</th>
  		<th>Curso</th>
  		<th>Professor</th>
  		<th>Quest�es</th>
  		<th>A��o</th>
  		</thead>
  		<tbody>
  		
	  		<tr>
	  			<td>1</td>  
	  			<td>Avalia��o 1</td>  		
	  			<td>P�s-gradua��o em Engenharia de Software com JAVA</td>  		
	  			<td>Helbert Moraes</td> 
	  			<td>Quest�es</td>  	  				
	  			<td>
	  				<a href=""><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> | 
	  				<a href=""><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> 	  				
	  			</td>
	  		</tr>
  		</tbody>
	</table>
	</div>
	
	</div>

	
</div>

<jsp:include page="footer.jsp" />