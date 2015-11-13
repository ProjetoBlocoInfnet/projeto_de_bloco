package br.edu.infnet.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.ModuloDAO;
import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Modulo;

/**
 * Servlet implementation class ControllerModulo
 */
@WebServlet("/ControllerModulo")
public class ControllerModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ModuloDAO modulo;
	
	@EJB
	PessoaDAO professor;
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
			request.setAttribute("result_error", "Erro ao " + action + " o módulo!");
		}
		return request;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		if(action != null)
		{
			switch(action)
			{
				case "telaCadastro":
					request.setAttribute("professores", professor.obterProfessores());
					request.getRequestDispatcher("sistema/cadastroModulo.jsp").forward(request, response);
					break;
				case "editar":
					request.setAttribute("professores", professor.obterProfessores());
					request.setAttribute("modulo", modulo.obter(Long.valueOf(request.getParameter("id"))));
					request.getRequestDispatcher("sistema/alterarModulo.jsp").forward(request, response);
					return;
				case "excluir":
					long id = Long.valueOf(request.getParameter("id"));
					request = checkReturn(modulo.excluir(id), action, request);
					break;
				case "excluirProfessor":
					break;
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		request.setAttribute("modulos", modulo.listarAtivos());
		request.getRequestDispatcher("sistema/moduloIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		Modulo m = null;
		if(action != null)
		{
			switch(action)
			{
				case "cadastrar":
					m = new Modulo();
					m.setNomeModulo(request.getParameter("nome"));
					m.setProfessor(professor.obterProfessor(Long.valueOf(request.getParameter("professores"))));
					request = checkReturn(modulo.incluir(m), action, request);
					break;
				case "alterar":
					m = modulo.obter(Long.valueOf(request.getParameter("id")));
					m.setNomeModulo(request.getParameter("nome"));
					m.setProfessor(professor.obterProfessor(Long.valueOf(request.getParameter("professores"))));
					request = checkReturn(modulo.alterar(m), action, request);
					break;
				case "consultar":
					request.setAttribute("modulos", modulo.obterPorNome(request.getParameter("nome")));
					request.getRequestDispatcher("sistema/moduloIndex.jsp").forward(request, response);
					return;
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		request.setAttribute("modulos", modulo.listarAtivos());
		request.getRequestDispatcher("sistema/moduloIndex.jsp").forward(request, response);
	}

}
