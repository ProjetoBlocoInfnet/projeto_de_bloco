package br.edu.infnet.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.infnet.academicnet.modelo.Pessoa;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter(filterName = "/FilterLogin", urlPatterns="/paginas/*",
		   servletNames = {"ControllerAvaliacao","ControllerFormularioAvaliacao","ControllerMediaHistorica","ControllerQuestao","ControllerUsuario","ControllerTurma","ControllerUsuario"}
           )
public class FilterLogin implements Filter {

	private FilterConfig context = null; 
	
    public FilterLogin() {
    	
    }
	
	public void destroy() {
		this.context = null;
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;	
		String resource = req.getRequestURI().replaceAll(req.getContextPath(), "");
	    Pessoa pessoa = getPessoa(req);    
	    if(pessoa != null){
	    	chain.doFilter(request, response);
	    }else{
	    	request.getRequestDispatcher("/login.jsp").forward(request, response);
	    }		
		
	}

	
	public void init(FilterConfig config) throws ServletException {
		this.context = config; 
        System.out.println("Filtro de Autenticação inicializado");
	}
	
	
	private Pessoa getPessoa(HttpServletRequest req) {
		
		 HttpSession session = req.getSession();		 
	     Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");	     
       if (pessoa == null)
           return null;
       else{
       	return pessoa;
       }
            
   }
	

}
