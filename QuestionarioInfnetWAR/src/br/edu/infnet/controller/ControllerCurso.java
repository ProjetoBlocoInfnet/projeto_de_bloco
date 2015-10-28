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

import br.edu.infnet.academicnet.dao.CursoDAO;
import br.edu.infnet.academicnet.dao.ModuloDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.modelo.Curso;
import br.edu.infnet.academicnet.modelo.Modulo;
import br.edu.infnet.academicnet.modelo.Turma;


@WebServlet("/ControllerCurso")
public class ControllerCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private CursoDAO cursoDAO;
    
    @EJB
    private ModuloDAO moduloDAO;
    
    @EJB
    private TurmaDAO turmaDAO; 
    
    
	
    public ControllerCurso() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Curso> listaCurso = null;
		
		if(request.getParameter("tela") != null){
			String tela = request.getParameter("tela");	
			
			long idCurso =0;
			
			if(request.getParameter("idCurso") != null){
				idCurso = Long.valueOf(request.getParameter("idCurso"));
			}
						
			switch (tela) {
			case "telaCadastro":				
				request.setAttribute("listaAlunos", moduloDAO.listarAtivos());
				request.setAttribute("listaCurso", turmaDAO.listar());
				request.setAttribute("listaStatus", Status.values());
				request.getRequestDispatcher("sistema/cadastroCurso.jsp").forward(request, response);
				return;
				//break;
			
			case "telaAlterar":
				
				Curso curso = cursoDAO.obter(idCurso);
				request.setAttribute("curso", curso);
				request.setAttribute("listaAlunos", moduloDAO.listarAtivos());
				request.setAttribute("listaCurso", turmaDAO.listar());
				request.setAttribute("listaStatus", Status.values());			
				request.getRequestDispatcher("sistema/alterarCurso.jsp").forward(request, response);
				return;
				//break;
			
			case "excluir":
				
				boolean result = cursoDAO.excluir(idCurso);
				if(result){
					request.setAttribute("result_ok", "Exclusão efetuada com Sucesso!");
				}else{
					request.setAttribute("result_error", "Erro ao excluir!");
				}	
				
				listaCurso = cursoDAO.listar();
				request.setAttribute("listaCurso", listaCurso);
				break;
				
			default:
				break;
			}
									
		}else{
			 listaCurso = cursoDAO.listar();			
		}
				
		request.setAttribute("listaCurso", listaCurso);
		request.getRequestDispatcher("sistema/cursoIndex.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action") != null){			
			
			boolean result = false;			
			
			String nome = request.getParameter("nomeCurso");
			String status = request.getParameter("status");			
			String[] modulos = request.getParameterValues("modulo");			
			String[] turmas = request.getParameterValues("turma");				
			Curso curso = null;
												 
			String action = request.getParameter("action");	
			switch (action) {
				case "cadastrar":
					
					curso = new Curso();
					curso.setNome(nome);
					curso.setStatus(Status.ATIVO);
					curso.setModulo(retornaListModulo(modulos));
					curso.setTurmas(retornaListTurma(turmas));
					result = cursoDAO.incluir(curso);					
					if(result){
						request.setAttribute("result_ok", "Curso Cadastrado com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao cadastrar o curso!");
					}					
					
					break;
				case "alterar":
					
					curso = new Curso();
					curso.setIdCurso(Long.valueOf(request.getParameter("idCurso")));
					curso.setNome(nome);
					curso.setStatus(Status.valueOf(status));
					curso.setModulo(retornaListModulo(modulos));
					curso.setTurmas(retornaListTurma(turmas));
					result = cursoDAO.alterar(curso);
					
					if(result){
						request.setAttribute("result_ok", "Usuário alterada com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao alterar a usuário!");
					}	
					
					break;
				case "consultar":					
					
					List<Curso> listaCurso = cursoDAO.listar();
					
					if(listaCurso.size() > 0){
						request.setAttribute("result_ok", "(" + listaCurso.size() + ") - Cursos(s) encontrado(s)!");
					}else{
						request.setAttribute("result_error", "Nenhuma Curso encontrado!");
					}	
					
					request.setAttribute("listaCurso", listaCurso);
					request.getRequestDispatcher("sistema/cursoIndex.jsp").forward(request, response);					
					return;
					//break;
				default:
					break;
			}
			
		}
		doGet(request,response);
		
	}
	
	private List<Modulo> retornaListModulo(String[] cusos){
		List<Modulo> listaModulo = new ArrayList<Modulo>();
		for (String string : cusos) {
			listaModulo.add(moduloDAO.obter(Long.valueOf(string)));
		}
		return listaModulo;
	}
	
	private List<Turma> retornaListTurma(String[] turmas){
		List<Turma> listaTurmas = new ArrayList<Turma>();
		for (String string : turmas) {
			listaTurmas.add(turmaDAO.obter(Long.valueOf(string)));
		}
		return listaTurmas;
	}
	

}
