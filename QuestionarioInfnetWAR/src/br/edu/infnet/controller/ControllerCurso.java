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
				request.setAttribute("listaModulos", moduloDAO.listarAtivos());
				request.setAttribute("listaTurma", turmaDAO.listar());
				request.getRequestDispatcher("sistema/cadastroCurso.jsp").forward(request, response);
				return;
				//break;
			
			case "telaAlterar":
				
				Curso curso = cursoDAO.obter(idCurso);								
				
				//request.setAttribute("meusModulos", cursoDAO.CursoComModulosCursoId(idCurso).getModulo());
				List<Modulo> modulosAtivos = moduloDAO.listarAtivos();
				System.out.println("Tamanho antes: " + modulosAtivos.size());
				modulosAtivos.removeAll(curso.getModulo());
				/*for(Modulo m1 : modulosAtivos)
				{
					System.out.println("=================================");
					System.out.println(m1.getIdModulo());
					for(Modulo m2 : curso.getModulo())
					{
						System.out.println(m2.getIdModulo());
						if(m1.getIdModulo() == m2.getIdModulo())
						{
							modulosAtivos.remove(m2);
						}
					}
				}*/
				System.out.println("Tamanho depois: " + modulosAtivos.size());
				List<Turma> turmasAtivas = turmaDAO.listar();
				turmasAtivas.removeAll(curso.getTurmas());
				request.setAttribute("meusModulos", curso.getModulo());
				request.setAttribute("meusTurmas", curso.getTurmas());
				request.setAttribute("curso", curso);
				request.setAttribute("listaModulos", modulosAtivos);
				request.setAttribute("listaTurma", turmasAtivas);
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
				
				listaCurso = cursoDAO.listarAtivos();
				request.setAttribute("listaCurso", listaCurso);
				break;
				
			default:
				break;
			}
									
		}else{
			 listaCurso = cursoDAO.listarAtivos();			
		}
				
		request.setAttribute("listaCurso", listaCurso);
		request.getRequestDispatcher("sistema/cursoIndex.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("action") != null){			
			
			boolean result = false;			
			
			String nome = request.getParameter("nomeCurso");	
			String[] modulos = request.getParameterValues("modulos");			
			String[] turmas = request.getParameterValues("turmas");				
			Curso curso = null;
												 
			String action = request.getParameter("action");	
			switch (action) {
				case "cadastrar":
					
					curso = new Curso();
					curso.setNome(nome);
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
					
					curso = cursoDAO.obter(Long.valueOf(request.getParameter("idCurso")));
					curso.setNome(nome);
					curso.setModulo(retornaListModulo(modulos));
					curso.setTurmas(retornaListTurma(turmas));
					result = cursoDAO.alterar(curso);
					
					if(result){
						request.setAttribute("result_ok", "Curso alterado com Sucesso!");
					}else{
						request.setAttribute("result_error", "Erro ao alterar o curso!");
					}	
					
					break;
				case "consultar":					
					
					List<Curso> listaCurso = cursoDAO.obterPorNome(request.getParameter("nome"));
					
					if(listaCurso.size() > 0){
						request.setAttribute("result_ok", "(" + listaCurso.size() + ") - Curso(s) encontrado(s)!");
					}else{
						request.setAttribute("result_error", "Nenhum Curso encontrado!");
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
	
	private List<Modulo> retornaListModulo(String[] modulos){
		List<Modulo> listaModulo = new ArrayList<Modulo>();
		for (String string : modulos) {
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
