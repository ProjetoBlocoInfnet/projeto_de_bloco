package br.edu.infnet.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AvaliacaoDAO;
import br.edu.infnet.academicnet.modelo.Avaliacao;

/**
 * Servlet implementation class ControllerAvaliacao
 */
@WebServlet("/ControllerAvaliacao")
public class ControllerAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AvaliacaoDAO avaliacao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAvaliacao() {
        super();
        // TODO Auto-generated constructor stub
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
					request.getRequestDispatcher("sistema/cadastroAvaliacao.jsp").forward(request, response);
					break;
				case "consultar":
					String nome = request.getParameter("nome");
					List<Avaliacao> avaliacoes = avaliacao.obterPorNome(nome);
					request.setAttribute("avaliacoes", avaliacoes);
					request.getRequestDispatcher("sistema/avaliacaoIndex.jsp").forward(request, response);
					break;
				case "editar":
					request.getRequestDispatcher("sistema/alterarAvaliacao.jsp").forward(request, response);
					break;
				case "excluir":
					long id = Long.valueOf(request.getParameter("id"));
					avaliacao.excluir(id);
					break;
				default:
					System.out.println("Não houve ação válida inserida");
			}
		}
		List<Avaliacao> avaliacoes = avaliacao.listar();
		request.setAttribute("avaliacoes", avaliacoes);
		request.getRequestDispatcher("sistema/avaliacaoIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("sistema/cadastroAvaliacao.jsp").forward(request, response);
	}

}
