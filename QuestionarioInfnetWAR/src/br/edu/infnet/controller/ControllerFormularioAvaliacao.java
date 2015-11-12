package br.edu.infnet.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.ResultadoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.enumerators.Categoria;
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
		// TODO fazer consulta de validação de usuário aqui
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
				if(login.equals(a.getUsuario()))
				{
					meuAluno = a;
					break;
				}
			}
			request.setAttribute("aluno", meuAluno);
			request.getRequestDispatcher("sistema/formularioAvaliacao.jsp").forward(request, response);
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
		for(Aluno al : r.getTurma().getAlunos())
		{
			if(login.equals(al.getUsuario()))
			{
				meuAluno = al;
				break;
			}
		}
		r.setAluno(meuAluno);
		//TODO essa parte aqui pode mudar dependendo de como fizermos a parte de login
		
		//Recupera as questões da tela e faz a média internamente no método setRespostas
		Map<Questao,String> minhasRespostas = new HashMap<Questao,String>();
		for(Map.Entry<Questao, String> resposta : r.getRespostas().entrySet())
		{
			minhasRespostas.put(resposta.getKey(), request.getParameter(request.getParameter(String.valueOf(resposta.getKey().getIdQuestao()))));
		}
		r.setRespostas(minhasRespostas);

		if(resultado.incluir(r))
		{
			request.getRequestDispatcher("avaliacaoConcluida.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("erroAvaliacao.jsp").forward(request, response);
		}
	}

}
