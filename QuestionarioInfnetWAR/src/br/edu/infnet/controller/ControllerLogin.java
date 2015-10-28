package br.edu.infnet.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.modelo.Pessoa;

/**
 * Servlet implementation class ControllerLogin
 */
@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private HttpSession session = null;
	
	@EJB
	private PessoaDAO pessoaDAO;
    
    public ControllerLogin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		
		Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
		
		if(pessoa == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			session.setAttribute("pessoa", pessoa);			
			request.getRequestDispatcher("sistema/index.jsp").forward(request, response);
		}	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		if(login != null & senha != null) {
			session = request.getSession();		
			Pessoa pessoa =  pessoaDAO.login(login, senha);
			
			
			if (pessoa == null){			
				request.setAttribute("resultado", "Usuário inexistente");
				doGet(request, response);
				return;
			}
			else{				
				session.setAttribute("pessoa", pessoa);			
				request.getRequestDispatcher("sistema/index.jsp").forward(request, response);
				return;
			}
		}else{
			doGet(request, response);
		}
		
	}

}
