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

/**
 * Servlet implementation class ControllerAgendamento
 */
@WebServlet("/ControllerAgendamento")
public class ControllerAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    AgendamentoAvaliacaoDAO agendamento;

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
					request.getRequestDispatcher("sistema/cadastroAgendamento.jsp").forward(request, response);
					break;
				case "editar":
					request.getRequestDispatcher("sistema/alterarAgendamento.jsp").forward(request, response);
					return;
				case "excluir":
					break;
				//case "excluirQuestao":
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		List<AgendamentoAvaliacao> agendamentos = agendamento.listar();
		request.setAttribute("agendamentos", agendamentos);
		request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
