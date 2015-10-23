package br.edu.infnet.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Questao;

/**
 * Servlet implementation class ControllerFormularioAvaliacao
 */
@WebServlet("/ControllerFormularioAvaliacao")
public class ControllerFormularioAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	AgendamentoAvaliacaoDAO agendamento;
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
		// TODO carrega a tela da avalia��o
		String login = request.getParameter("aluno");
		String senha = request.getParameter("key");
		// TODO fazer consulta de valida��o de usu�rio aqui
		long idAgendamento = Long.valueOf(request.getParameter("aval"));
		AgendamentoAvaliacao minhaAvaliacao = agendamento.obterAtivo(idAgendamento);
		if(minhaAvaliacao != null)
		{
			request.setAttribute("questoes", minhaAvaliacao.getAvaliacao().getListQuestao());
			request.setAttribute("curso", minhaAvaliacao.getCurso());
			request.setAttribute("professor", minhaAvaliacao.getProfessor());
			Aluno meuAluno = null;
			for(Aluno a : minhaAvaliacao.getTurma().getAlunos())
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
		// TODO salva a avalia��o
		request.getRequestDispatcher("avaliacaoConcluida.jsp").forward(request, response);
	}

}
