
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />

<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/ajaxAgendamento.js"></script>

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerAgendamento"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alteração de Agendamentos de Avaliação</h2>
		<hr>
		<form action="ControllerAgendamento" method="post" class="form-horizontal">
			
		  <input type="hidden" name="action" value="alterar">
		  
		  <input type="hidden" name="id" value="${requestScope.agendamento.idAgendamento}">
		
		  <div class="form-group">
		    <label for="dataInicio" class="col-sm-2 control-label">Data Inicio</label>
		    <div class="col-sm-10">
		      <input type="text" name="dataInicio" class="form-control" id="dataInicio" placeholder="Data Inicio" value="${requestScope.agendamento.dataInicio}">
		    </div>		      
		      <script>
			      $(document).ready(function () {
			        $('#dataInicio').datepicker({
			            format: "dd/mm/yyyy",
			            language: "pt-BR"
			        });
			      });
			    </script>
		  </div>
		  
		  <div class="form-group">
		    <label for="dataFim" class="col-sm-2 control-label">Data Fim</label>		    
		    <div class="col-sm-10">		      
		      	<input type="text" name="dataFim" class="form-control" id="dataFim" placeholder="Data Fim" value="${requestScope.agendamento.dataFim}">
		     </div>		      
		      <script>
			      $(document).ready(function () {
			        $('#dataFim').datepicker({
			            format: "dd/mm/yyyy",
			            language: "pt-BR"
			        });
			      });
			    </script>
		  </div>


		  <div class="form-group">
		    <label for="avaliacao" class="col-sm-2 control-label">Avaliação</label>
		    	<div class="col-sm-10">
					<select name="avaliacao" id="avaliacao" class="form-control">
						<option value="">Selecionar</option>
				  		<c:if test="${requestScope.agendamento.avaliacao != null}">
						  <option value="${requestScope.agendamento.avaliacao.idAvaliacao}" selected>${requestScope.agendamento.avaliacao.nome}</option>
						</c:if>
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
					<select name="curso" id="curso" class="form-control" onchange="getModulosTurmas()">
						<option value="">Selecionar</option>
				  		<c:if test="${requestScope.agendamento.curso != null}">
						  <option value="${requestScope.agendamento.curso.idCurso}" selected>${requestScope.agendamento.curso.nome}</option>
						</c:if>
				  		<c:if test="${requestScope.cursos != null && requestScope.cursos.size() > 0 }">
		  					<c:forEach items="${requestScope.cursos}" var="curso">
							  <option value="${curso.idCurso}">${curso.nome}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>

		  <div class="form-group">
		    <label for="turma" class="col-sm-2 control-label">Turma</label>
		    	<div class="col-sm-10">
					<select name="turma" id="turma" class="form-control">
						<option value="">Selecione</option>
					  	<c:if test="${requestScope.agendamento.turma != null}">
						  <option value="${requestScope.agendamento.turma.idTurma}" selected>${requestScope.agendamento.turma.nomeTurma}</option>
						</c:if>
				  		<c:if test="${requestScope.turmas != null && requestScope.turmas.size() > 0 }">
		  					<c:forEach items="${requestScope.turmas}" var="turma">
							  <option value="${turma.idTurma}">${turma.nomeTurma}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>

		  <div class="form-group">
		    <label for="modulo" class="col-sm-2 control-label">Módulo</label>
		    	<div class="col-sm-10">
					<select name="modulo" id="modulo" class="form-control" onchange="getProfessores()">
						<option value="">Selecione</option>
						<c:if test="${requestScope.agendamento.modulo != null}">
						  <option value="${requestScope.agendamento.modulo.idModulo}" selected>${requestScope.agendamento.modulo.nomeModulo}</option>
						</c:if>
				  		<c:if test="${requestScope.modulos != null && requestScope.modulos.size() > 0 }">
		  					<c:forEach items="${requestScope.modulos}" var="modulo">
							  <option value="${modulo.idModulo}">${modulo.nomeModulo}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>


		  <div class="form-group">
		    <label for="professor" class="col-sm-2 control-label">Professor</label>
		    	<div class="col-sm-10">
					<select name="professor" id="professor" class="form-control">
						<option value="">Selecione</option>
				  		<c:if test="${requestScope.agendamento.professor != null}">
						  <option value="${requestScope.agendamento.professor.matricula}" selected>${requestScope.agendamento.professor.nome}</option>
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