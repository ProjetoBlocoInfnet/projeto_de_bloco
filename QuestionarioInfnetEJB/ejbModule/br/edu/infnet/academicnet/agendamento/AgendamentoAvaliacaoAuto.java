package br.edu.infnet.academicnet.agendamento;

import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAOImpl;
import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Aluno;

@Singleton
@Startup
public class AgendamentoAvaliacaoAuto
{
    @Resource(name = "java:jboss/mail/gmail")
    private Session session;

	//O agendamento executa a cada dia às 00hrs
	@Schedule(hour="0", minute="42")
	public void IniciarAvaliacao()
	{
		AgendamentoAvaliacaoDAOImpl dao = new AgendamentoAvaliacaoDAOImpl();
		
		java.sql.Date data = new java.sql.Date(0);
		data.setTime(data.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());
		List<AgendamentoAvaliacao> agendamentos = dao.obterPorStatusDataInicio(StatusAvaliacao.CRIADO, data);
		for(AgendamentoAvaliacao a : agendamentos)
		{
			for(Aluno al : a.getTurma().getAlunos())
			{
				//TODO Enviar emails para os alunos com os links das avaliações
				try {
					 
		            Message message = new MimeMessage(session);
		            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(al.getEmail()));
		            message.setSubject("Avaliação curso Infnet " + a.getModulo().getNomeModulo());
		            message.setText("Teste de envio de email");
		 
		            Transport.send(message);
		 
		        } catch (MessagingException e) {
		            System.out.println("Erro ao enviar o email");
		            e.printStackTrace();
		        }
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
		
		Date data = new Date(0);
		data.setTime(data.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());
		List<AgendamentoAvaliacao> agendamentos = dao.obterPorStatusDataFim(StatusAvaliacao.EM_ANDAMENTO, data);
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
