
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerAvaliacao"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de M�dulos</h2>
		<hr>
		<form action="ControllerModulo" method="post" class="form-horizontal">
			
		  <input type="hidden" name="action" value="cadastrar">
		
		  <div class="form-group">
		    <label for="avaliacao" class="col-sm-2 control-label">M�dulo</label>
		    <div class="col-sm-10">
		      <input type="text" name="nome" class="form-control" id="avaliacao" placeholder="M�dulo">
		    </div>
		  </div>
		 		 
		  <div class="form-group">
		    <label for="questoes" class="col-sm-2 control-label">Professores</label>
		    	<div class="col-sm-10">
					<select name="questoes" id="questoes" multiple="multiple" class="form-control">
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