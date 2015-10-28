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
import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.modelo.Aluno;
import br.edu.infnet.academicnet.modelo.Curso;
import br.edu.infnet.academicnet.modelo.Professor;
import br.edu.infnet.academicnet.modelo.Turma;

/**
 * Servlet implementation class ControllerTurma
 */
@WebServlet("/ControllerTurma")
public class ControllerTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private TurmaDAO turmaDAO;
	
	@EJB 
	private PessoaDAO pessoaDAO;
	
	@EJB 
	private CursoDAO cursoDAO;
   
	
    public ControllerTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Turma> listaTurma = null;
		
		if(request.getParameter("tela") != null){
			String tela = request.getParameter("tela");	
			
			long idTurma =0;
			
			if(request.getParameter("idTurma") != null){
				idTurma = Long.valueOf(request.getParameter("idTurma"));
			}
						
			switch (tela) {
			case "telaCadastro":				
				request.setAttribute("listaAlunos", pessoaDAO.obterAlunos());
				request.setAttribute("listaCurso", cursoDAO.listar());
				request.setAttribute("listaProfessor", pessoaDAO.obterProfessores());
				request.getRequestDispatcher("sistema/cadastroTurma.jsp").forward(request, response);
				return;
				//break;
			
			case "telaAlterar":
				
				Turma turma = turmaDAO.obter(idTurma);
				request.setAttribute("turma", turma);
				request.setAttribute("listaAlunos", pessoaDAO.obterAlunos());
				request.setAttribute("listaCursos", cursoDAO.listar());
				request.setAttribute("listaProfessores", pessoaDAO.obterProfessores());				
				request.getRequestDispatcher("sistema/alterarTurma.jsp").forward(request, response);
				return;
				//break;
			
			case "excluir":
				
				boolean result = turmaDAO.excluir(idTurma);
				if(result){
					request.setAttribute("result_ok", "Exclusão efetuada com Sucesso!");
				}else{
					request.setAttribute("result_error", "Erro ao excluir!");
				}	
				
				listaTurma = turmaDAO.listar();
				request.setAttribute("listaTurma", listaTurma);
				break;
				
			default:
				break;
			}
									
		}else{
			 listaTurma = turmaDAO.listar();			
		}
				
		request.setAttribute("listaTurma", listaTurma);
		request.getRequestDispatcher("sistema/turmaIndex.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action") != null){
			
			
			boolean result = false;
			
			String nomeTurma = request.getParameter("nome");
			String[] alunos = request.getParameterValues("alunos");
			String[] professores = request.getParameterValues("professores");	
			Turma turma = null;
			
			 
			String action = request.getParameter("action");	
			switch (action) {
				case "cadastrar":
					
					turma = new Turma();
					turma.setNomeTurma(nomeTurma);
					turma.setAlunos(retornaListAlunos(alunos));
					turma.setProfessores(retornaListProfessor(professores));
					result = turmaDAO.incluir(turma);					
					if(result){
						request.setAttribute("result_ok", "Turma cadastrada com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao cadastrar a turma!");
					}					
					
					break;
				case "alterar":
					
					turma = new Turma();
					turma.setIdTurma(Long.valueOf(request.getParameter("idTurma")));
					turma.setNomeTurma(nomeTurma);
					turma.setAlunos(retornaListAlunos(alunos));
					turma.setProfessores(retornaListProfessor(professores));
					result = turmaDAO.alterar(turma);
					
					if(result){
						request.setAttribute("result_ok", "Turma alterada com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao alterar a turma!");
					}	
					
					break;
				case "consultar":					
					
					List<Turma> listaTurma = turmaDAO.listar();
					
					if(listaTurma.size() > 0){
						request.setAttribute("result_ok", "(" + listaTurma.size() + ") - Turmas(s) encontradas!");
					}else{
						request.setAttribute("result_error", "Nenhuma Turma encontrada!");
					}	
					
					request.setAttribute("listaTurma", listaTurma);
					request.getRequestDispatcher("sistema/turmaIndex.jsp").forward(request, response);					
					return;
					//break;
				default:
					break;
			}
			
		}
		doGet(request,response);
	}
	
	
	private List<Aluno> retornaListAlunos(String[] alunos){
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		for (String string : alunos) {
			listaAluno.add(pessoaDAO.obterAluno(Long.valueOf(string)));
		}
		return listaAluno;
	}
	
	private List<Professor> retornaListProfessor(String[] professores){
		List<Professor> listaProfessor = new ArrayList<Professor>();
		for (String string : professores) {
			listaProfessor.add(pessoaDAO.obterProfessor(Long.valueOf(string)));
		}
		return listaProfessor;
	}
	
	

}
