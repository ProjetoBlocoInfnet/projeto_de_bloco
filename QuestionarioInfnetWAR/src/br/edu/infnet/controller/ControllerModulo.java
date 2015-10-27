package br.edu.infnet.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.ModuloDAO;

/**
 * Servlet implementation class ControllerModulo
 */
@WebServlet("/ControllerModulo")
public class ControllerModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ModuloDAO modulo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerModulo() {
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
					request.getRequestDispatcher("sistema/cadastroModulo.jsp").forward(request, response);
					break;
				case "editar":
					request.getRequestDispatcher("sistema/alterarModulo.jsp").forward(request, response);
					return;
				case "excluir":
					long id = Long.valueOf(request.getParameter("id"));
					request = checkReturn(modulo.excluir(id), action, request);
					break;
				//case "excluirQuestao":
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		request.setAttribute("modulos", modulo.listar());
		request.getRequestDispatcher("sistema/moduloIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
