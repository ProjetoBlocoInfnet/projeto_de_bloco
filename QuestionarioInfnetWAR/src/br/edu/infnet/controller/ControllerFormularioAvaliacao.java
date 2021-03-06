package br.edu.infnet.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.agendamento.AgendamentoAvaliacaoAuto;
import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.ResultadoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Questao;
import br.edu.infnet.academicnet.modelo.ResultadoAvaliacao;

/**
 * Servlet implementation class ControllerFormularioAvaliacao
 */
@WebServlet("/ControllerFormularioAvaliacao")
public class ControllerFormularioAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	AgendamentoAvaliacaoDAO agendamento;
	
	@EJB
	ResultadoAvaliacaoDAO resultado;
	
	@EJB
	TurmaDAO turma;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerFormularioAvaliacao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO carrega a tela da avaliação
		String login = request.getParameter("aluno");
		String senha = request.getParameter("key");
		// TODO fazer consulta de validção de usuário aqui
		long idAgendamento = Long.valueOf(request.getParameter("aval"));
		
		/*TODO
		 * So para efeitos de teste isso esta aqui!!!!
		 * */

		AgendamentoAvaliacao minhaAvaliacao = agendamento.obter(idAgendamento);
		
		/*TODO
		 * So para efeitos de teste isso esta aqui!!!!
		 * */
		//TODO Esse é o correto que está comentado. Está assim por causa dos testes. Depois tem que ser descomentado e o bloco de cima apagado
		//AgendamentoAvaliacao minhaAvaliacao = agendamento.obterAtivo(idAgendamento);
		if(minhaAvaliacao != null)
		{
			request.setAttribute("idAgendamento", idAgendamento);
			request.setAttribute("questoes", minhaAvaliacao.getAvaliacao().getListQuestao());
			request.setAttribute("curso", minhaAvaliacao.getCurso());
			request.setAttribute("professor", minhaAvaliacao.getProfessor());
			request.setAttribute("modulo", minhaAvaliacao.getModulo());
			Aluno meuAluno = null;
			for(Aluno a : turma.obter(minhaAvaliacao.getTurma().getIdTurma()).getAlunos())
			{
				if(login.equals(a.getUsuario().getLogin()) && senha.equals(a.getUsuario().getSenha()))
				{
					meuAluno = a;
					break;
				}
			}
			if(meuAluno != null && !resultado.seAlunoRespondeuAvaliacao(idAgendamento, meuAluno.getMatricula()))
			{
				request.setAttribute("aluno", meuAluno);
				request.getRequestDispatcher("sistema/formularioAvaliacao.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("erroAvaliacao.jsp").forward(request, response);
			}
		}
		else
		{
			request.getRequestDispatcher("erroAvaliacao.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultadoAvaliacao r = new ResultadoAvaliacao();
		AgendamentoAvaliacao a = agendamento.obter(Long.valueOf(request.getParameter("idAgendamento")));
		r.setAgendamentoAvaliacao(a);
		r.setTurma(a.getTurma());
		//TODO essa parte aqui pode mudar dependendo de como fizermos a parte de login
		Aluno meuAluno = null;
		String login = request.getParameter("idAluno");
		for(Aluno al : turma.obter(r.getTurma().getIdTurma()).getAlunos())
		{
			if(login.equals(al.getUsuario().getLogin()))
			{
				meuAluno = al;
				break;
			}
		}
		r.setAluno(meuAluno);
		//TODO essa parte aqui pode mudar dependendo de como fizermos a parte de login
		
		//Recupera as questões da tela e faz a mídia internamente no método setRespostas
		//Map<Questao,String> minhasRespostas = new HashMap<Questao,String>();
		System.out.println("for das questoes");
		//for(Map.Entry<Questao, String> resposta : r.getRespostas().entrySet())
		System.out.println("Questao " + a.getAvaliacao().getListQuestao().get(0).getIdQuestao());
		for(Questao questao : a.getAvaliacao().getListQuestao())
		{
			//System.out.println("Retorno da tela da questao " + questao.getIdQuestao() + " " + request.getParameter(String.valueOf(questao.getIdQuestao())) + " Tipo Questao " + questao.getTipoResposta());
			//System.out.println(questao + " = " + request.getParameter(request.getParameter(String.valueOf(resposta.getKey().getIdQuestao()))));
			try
			{
				//minhasRespostas.put(questao, request.getParameter(request.getParameter(String.valueOf(questao.getIdQuestao()))));
				r.getRespostas().put(questao, request.getParameter(String.valueOf(questao.getIdQuestao())));
			}
			catch(Exception e)
			{
				request.getRequestDispatcher("erroAvaliacaoIncompleta.jsp").forward(request, response);
				return;
			}
		}
		r.calculaMedia();
		//r.setRespostas(minhasRespostas);

		if(resultado.incluir(r))
		{
			//TODO testar essa parte com mais calma. Ela gera a avaliação em arquivo CSV
			//windows
			//FileWriter writer = new FileWriter("c:\\resultadoAvaliacao_" + r.getAgendamentoAvaliacao().getIdAgendamento() + "_Aluno_" + r.getAluno().getMatricula() + "_" + LocalDate.now().toString() + ".csv");
			//linux
			String caminhoArquivoLinux = "/home/waizmam/Documentos/projetos_git/projeto_de_bloco/CSV/resultadoAvaliacao_" + r.getAgendamentoAvaliacao().getIdAgendamento() + "_Aluno_" + r.getAluno().getMatricula() + "_" + LocalDate.now().toString() + ".csv";
			FileWriter writer = new FileWriter(caminhoArquivoLinux);
			r.getRespostas();
		    writer.append("Questao");
		    writer.append(',');
		    writer.append("TipoResposta");
		    writer.append(',');
		    writer.append("Resposta");
		    writer.append('\n');
			
			for(Map.Entry<Questao, String> resposta : r.getRespostas().entrySet())
			{
			    writer.append(resposta.getKey().getTextoQuestao());
			    writer.append(',');
			    writer.append(resposta.getKey().getTipoResposta().name());
			    writer.append(',');
			    writer.append(resposta.getValue());
			    writer.append('\n');
			}	
		    writer.flush();
		    writer.close();
		    r.enviarCSVPorEmail(caminhoArquivoLinux);
		    request.getRequestDispatcher("avaliacaoConcluida.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("erroAvaliacao.jsp").forward(request, response);
		}
	}

}
