package br.edu.infnet.academicnet.agendamento;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.Asynchronous;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAOImpl;
import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Aluno;

@Singleton
@Startup
public class AgendamentoAvaliacaoAuto
{
    //Resource(name = "java:jboss/mail/Gmail")
    @Resource(mappedName = "java:jboss/mail/Gmail")
    private Session session;

    @Inject
    AgendamentoAvaliacaoDAO dao;
    
	//O agendamento executa a cada dia �s 00hrs
	@Schedule(hour="01", minute="30", persistent=true)
	public void IniciarAvaliacao()
	{
		//AgendamentoAvaliacaoDAOImpl dao = new AgendamentoAvaliacaoDAOImpl();
		
		java.sql.Date data = Date.valueOf(LocalDate.now());
		System.out.println("Ao chamarmos o metodo");
		System.out.println(data);
		List<AgendamentoAvaliacao> agendamentos = dao.obterPorStatusDataInicio(StatusAvaliacao.CRIADO, data);
		for(AgendamentoAvaliacao a : agendamentos)
		{
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
			System.out.println("idAgendamento = " + a.getIdAgendamento());
			for(Aluno al : a.getTurma().getAlunos())
			{
				//TODO Enviar emails para os alunos com os links das avalia��es
				try 
				{
					Message message = new MimeMessage(session);
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(al.getEmail()));
					message.setSubject("Avaliação curso Infnet " + a.getModulo().getNomeModulo());

					StringBuilder mensagem = new StringBuilder();
					mensagem.append("Olá Sr(a) ");
					mensagem.append(al.getNome());
					mensagem.append("\n");
					mensagem.append("Segue abaixo o link para responder o questionário de avaliação do módulo ");
					mensagem.append(a.getModulo().getNomeModulo());
					mensagem.append(".\n");
					mensagem.append(this.generateLink(a.getIdAgendamento(), al));
					mensagem.append("\n");
					mensagem.append("Desde já agradecemos pelo seu feedback");
					mensagem.append("\n");
					
					message.setText(mensagem.toString());
					Transport.send(message);
				}
				catch (MessagingException e)
				{
					System.out.println("Erro ao enviar o email");
					e.printStackTrace();
		        }
			}
		}
	}
	
	//O agendamento executa a cada dia �s 00hrs
	@Schedule(hour="0")
	public void FinalizarAvaliacao()
	{
		AgendamentoAvaliacaoDAOImpl dao = new AgendamentoAvaliacaoDAOImpl();
		
		java.sql.Date data = Date.valueOf(LocalDate.now());
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
	
	@Asynchronous
	public void sendEmails(AgendamentoAvaliacao a)
	{
		for(Aluno al : a.getTurma().getAlunos())
		{
			//TODO Enviar emails para os alunos com os links das avalia��es
			System.out.println("idAgendamento =" + a.getIdAgendamento());
			try 
			{
				Message message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress("waizmam.rj@gmail.com", "Infnet AcademicNet"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(al.getEmail()));
				message.setSubject("Avaliação curso Infnet " + a.getModulo().getNomeModulo());

				StringBuilder mensagem = new StringBuilder();
				mensagem.append("Olá Sr(a) ");
				mensagem.append(al.getNome());
				mensagem.append("\n");
				mensagem.append("Segue abaixo o link para responder o questionário de avaliação do módulo ");
				mensagem.append(a.getModulo().getNomeModulo());
				mensagem.append(".\n");
				mensagem.append(this.generateLink(a.getIdAgendamento(), al));
				mensagem.append("\n");
				mensagem.append("Desde já agradecemos pelo seu feedback");
				mensagem.append("\n");
				
				message.setText(mensagem.toString());
				Transport.send(message);
			}
			catch (MessagingException e)
			{
				System.out.println("Erro ao enviar o email");
				e.printStackTrace();
	        }
		}
		//return true;
	}
	
	private String generateLink(Long idAgendamento, Aluno aluno)
	{
		StringBuilder link = new StringBuilder();
		link.append("http://localhost:8080/QuestionarioInfnetWAR/ControllerFormularioAvaliacao?aluno=");
		link.append(aluno.getUsuario().getLogin());
		link.append("&key=");
		link.append(aluno.getUsuario().getSenha());
		link.append("&aval=");
		link.append(idAgendamento);
		System.out.println("idAgendamento =" + idAgendamento);
		System.out.println(link);
		return link.toString();
	}
	
	@javax.ejb.Timeout
	@AccessTimeout(value = 20, unit = TimeUnit.MINUTES)
	public void Timeout()
	{
		System.out.println("Tempo limite estourado!");
	}
	
	
	@Asynchronous
	public void sendEmailsResultadoAvaliacaoCSV(String caminhoArquivo)	{		
		
			try 
			{
				Message message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress("waizmam.rj@gmail.com", "Infnet AcademicNet"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				message.setRecipient(Message.RecipientType.TO, new InternetAddress("waizmam.rj@gmail.com"));				
				message.setSubject("Resultado em CSV da Avaliação");

				StringBuilder mensagem = new StringBuilder();
				mensagem.append("Olá Sr(a) Coordenador");				
				mensagem.append("\n");
				mensagem.append("Segue em anexo o CSV do Resultado da Avaliação: ");				
				mensagem.append(".\n");
				mensagem.append("AcademicNet");
				mensagem.append("\n");
				message.setText(mensagem.toString());
				
				MimeBodyPart mbp2 = new MimeBodyPart();      
				FileDataSource fds = new FileDataSource(caminhoArquivo);            
				mbp2.setDataHandler(new DataHandler(fds));            
				mbp2.setFileName(fds.getName());           
    
				Multipart mp = new MimeMultipart();            
				mp.addBodyPart(mbp2);            
                  
                message.setContent(mp);
				
				Transport.send(message);
			}
			catch (MessagingException e)
			{
				System.out.println("Erro ao enviar o email");
				e.printStackTrace();
	        }		
		
	}
	
	
}
