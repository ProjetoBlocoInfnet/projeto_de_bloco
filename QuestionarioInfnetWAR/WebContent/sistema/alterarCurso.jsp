<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerCurso"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alteração de Curso</h2>
		<hr>
		<form action="ControllerCurso" method="post" class="form-horizontal">
		
		  <input type="hidden" name="action" value="alterar" />
		
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <input type="text" name="nomeCurso" class="form-control" id="nome" placeholder="Nome" value="${curso.nome }">
		    </div>
		  </div>
		 		  
		  <div class="form-group">
		    <label for="modulo" class="col-sm-2 control-label">Módulos</label>
		    	<div class="col-sm-10">
					<select name="modulos" id="modulo" class="form-control" multiple="multiple">
						<c:if test="${requestScope.meusModulos != null && requestScope.meusModulos.size() > 0 }">
							<c:forEach var="meuModulo" items="${requestScope.meusModulos}">
								<option value="${meuModulo.idModulo}" selected>${meuModulo.nomeModulo}</option>
							</c:forEach>
						</c:if>
						<c:if test="${requestScope.listaModulos != null && requestScope.listaModulos.size() > 0 }">
							<c:forEach var="modulosRestantes" items="${requestScope.listaModulos}">
								<option value="${modulosRestantes.idModulo}" >${modulosRestantes.nomeModulo}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>
		  
		  <div class="form-group">
		    <label for="turmas" class="col-sm-2 control-label">Turmas</label>
		    	<div class="col-sm-10">
					<select name="turmas" id="turmas" class="form-control" multiple="multiple">
						<c:if test="${requestScope.meusTurmas != null && requestScope.meusTurmas.size() > 0 }">
							<c:forEach var="turma" items="${requestScope.meusTurmas}">
								<option value="${turma.idTurma}">${turma.nomeTurma}</option>
							</c:forEach>
						</c:if>
						<c:if test="${requestScope.listaTurma != null && requestScope.listaTurma.size() > 0 }">
							<c:forEach var="turma" items="${requestScope.listaTurma}">
								<option value="${turma.idTurma}">${turma.nomeTurma}</option>
							</c:forEach>
						</c:if>
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