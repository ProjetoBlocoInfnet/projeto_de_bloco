<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menu.jsp" />
  

<div id="container" class="container-fluid">

	<div class="container">
		<a href="ControllerQuestao"><button type="button" class="btn btn-default">Voltar</button></a>
		<br><br>
		
		<h2>Alterar  Questão</h2>
		<hr>
		
		<form action="ControllerQuestao" method="post" class="form-horizontal">
			
			  <input type="hidden" name="action" value="alterar">
			  <input type="hidden" name="idQuestao" value="${questao.idQuestao}">
			  
		
			  <div class="form-group">
			    <label for="questao" class="col-sm-2 control-label">Questão</label>
			    <div class="col-sm-10">
			      <textarea name="questao" class="form-control" id="questao" placeholder="Quest�o">${questao.textoQuestao}</textarea>
			    </div>
			  </div>
			  		 		 
			  <div class="form-group">
			    <label for="categoria" class="col-sm-2 control-label">Categoria</label>
			    	<div class="col-sm-10">
						  <select name="categoria" id="categoria" class="form-control">
							  <option>Selecionar</option>
							  <c:forEach var="categoria" items="${categorias}">
							  		<option value="${categoria}" ${categoria eq questao.categoria ? 'selected="selected"' : ''} >${categoria.categoria }</option>
							  </c:forEach>
						</select>
			  		</div>
			  </div>
			  
			  <div class="form-group">
			    <label for="tipoResposta" class="col-sm-2 control-label">Categoria</label>
			    	<div class="col-sm-10">
						  <select name="tipoResposta" id="tipoResposta" class="form-control">
							  <option >Selecionar</option>
							  <c:forEach var="tipo" items="${tipoResposta}">
							  		<option value="${tipo}" ${tipo eq questao.tipoResposta ? 'selected="selected"' : ''} >${tipo}</option>
							  </c:forEach>
						</select>
			  		</div>
			  </div>
			  
			  <div class="form-group">
			    <label for="status" class="col-sm-2 control-label">Status</label>
			    	<div class="col-sm-10">
						  <select name="status" id="status" class="form-control">
							  <option >Selecionar</option>
							  <c:forEach var="status" items="${listaStatus}">
							  		<option value="${status}" ${status eq questao.status ? 'selected="selected"' : ''} >${status.status}</option>
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