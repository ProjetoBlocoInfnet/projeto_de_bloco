
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
	<form action="ControllerQuestao" method="post">
		<input type="hidden" name="action" value="telaCadastro">
		<input type="submit" class="btn btn-info" value="Cadastrar Quest�o">
	</form>
	<br>
	<form action="ControllerQuestao" method="post">
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
  		<th>Quest�o</th>
  		<th>Categoria</th>
  		<th>A��o</th>
  		</thead>
  		<tbody>
  		
	  		<tr>
	  			<td>1</td>  
	  			<td>At� agora, o curso est� atingindo as minhas expectativas</td>  		
	  			<td>elom</td> 	  				
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