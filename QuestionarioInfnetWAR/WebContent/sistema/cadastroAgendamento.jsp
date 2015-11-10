
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />

<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/ajaxAgendamento.js"></script>

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerAgendamento"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de Agendamentos de Avalia��o</h2>
		<hr>
		<form action="ControllerAgendamento" method="post" class="form-horizontal">
			
		  <input type="hidden" name="action" value="cadastrar">
		
		  <div class="form-group">
		    <label for="dataInicio" class="col-sm-2 control-label">Data Inicio</label>
		    <div class="col-sm-10">
		      <input type="date" name="dataInicio" class="form-control" id="dataInicio" placeholder="Data Inicio"/>
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="dataFim" class="col-sm-2 control-label">Data Fim</label>
		    <div class="col-sm-10">
		      <input type="date" name="dataFim" class="form-control" id="dataFim" placeholder="Data Fim"/>
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="avaliacao" class="col-sm-2 control-label">Avalia��o</label>
		    	<div class="col-sm-10">
					<select name="avaliacao" id="avaliacao" class="form-control">
						<option value="">Selecionar</option>
				  		<c:if test="${requestScope.avaliacoes != null && requestScope.avaliacoes.size() > 0 }">
		  					<c:forEach items="${requestScope.avaliacoes}" var="avaliacao">
							  <option value="${avaliacao.idAvaliacao}">${avaliacao.nome}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>


		  <div class="form-group">
		    <label for="curso" class="col-sm-2 control-label">Curso</label>
		    	<div class="col-sm-10">
					<select name="curso" id="curso" class="form-control" onchange="getModulos()">
						<option value="">Selecionar</option>
				  		<c:if test="${requestScope.cursos != null && requestScope.cursos.size() > 0 }">
		  					<c:forEach items="${requestScope.cursos}" var="curso">
							  <option value="${curso.idCurso}">${curso.nome}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>

		  <div class="form-group">
		    <label for="modulo" class="col-sm-2 control-label">M�dulo</label>
		    	<div class="col-sm-10">
					<select name="modulo" id="modulo" class="form-control">
						<option value="">Selecionar</option>
				  		
					</select>
		  		</div>
		  </div>

		  <div class="form-group">
		    <label for="turma" class="col-sm-2 control-label">Turma</label>
		    	<div class="col-sm-10">
					<select name="turma" id="turma" class="form-control">
						<option value="">Selecionar</option>
				  		<c:if test="${requestScope.turmas != null && requestScope.turmas.size() > 0 }">
		  					<c:forEach items="${requestScope.turmas}" var="turma">
							  <option value="${turma.idTurma}">Turma ${turma.nomeTurma}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>

		  <div class="form-group">
		    <label for="professor" class="col-sm-2 control-label">Professor</label>
		    	<div class="col-sm-10">
					<select name="professor" id="professor" class="form-control">
						<option value="">Selecionar</option>
				  		<c:if test="${requestScope.professores != null && requestScope.professores.size() > 0 }">
		  					<c:forEach items="${requestScope.professores}" var="professor">
							  <option value="${professor.matricula}">${professor.nome}</option>
							</c:forEach>
						</c:if>
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