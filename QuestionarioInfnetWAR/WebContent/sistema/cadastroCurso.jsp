<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerCurso"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de Curso</h2>
		<hr>
		<form action="ControllerCurso" method="post" class="form-horizontal">
		
		  <input type="hidden" name="action" value="cadastrar" />
		
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <input type="text" name="nomeCurso" class="form-control" id="nome" placeholder="Nome">
		    </div>
		  </div>
		 		  
		  
		  <div class="form-group">
		    <label for="modulos" class="col-sm-2 control-label">Módulos</label>
		    	<div class="col-sm-10">
					  <select name="modulos" id="modulos" class="form-control" multiple="multiple">
					   <c:forEach var="modulo" items="${listaModulos}">
							  <option value="${modulo.idModulo}">${modulo.nomeModulo}</option>
					</c:forEach>
					</select>
		  		</div>
		  </div>
		  
		  <div class="form-group">
		    <label for="turmas" class="col-sm-2 control-label">Turmas</label>
		    	<div class="col-sm-10">
					  <select name="turmas" id="turmas" class="form-control" multiple="multiple">
					   <c:forEach var="turma" items="${listaTurma}">
							  		<option value="${turma.idTurma}">${turma.nomeTurma}</option>
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