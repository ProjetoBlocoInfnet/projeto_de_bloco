<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerTurma"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alterar Turma</h2>
		<hr>
		<form action="ControllerTurma" method="post" class="form-horizontal">
		
		  <input type="hidden" name="action" value="alterar" />
		
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <input type="text" name="nome" class="form-control" id="nome" placeholder="Nome" value="${turma.nomeTurma }">
		    </div>
		  </div>
		 
		   <div class="form-group">
		    <label for="Curso" class="col-sm-2 control-label">Cursos</label>
		    	<div class="col-sm-10">
					  <select name="perfil" id="perfil" class="form-control" multiple="multiple">
					   <c:forEach var="curso" items="${listaCursos}">
							  		<option value="${curso.idCurso}">${curso.nome}</option>
					</c:forEach>
					</select>
		  		</div>
		  </div>
		  
		   <div class="form-group">
		    <label for="professores" class="col-sm-2 control-label">Professores</label>
		    	<div class="col-sm-10">
					  <select name="professores" id="professores" class="form-control" multiple="multiple">
					   <c:forEach var="professor" items="${listaProfessores}">
							  		<option value="${professor.matricula}">${professor.nome}</option>
					</c:forEach>
					</select>
		  		</div>
		  </div>
		  
		  <div class="form-group">
		    <label for="alunos" class="col-sm-2 control-label">Alunos</label>
		    	<div class="col-sm-10">
					  <select name="alunos" id="alunos" class="form-control" multiple="multiple">
					   <c:forEach var="aluno" items="${listaAlunos}">
							  		<option value="${aluno.matricula}">${aluno.nome}</option>
					</c:forEach>
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