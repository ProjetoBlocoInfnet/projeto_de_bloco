package br.edu.infnet.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.QuestaoDAOImpl;
import br.edu.infnet.academicnet.enumerators.TipoQuestao;
import br.edu.infnet.academicnet.modelo.Questao;

/**
 * Servlet implementation class ControllerQuestao 
 */
@WebServlet("/ControllerQuestao")
public class ControllerQuestao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private QuestaoDAOImpl questaoDAOImpl;
    private Questao questao = null;
    
	
    public ControllerQuestao() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action") != null){
			String action = request.getParameter("action");		
			
			switch (action) {
			case "telaCadastro":				
				request.setAttribute("tipo", TipoQuestao.values());
				request.getRequestDispatcher("sistema/cadastroQuestao.jsp").forward(request, response);
				break;
			
			case "telaAlterar":
				request.getRequestDispatcher("sistema/alterarQuestao.jsp").forward(request, response);
				break;

			default:
				break;
			}
		}else{
			request.getRequestDispatcher("sistema/questoesIndex.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action") != null){
			
			String action = request.getParameter("action");	
			switch (action) {
				case "cadastrar":
					
					break;
				case "alterar":
					
					break;
				case "consultar":
					
					break;
				default:
					break;
			}
		}
		
		doGet(request, response);
		
	
	}

}
