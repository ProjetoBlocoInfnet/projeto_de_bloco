package br.edu.infnet.academicnet.agendamento;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.edu.infnet.academicnet.dao.AvaliacaoDAOImpl;
import br.edu.infnet.academicnet.modelo.Avaliacao;

@Singleton
@Startup
public class AgendamentoAvaliacao
{
	//O agendamento executa a cada dia �s 00hrs
	@Schedule(hour="0")
	public void IniciarAvaliacao()
	{
		//Listar as avalia��es pendentes
		LocalDate hoje = LocalDate.now();
		List<Avaliacao> avaliacoes = new AvaliacaoDAOImpl().obterAvaliacoesPendentes(hoje);
		if(avaliacoes.size() > 0)
		{
			//Caso existam, iniciar as avalia��es e enviar emails aos alunos
			//TODO Quando forem criados os DAOs de turma, quest�o e aluno, voltar aqui e finalizar
		}
	}
	
	//O agendamento executa a cada dia �s 00hrs
	@Schedule(hour="0")
	public void FinalizarAvaliacao()
	{
		//Listar as avalia��es ativas
		LocalDate hoje = LocalDate.now();
		List<Avaliacao> avaliacoes = new AvaliacaoDAOImpl().obterAvaliacoesEmDataEncerramento(hoje);
		if(avaliacoes.size() > 0)
		{	
			//Caso existam, finalizar as avalia��es e invalidar os links enviados aos alunos
			//TODO Quando forem criados os DAOs de turma, quest�o e aluno, voltar aqui e finalizar
		}
	}
}
