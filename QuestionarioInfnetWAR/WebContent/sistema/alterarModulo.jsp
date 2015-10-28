
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerModulo"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alteração de Módulos</h2>
		<hr>
		<form action="ControllerModulo" method="post" class="form-horizontal">
			
		  <input type="hidden" name="action" value="alterar">
		  <input type="hidden" name="id" value="${modulo.idModulo}">
		
		  <div class="form-group">
		    <label for="avaliacao" class="col-sm-2 control-label">Módulo</label>
		    <div class="col-sm-10">
		      <input type="text" name="nome" class="form-control" id="avaliacao" placeholder="avaliacao" value="${modulo.nomeModulo}">
		    </div>
		  </div>
		 		 
		  <div class="form-group">
		    <label for="questoes" class="col-sm-2 control-label">Professores</label>
		    	<div class="col-sm-10">
					<select name="professores" id="professores" class="form-control">
				  		<c:if test="${requestScope.professores != null && requestScope.professores.size() > 0 }">
		  					<c:forEach items="${requestScope.professores}" var="professor">
								<option value="${professor.matricula}" ${professor.matricula eq modulo.professor.matricula ? 'selected' : ''}>${professor.nome}</option>
							</c:forEach>
						</c:if>
					</select>
		  		</div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Alterar Módulo</button>
		    </div>
		  </div>
		</form>
	
	</div>
	
	<hr>
	
</div>

<jsp:include page="../footer.jsp" />