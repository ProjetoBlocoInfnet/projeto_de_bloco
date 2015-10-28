package br.edu.infnet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.AvaliacaoDAO;
import br.edu.infnet.academicnet.dao.CursoDAO;
import br.edu.infnet.academicnet.dao.ModuloDAO;
import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;

/**
 * Servlet implementation class ControllerAgendamento
 */
@WebServlet("/ControllerAgendamento")
public class ControllerAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    AgendamentoAvaliacaoDAO agendamento;

    @EJB
    TurmaDAO turma;
    
    @EJB
    ModuloDAO modulo;
    
    @EJB
    CursoDAO curso;
    
    @EJB
    PessoaDAO professor;
    
    @EJB
    AvaliacaoDAO avaliacao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAgendamento() {
        super();
    }

    //Fun��es auxiliares
    private HttpServletRequest checkReturn(boolean status, String action, HttpServletRequest request)
    {
		if(status){
			request.setAttribute("result_ok", "A��o efetuada com Sucesso!");
		}else{
			request.setAttribute("result_error", "Erro ao " + action + " a avalia��o!");
		}
		return request;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null)
		{
			switch(action)
			{
				case "telaCadastro":
					request.setAttribute("avaliacoes", avaliacao.listar());
					request.setAttribute("turmas", turma.listar());
					request.setAttribute("professores", professor.listar());
					request.setAttribute("modulos", modulo.listar());
					request.setAttribute("cursos", curso.listar());
					request.getRequestDispatcher("sistema/cadastroAgendamento.jsp").forward(request, response);
					break;
				case "editar":
					request.getRequestDispatcher("sistema/alterarAgendamento.jsp").forward(request, response);
					return;
				case "excluir":
					long id = Long.valueOf(request.getParameter("id"));
					request = checkReturn(agendamento.excluir(id), action, request);
					break;
				//case "excluirQuestao":
				default:
					request.setAttribute("result_error", "N�o houve a��o v�lida inserida");
			}
		}
		request.setAttribute("agendamentos", agendamento.listar());
		request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		if(action != null)
		{
			switch(action)
			{
				case "cadastrar":
					break;
				case "alterar":
					break;
				case "consultar":
					String tipoConsulta = request.getParameter("tipoConsulta");
					switch(tipoConsulta)
					{
						case "agendamento":
							request.setAttribute("agendamentos", new ArrayList<AgendamentoAvaliacao>().add(agendamento.obter(Long.valueOf(request.getParameter("valor")))));
						case "avaliacao":
						case "dataInicio":
						case "dataFim":
						case "turma":
						case "curso":
						case "modulo":
						case "professor":
						default:
							request.setAttribute("agendamentos", agendamento.listar());
					}
					request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
					return;
				default:
					request.setAttribute("result_error", "N�o houve a��o v�lida inserida");
			}
		}
		request.setAttribute("agendamentos", agendamento.listar());
		request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
	}

}
