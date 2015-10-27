package br.edu.infnet.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;

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
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAgendamento() {
        super();
    }

    //Funções auxiliares
    private HttpServletRequest checkReturn(boolean status, String action, HttpServletRequest request)
    {
		if(status){
			request.setAttribute("result_ok", "Ação efetuada com Sucesso!");
		}else{
			request.setAttribute("result_error", "Erro ao " + action + " a avaliação!");
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
					request.setAttribute("turmas", turma.listar());
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
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		request.setAttribute("agendamentos", agendamento.listar());
		request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
