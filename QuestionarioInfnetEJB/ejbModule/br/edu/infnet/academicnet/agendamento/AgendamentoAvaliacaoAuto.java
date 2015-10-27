package br.edu.infnet.academicnet.agendamento;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAOImpl;
import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Aluno;

@Singleton
@Startup
public class AgendamentoAvaliacaoAuto
{
	//O agendamento executa a cada dia às 00hrs
	@Schedule(hour="0")
	public void IniciarAvaliacao()
	{
		AgendamentoAvaliacaoDAOImpl dao = new AgendamentoAvaliacaoDAOImpl();
		
		List<AgendamentoAvaliacao> agendamentos = dao.obterPorStatusDataInicio(StatusAvaliacao.CRIADO, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		for(AgendamentoAvaliacao a : agendamentos)
		{
			for(Aluno al : a.getTurma().getAlunos())
			{
				//TODO Enviar emails para os alunos com os links das avaliações
				al.getEmail();
			}
			try
			{
				a.setStatus(StatusAvaliacao.EM_ANDAMENTO);
				dao.alterar(a);
			}
			catch(Exception e)
			{
				System.out.println("Erro ao iniciar o agendamento de ID " + a.getIdAgendamento());
				e.printStackTrace();
			}
		}
	}
	
	//O agendamento executa a cada dia às 00hrs
	@Schedule(hour="0")
	public void FinalizarAvaliacao()
	{
		AgendamentoAvaliacaoDAOImpl dao = new AgendamentoAvaliacaoDAOImpl();
		
		List<AgendamentoAvaliacao> agendamentos = dao.obterPorStatusDataFim(StatusAvaliacao.EM_ANDAMENTO, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		for(AgendamentoAvaliacao a : agendamentos)
		{
			try
			{
				a.setStatus(StatusAvaliacao.FINALIZADO);
				dao.alterar(a);
			}
			catch(Exception e)
			{
				System.out.println("Erro ao finalizar o agendamento de ID " + a.getIdAgendamento());
				e.printStackTrace();
			}
		}
	}
}
