<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário de Avaliação</title>
</head>
<body>
	<form action="ControllerFormularioAvaliacao" method="post">
		Nome: "${requestScope.aluno.nome}" <br/>
		Curso: "${requestScope.curso.nome}" Professor: "${requestScope.professor.nome}" <br/>
		<div >
			<input type="hidden" name="idAgendamento" value="${requestScope.idAgendamento}"/>
			<input type="hidden" name="idAluno" value="${requestScope.aluno.usuario}"/>
			<table class="table table-hover">
		  		<thead>
			  		<th>Questão</th>
			  		<th>Concordo totalmente</th>
			  		<th>Concordo</th>
			  		<th>Não concordo nem discordo</th>
			  		<th>Discordo</th>
			  		<th>Discordo totalmente</th>
			  		<th>Não sabe opinar</th>
		  		</thead>
		  		<tbody>
			  		<c:if test="${requestScope.questoes != null && requestScope.questoes.size() > 0 }">
			  		<!-- inicio do loop Curso -->
			  		<tr>
			  			<td>Avaliação geral da Pós-Graduação</td>
			  		</tr>
			  			<c:forEach items="${requestScope.questoes}" var="questao">
			  				<c:if test="${questao.categoria.getCategoria() == 'Curso'}">
						  		<tr>
						  			<td>${questao.textoQuestao}</td>
						  			<c:if test="${questao.tipoResposta == 'LIKERT'}">
						  				<td><input type="radio" name="${questao.idQuestao}" value=5 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=4 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=3 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=2 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=1 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=0 /></td>
						  			</c:if>
						  		</tr>
						  		<c:if test="${questao.tipoResposta == TEXTO}">
						  			<tr>
						  				<td><input type="text" name="${questao.idQuestao}"/></td>
						  			</tr>
						  		</c:if>
					  		</c:if>
				  		</c:forEach>
				  	<!-- fim do loop Curso -->
			  		<!-- inicio do loop Professor -->
			  		<tr>
			  			<td>Avaliação do professor do módulo</td>
			  		</tr>
			  			<c:forEach items="${requestScope.questoes}" var="questao">
			  				<c:if test="${questao.categoria.getCategoria() == 'Professor'}">
						  		<tr>
						  			<td>${questao.textoQuestao}</td>
						  			<c:if test="${questao.tipoResposta == 'LIKERT'}">
						  				<td><input type="radio" name="${questao.idQuestao}" value=5 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=4 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=3 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=2 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=1 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=0 /></td>
						  			</c:if>
						  		</tr>
						  		<c:if test="${questao.tipoResposta == TEXTO}">
						  			<tr>
						  				<td><input type="text" name="${questao.idQuestao}"/></td>
						  			</tr>
						  		</c:if>
					  		</c:if>
				  		</c:forEach>
				  	<!-- fim do loop Professor -->
			  		<!-- inicio do loop Equipamentos -->
			  		<tr>
			  			<td>Avaliação de Conteúdo e infra-estrutura no módulo</td>
			  		</tr>
			  			<c:forEach items="${requestScope.questoes}" var="questao">
			  				<c:if test="${questao.categoria.getCategoria() == 'Conteúdo e Infra-Estrutura do módulo'}">
						  		<tr>
						  			<td>${questao.textoQuestao}</td>
						  			<c:if test="${questao.tipoResposta == 'LIKERT'}">
						  				<td><input type="radio" name="${questao.idQuestao}" value=5 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=4 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=3 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=2 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=1 /></td>
						  				<td><input type="radio" name="${questao.idQuestao}" value=0 /></td>
						  			</c:if>
						  		</tr>
						  		<c:if test="${questao.tipoResposta == TEXTO}">
						  			<tr>
						  				<td><input type="text" name="${questao.idQuestao}"/></td>
						  			</tr>
						  		</c:if>
					  		</c:if>
				  		</c:forEach>
				  	<!-- fim do loop Equipamentos -->
				  	</c:if>
			  	</tbody>
			</table>
		</div>
		<span class="input-group-btn">
			<input type="submit" class="btn btn-default" type="button" value="Submeter">
		</span>
	
	</form>

</body>
</html>