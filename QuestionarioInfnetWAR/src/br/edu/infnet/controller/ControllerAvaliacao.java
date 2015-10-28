package br.edu.infnet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AvaliacaoDAO;
import br.edu.infnet.academicnet.dao.QuestaoDAO;
import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Avaliacao;
import br.edu.infnet.academicnet.modelo.Questao;

/**
 * Servlet implementation class ControllerAvaliacao
 */
@WebServlet("/ControllerAvaliacao")
public class ControllerAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AvaliacaoDAO avaliacao;
	
	@EJB
	QuestaoDAO questao;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAvaliacao() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		if(action != null)
		{
			switch(action)
			{
				case "telaCadastro":
					request.setAttribute("questoes", questao.listarAtivas());
					request.getRequestDispatcher("sistema/cadastroAvaliacao.jsp").forward(request, response);
					break;
				case "editar":
					request.setAttribute("avaliacao", avaliacao.obter(Long.valueOf(request.getParameter("id"))));					
					request.setAttribute("questoes", questao.listar());
					request.setAttribute("listaStatus", Status.values());
					request.getRequestDispatcher("sistema/alterarAvaliacao.jsp").forward(request, response);
					return;
				case "excluir":
					long id = Long.valueOf(request.getParameter("id"));
					request = checkReturn(avaliacao.excluir(id), action, request);
					break;
				case "excluirQuestao":
					long idAvaliacao = Long.valueOf(request.getParameter("id"));
					long idQuestao = Long.valueOf(request.getParameter("idQuestao"));
					
					avaliacao.excluirQuestao(idAvaliacao,idQuestao);
					request.setAttribute("avaliacao", avaliacao.obter(idAvaliacao));					
					request.setAttribute("questoes", questao.listar());
					request.setAttribute("listaStatus", Status.values());
					request.getRequestDispatcher("sistema/alterarAvaliacao.jsp").forward(request, response);
					return;
					//break;
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
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
		String action = request.getParameter("action");
		long id;
		String nome;
		Avaliacao a;
		String[] questoes = null;
		List<Questao> listaDeQuestao = new ArrayList<Questao>();
		if(action != null)
		{
			if(request.getParameterValues("questoes") != null){
				 questoes = request.getParameterValues("questoes");
			}
			
			switch(action)
			{
				case "cadastrar":
					nome = request.getParameter("nome");	
					System.out.println(nome);
					for (String ques : questoes) {	
						listaDeQuestao.add(questao.obter(Long.valueOf(ques)));
					}															
					a = new Avaliacao();
					a.setNome(nome);
					if(listaDeQuestao.size() >0){
						a.setListQuestao(listaDeQuestao);
					}
					a.setStatus(Status.ATIVO);
					request = checkReturn(avaliacao.incluir(a), action, request);
					break;
				case "alterar":
					id = Long.valueOf(request.getParameter("id"));
					nome = request.getParameter("nome");
					for (String ques : questoes) {	
						listaDeQuestao.add(questao.obter(Long.valueOf(ques)));
					}
					a = new Avaliacao();
					a.setIdAvaliacao(id);
					a.setNome(nome);
					if(listaDeQuestao.size() >0){
						a.setListQuestao(listaDeQuestao);
					}					
					a.setStatus(Status.valueOf(request.getParameter("status")));
					request = checkReturn(avaliacao.alterar(a), action, request);					
					break;
				case "consultar":
					request.setAttribute("avaliacoes", avaliacao.obterPorNome(request.getParameter("nome")));
					request.getRequestDispatcher("sistema/avaliacaoIndex.jsp").forward(request, response);
					return;
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		List<Avaliacao> avaliacoes = avaliacao.listar();
		request.setAttribute("avaliacoes", avaliacoes);
		request.getRequestDispatcher("sistema/avaliacaoIndex.jsp").forward(request, response);
	}

}
