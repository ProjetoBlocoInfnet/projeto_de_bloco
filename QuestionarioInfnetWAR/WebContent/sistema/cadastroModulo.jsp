
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerAvaliacao"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Cadastro de Avaliações</h2>
		<hr>
		<form action="ControllerModulo" method="post" class="form-horizontal">
			
		  <input type="hidden" name="action" value="cadastrar">
		
		  <div class="form-group">
		    <label for="avaliacao" class="col-sm-2 control-label">Avaliacao</label>
		    <div class="col-sm-10">
		      <input type="text" name="nome" class="form-control" id="avaliacao" placeholder="avaliacao">
		    </div>
		  </div>
		 		 
		  <div class="form-group">
		    <label for="questoes" class="col-sm-2 control-label">Questões</label>
		    	<div class="col-sm-10">
					<select name="questoes" id="questoes" multiple="multiple" class="form-control">
				  		<c:if test="${requestScope.questoes != null && requestScope.questoes.size() > 0 }">
		  					<c:forEach items="${requestScope.questoes}" var="questao">
							  <option value="${questao.idQuestao}">${questao.textoQuestao} | ${questao.categoria.getCategoria()}</option>
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