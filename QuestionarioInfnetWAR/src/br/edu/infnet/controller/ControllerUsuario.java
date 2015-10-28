package br.edu.infnet.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.PerfilDAO;
import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Administrador;
import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Perfil;
import br.edu.infnet.academicnet.modelo.Pessoa;
import br.edu.infnet.academicnet.modelo.Usuario;

/**
 * Servlet implementation class ControllerUsuario
 */
@WebServlet("/ControllerUsuario")
public class ControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private PerfilDAO perfilDao;
    @EJB
    private PessoaDAO pessoaDAO;
    
	
    public ControllerUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Pessoa> listaPessoa = null;
		
		if(request.getParameter("tela") != null){
			String tela = request.getParameter("tela");	
			
			long matricula =0;
			
			if(request.getParameter("matricula") != null){
				matricula = Long.valueOf(request.getParameter("matricula"));
			}
						
			switch (tela) {
			case "telaCadastro":				
				request.setAttribute("listaPerfil", perfilDao.listar());
				request.getRequestDispatcher("sistema/cadastroUsuario.jsp").forward(request, response);
				return;
				//break;
			
			case "telaAlterar":
				
				Pessoa pessoa = pessoaDAO.obter(matricula);
				request.setAttribute("pessoa", pessoa);
				request.setAttribute("listaPerfil", perfilDao.listar());
				request.getRequestDispatcher("sistema/alterarUsuario.jsp").forward(request, response);
				return;
				//break;
			
			case "excluir":
				
				boolean result = pessoaDAO.excluir(matricula);
				if(result){
					request.setAttribute("result_ok", "Exclusão efetuada com Sucesso!");
				}else{
					request.setAttribute("result_error", "Erro ao excluir!");
				}	
				
				listaPessoa = pessoaDAO.listarAtivas();
				request.setAttribute("listaPessoa", listaPessoa);
				break;
				
			default:
				break;
			}
									
		}else{
			 listaPessoa = pessoaDAO.listarAtivas();			
		}
				
		request.setAttribute("listaPessoa", listaPessoa);
		request.getRequestDispatcher("sistema/usuarioIndex.jsp").forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("action") != null){
			
			
			boolean result = false;
			
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String cep = request.getParameter("cep");	
			String email = request.getParameter("email");	
			String endereco = request.getParameter("endereco");	
			String idPerfil = request.getParameter("perfil");	
			Perfil perfil = null;
			
			if(idPerfil != null){
				perfil = perfilDao.obter(Long.valueOf(idPerfil));
			}
					
			 
			String action = request.getParameter("action");	
			switch (action) {
				case "cadastrar":
					
					if(perfil.getNomePerfil().equals("Aluno")){
						Pessoa aluno  = new Aluno();
						aluno.setNome(nome);
						aluno.setEmail(email);
						aluno.setCep(cep);
						aluno.setEndereco(endereco);
						aluno.setStatus(Status.ATIVO);
						aluno.setUsuario(new Usuario(login,senha,perfil,aluno));						
						result = pessoaDAO.incluir(aluno);
					}else if(perfil.getNomePerfil().equals("Administrador")){
						Pessoa admin  = new Administrador();
						admin.setNome(nome);
						admin.setEmail(email);
						admin.setCep(cep);
						admin.setEndereco(endereco);
						admin.setStatus(Status.ATIVO);
						admin.setUsuario(new Usuario(login,senha,perfil,admin));	
						result = pessoaDAO.incluir(admin);
					}
										
					if(result){
						request.setAttribute("result_ok", "Usuário Cadastrado com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao cadastrar o usuário!");
					}					
					
					break;
				case "alterar":
					
					Pessoa p = pessoaDAO.obter(Long.valueOf(request.getParameter("matricula")));
					
					if(perfil.getNomePerfil().equals("Aluno")){
						Pessoa aluno  = new Aluno();
						aluno.setMatricula(Long.valueOf(request.getParameter("matricula")));
						aluno.setNome(nome);
						aluno.setEmail(email);
						aluno.setCep(cep);
						aluno.setEndereco(endereco);
						aluno.setStatus(Status.ATIVO);
						aluno.setUsuario(new Usuario(login,senha,perfil,aluno));				
						result = pessoaDAO.alterar(aluno);
					}
					else if(perfil.getNomePerfil().equals("Administrador")){
						Pessoa admin  = new Administrador();
						admin.setMatricula(Long.valueOf(request.getParameter("matricula")));
						admin.setNome(nome);
						admin.setEmail(email);
						admin.setCep(cep);
						admin.setEndereco(endereco);
						admin.setStatus(Status.ATIVO);
						admin.setUsuario(new Usuario(login,senha,perfil,admin));
						result = pessoaDAO.alterar(admin);
					}
					
					if(result){
						request.setAttribute("result_ok", "Usuário alterada com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao alterar a usuário!");
					}	
					
					break;
				case "consultar":					
					
					List<Pessoa> listPessoa = pessoaDAO.consultarPorNomeDaPessoa(request.getParameter("nome"));
					
					if(listPessoa.size() > 0){
						request.setAttribute("result_ok", "(" + listPessoa.size() + ") - Usuário(s) encontrados!");
					}else{
						request.setAttribute("result_error", "Nenhum Usuário encontrado!");
					}	
					
					request.setAttribute("listaPessoa", listPessoa);
					request.getRequestDispatcher("sistema/usuarioIndex.jsp").forward(request, response);					
					return;
					//break;
				default:
					break;
			}
			
		}
		doGet(request,response);
	}

}
