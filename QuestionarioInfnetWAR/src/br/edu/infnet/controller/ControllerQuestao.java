package br.edu.infnet.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.QuestaoDAO;
import br.edu.infnet.academicnet.enumerators.Categoria;
import br.edu.infnet.academicnet.enumerators.TipoResposta;
import br.edu.infnet.academicnet.modelo.Questao;

/**
 * Servlet implementation class ControllerQuestao 
 */
@WebServlet("/ControllerQuestao")
public class ControllerQuestao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private QuestaoDAO questaoDAO;
	
    public ControllerQuestao() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Questao> listaQuestao = null;
		
		if(request.getParameter("tela") != null){
			String tela = request.getParameter("tela");	
			
			long idQuestao =0;
			
			if(request.getParameter("idQuestao") != null){
				idQuestao = Long.valueOf(request.getParameter("idQuestao"));
			}
						
			switch (tela) {
			case "telaCadastro":				
				request.setAttribute("categorias", Categoria.values());
				request.setAttribute("tipoResposta", TipoResposta.values());
				request.getRequestDispatcher("sistema/cadastroQuestao.jsp").forward(request, response);
				return;
				//break;
			
			case "telaAlterar":
				
				Questao questao = questaoDAO.obter(idQuestao);
				request.setAttribute("questao", questao);
				request.setAttribute("categorias", Categoria.values());
				request.setAttribute("tipoResposta", TipoResposta.values());
				request.getRequestDispatcher("sistema/alterarQuestao.jsp").forward(request, response);
				return;
				//break;
			
			case "excluir":
				
				boolean result = questaoDAO.excluir(idQuestao);
				System.out.println(result);
				if(result){
					request.setAttribute("result_ok", "Questão excluída com Sucesso!");
				}else{
					request.setAttribute("result_error", "Erro ao excluir a questão!");
				}	
				
				listaQuestao = questaoDAO.listar();
				request.setAttribute("listaQuestao", listaQuestao);
				break;
				
			default:
				break;
			}
									
		}else{
			 listaQuestao = questaoDAO.listar();			
		}
		request.setAttribute("listaQuestao", listaQuestao);
		request.getRequestDispatcher("sistema/questoesIndex.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null){
			
			Questao questaoObj ;
			boolean result;
			
			
			String questao = request.getParameter("questao");
			String categoria = request.getParameter("categoria");
			String tipoResposta = request.getParameter("tipoResposta");	
			 
			String action = request.getParameter("action");	
			switch (action) {
				case "cadastrar":
					questaoObj = new Questao();
					questaoObj.setTextoQuestao(questao);
					questaoObj.setCategoria(Categoria.valueOf(categoria));
					questaoObj.setTipoResposta(TipoResposta.valueOf(tipoResposta));
					
					result = questaoDAO.incluir(questaoObj);
					if(result){
						request.setAttribute("result_ok", "Questão Cadastrada com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao cadastrar a questão!");
					}					
					
					break;
				case "alterar":
					questaoObj = new Questao();
					questaoObj.setIdQuestao(Long.valueOf(request.getParameter("idQuestao")));
					questaoObj.setTextoQuestao(questao);
					questaoObj.setCategoria(Categoria.valueOf(categoria));
					questaoObj.setTipoResposta(TipoResposta.valueOf(tipoResposta));
					
					result = questaoDAO.alterar(questaoObj);
					if(result){
						request.setAttribute("result_ok", "Questão alterada com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao alterar a questão!");
					}	
					
					break;
				case "consultar":
					List<Questao> listaQuestao = questaoDAO.consultarPorTextoDaQuestao(request.getParameter("textoQuestao"));
					for (Questao questao2 : listaQuestao) {
						System.out.println(questao2.getTextoQuestao());
						System.out.println();
					}
					request.setAttribute("listaQuestao", listaQuestao);
					request.getRequestDispatcher("sistema/questoesIndex.jsp").forward(request, response);					
					return;
					//break;
				default:
					break;
			}
			
		}
		doGet(request,response);
	}

}
