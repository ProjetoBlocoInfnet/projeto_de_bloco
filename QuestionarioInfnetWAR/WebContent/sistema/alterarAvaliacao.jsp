
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerAvaliacao"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alterar Avalia��o</h2>
		<hr>
		<form class="form-horizontal">
		  <div class="form-group">
		    <label for="login" class="col-sm-2 control-label">Avaliacao</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="avaliacao" placeholder="avaliacao">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="permissao" class="col-sm-2 control-label">Quest�es</label>
		    	<div class="col-sm-10">
					  <select name="questoes" id="questoes" multiple="multiple" class="form-control">
					  <option>Como o professor foi ? | Professor</option>
					  <option>Os equipamentos estavam em bom estado? | Equipamentos</option>
					</select>
		  		</div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Alterar</button>
		    </div>
		  </div>
		</form>
	
	</div>

	
</div>

<jsp:include page="../footer.jsp" />