<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../openDoc.jsp" />

<jsp:include page="menuAvaliacao.jsp" />
  

<div id="containerFormulario" class="container-fluid">

	<div class="container">
	
	<div class="page-header">
  		<h2><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> AcademicNet <small> - Formulário de Avaliação</small></h2>
  		<hr>
  		<div id="infoUserCurso">
			<span class="glyphicon glyphicon-user" aria-hidden="true"> Nome: "${requestScope.aluno.nome}"</span> &nbsp;&nbsp; || &nbsp;&nbsp;
			<span class="glyphicon glyphicon-book" aria-hidden="true"> Curso: "${requestScope.curso.nome}" </span> &nbsp;&nbsp; || &nbsp;&nbsp;
			<span class="glyphicon glyphicon-user" aria-hidden="true"> Professor: "${requestScope.professor.nome}"</span> <br/>
		</div>
	</div>
	
	<form action="ControllerFormularioAvaliacao" method="post">		
		
			<input type="hidden" name="idAgendamento" value="${requestScope.idAgendamento}"/>
			<input type="hidden" name="idAluno" value="${requestScope.aluno.usuario}"/>
			
			<div class="table-responsive">
				<table class="table table-hover" id="avaliacao">
			  		<thead id="opcoes">
				  		<th id="first"></th>
				  		<th>Concordo totalmente</th>
				  		<th>Concordo</th>
				  		<th>Não concordo nem discordo</th>
				  		<th>Discordo</th>
				  		<th>Discordo totalmente</th>
				  		<th>Não sei avaliar</th>
			  		</thead>
			  		
			  		<c:if test="${requestScope.questoes != null && requestScope.questoes.size() > 0 }">
			  		<tbody>
				  		
				  		<!-- inicio do loop Curso -->
				  		<tr>
				  			<td class="questaoInfo" id="questaoInfoFirst"><h4>Avaliação geral da Pós-Graduação:</h4></td>
				  		</tr>
				  			<c:forEach items="${requestScope.questoes}" var="questao">
				  				<c:if test="${questao.categoria.getCategoria() == 'Curso'}">
							  		<tr>
							  			<td>${questao.textoQuestao}</td>						  			
							  			<c:choose>						  				
							  				<c:when test="${questao.tipoResposta == 'LIKERT'}">
							  					<td><input type="radio" name="${questao.idQuestao}" value="5" class="radio"/></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="4" class="radio"/></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="3" class="radio" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="2" class="radio"/></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="1" class="radio"/></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="0" class="radio"/></td>
							  				</c:when>
							  				
							  				<c:when test="${questao.tipoResposta == 'TEXTO'}">
							  					<td  colspan="6"><textarea name="${questao.idQuestao}" class="form-control" rows="3" ></textarea></td>
							  				</c:when>						  			
							  			</c:choose>					  			
							  		<tr>	
						  		</c:if>
					  		</c:forEach>
					  	<!-- fim do loop Curso -->
				  		<!-- inicio do loop Professor -->
				  		</tbody>
				  		
				  		<tbody>
				  		<tr>
				  			<td class="questaoInfo" colspan="7"><h4>Avaliação do professor no módulo:</h4></td>
				  		<tr> 
				  			<c:forEach items="${requestScope.questoes}" var="questao">
				  				<c:if test="${questao.categoria.getCategoria() == 'Professor'}">
							  		<tr>
							  			<td>${questao.textoQuestao}</td>						  			
							  			<c:choose>						  				
							  				<c:when test="${questao.tipoResposta == 'LIKERT'}">
							  					<td><input type="radio" name="${questao.idQuestao}" value="5" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="4" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="3" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="2" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="1" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="0" /></td>
							  				</c:when>
							  				
							  				<c:when test="${questao.tipoResposta == 'TEXTO'}">
							  					<td colspan="6"><textarea name="${questao.idQuestao}" class="form-control" rows="3" ></textarea></td>
							  				</c:when>						  			
							  			</c:choose>					  			
							  		<tr>	
						  		</c:if>
					  		</c:forEach>
					  	<!-- fim do loop Professor -->
				  		<!-- inicio do loop Equipamentos -->
				  		</tbody>
				  		
				  		<tbody>
				  		<tr>
				  			<td class="questaoInfo" colspan="7"><h4>Avaliação de Conteúdo e infra-estrutura no módulo:</h4></td>
				  		</tr>
				  			<c:forEach items="${requestScope.questoes}" var="questao">
				  				<c:if test="${questao.categoria.getCategoria() == 'Conteúdo e Infra-Estrutura do módulo'}">
							  		<tr>
							  			<td>${questao.textoQuestao}</td>						  			
							  			<c:choose>						  				
							  				<c:when test="${questao.tipoResposta == 'LIKERT'}">
							  					<td><input type="radio" name="${questao.idQuestao}" value="5" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="4" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="3" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="2" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="1" /></td>
								  				<td><input type="radio" name="${questao.idQuestao}" value="0" /></td>
							  				</c:when>
							  				
							  				<c:when test="${questao.tipoResposta == 'TEXTO'}">
							  					<td colspan="6"><textarea name="${questao.idQuestao}" class="form-control" rows="3" ></textarea></td>
							  				</c:when>						  			
							  			</c:choose>					  			
							  		<tr>	
						  		</c:if>
					  		</c:forEach>
					  	<!-- fim do loop Equipamentos -->
				  	</tbody>
				  	</c:if>
				</table>
			</div> 
			<hr>
		<span class="input-group-btn">
			<input type="submit" class="btn btn-default" type="button" value="Enviar Formulário">
		</span>
	
	</form>

<jsp:include page="../footer.jsp" />