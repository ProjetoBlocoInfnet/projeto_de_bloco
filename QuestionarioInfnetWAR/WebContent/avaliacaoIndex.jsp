
<jsp:include page="openDoc.jsp" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<img src="resources/img/logoInfnet3.png">  
		
		<form id="logout" action="Logout" method="post" class="navbar-form navbar-right">
		  <div class="form-group">
		      <button type="submit" class="btn btn-primary">Logout</button>
		  </div>
		</form>
      					  
	</div>	
	
</nav>
  

<div id="container" class="container-fluid">

	<div class="container">
	<a href="index.jsp"><button type="button" class="btn btn-default">Voltar</button></a>
	<br><br>
	<form action="" method="post">
		<input type="hidden" name="action" value="telaCadastro">
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
	
	<div >
	<table class="table table-hover">
  		<thead>
  		<th>Id</th>
  		<th>Avaliação</th>
  		<th>Curso</th>
  		<th>Professor</th>
  		<th>Questões</th>
  		<th>Ação</th>
  		</thead>
  		<tbody>
  		
	  		<tr>
	  			<td>1</td>  
	  			<td>Avaliação 1</td>  		
	  			<td>Pós-graduação em Engenharia de Software com JAVA</td>  		
	  			<td>Helbert Moraes</td> 
	  			<td>Questões</td>  	  				
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