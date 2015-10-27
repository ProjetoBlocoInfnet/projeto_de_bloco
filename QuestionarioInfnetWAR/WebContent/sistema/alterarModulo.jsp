
<jsp:include page="../openDoc.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerAvaliacao"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alteração de Avaliações</h2>
		<hr>
		<form action="ControllerModulo" method="post" class="form-horizontal">
			
		  <input type="hidden" name="action" value="alterar">
		  <input type="hidden" name="id" value="${avaliacao.idAvaliacao}">
		
		  <div class="form-group">
		    <label for="avaliacao" class="col-sm-2 control-label">Avaliacao</label>
		    <div class="col-sm-10">
		      <input type="text" name="nome" class="form-control" id="avaliacao" placeholder="avaliacao" value="${avaliacao.nome}">
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
			    <label for="status" class="col-sm-2 control-label">Status</label>
			    	<div class="col-sm-10">
						  <select name="status" id="status" class="form-control">
							  <option >Selecionar</option>
							  <c:forEach var="status" items="${listaStatus}">
							  		<option value="${status}" ${status eq avaliacao.status ? 'selected="selected"' : ''} >${status.status}</option>
							  </c:forEach>
						</select>
			  		</div>
			  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Alterar Avaliação</button>
		    </div>
		  </div>
		</form>
	
	</div>
	
	<hr>
	
	<div class="container">
		<h2>Questões Atuais</h2>
		<hr>
		<table class="table table-hover">
	  		<thead>
		  		<th>Questão</th>
		  		<th>Categoria</th>
		  		<th>tipoResposta</th>
		  		<th>Status</th>
		  		<th>Ação</th>
	  		</thead>
	  		<tbody>
	  		 
	  			<c:forEach var="questao" items="${avaliacao.listQuestao}">
			  		<tr>
			  			<td>${questao.textoQuestao}</td>  
			  			<td>${questao.categoria}</td>  		
			  			<td>${questao.tipoResposta}</td>
			  			<td>${questao.status}</td>   				
			  			<td>			  				
			  				<a href="ControllerAvaliacao?action=excluirQuestao&id=${avaliacao.idAvaliacao}&idQuestao=${questao.idQuestao}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a> 	  				
			  			</td>
			  		</tr>
		  		</c:forEach>
		  	 
	  		</tbody>
		</table>
	</div>
	
</div>

<jsp:include page="../footer.jsp" />