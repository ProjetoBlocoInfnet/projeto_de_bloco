package br.edu.infnet.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.AvaliacaoDAO;
import br.edu.infnet.academicnet.dao.CursoDAO;
import br.edu.infnet.academicnet.dao.ModuloDAO;
import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Modulo;
import br.edu.infnet.academicnet.modelo.Professor;
import br.edu.infnet.academicnet.modelo.Turma;
import flexjson.JSONSerializer;


/**
 * Servlet implementation class ControllerAgendamento
 */
@WebServlet("/ControllerAgendamento") 
public class ControllerAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    AgendamentoAvaliacaoDAO agendamento;

    @EJB
    TurmaDAO turma;
    
    @EJB
    ModuloDAO moduloDAO;
    
    @EJB
    CursoDAO cursoDAO;
    
    @EJB
    PessoaDAO professor;
    
    @EJB
    AvaliacaoDAO avaliacao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAgendamento() {
        super();
    }

    //Fun��es auxiliares
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null)
		{
			long id;
			switch(action)
			{
				case "telaCadastro":
					request.setAttribute("avaliacoes", avaliacao.listar());
					//request.setAttribute("turmas", turma.listar());
					//request.setAttribute("professores", professor.obterProfessores());
					//request.setAttribute("modulos", modulo.listar());
					request.setAttribute("cursos", cursoDAO.listarAtivos());
					request.getRequestDispatcher("sistema/cadastroAgendamento.jsp").forward(request, response);
					return;
				case "editar":
					id = Long.valueOf(request.getParameter("id"));
					AgendamentoAvaliacao a = agendamento.obter(id);
					request.setAttribute("agendamento", a);
//					cursoDAO.listarModulosPorCursoId(a.getCurso().getIdCurso());
//					a.getCurso().getTurmas();
					request.getRequestDispatcher("sistema/alterarAgendamento.jsp").forward(request, response);
					return;
				case "excluir":
					id = Long.valueOf(request.getParameter("id"));
					request = checkReturn(agendamento.excluir(id), action, request);
					break;
				//case "excluirQuestao":
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		String list = request.getParameter("list");
		if(list != null)
		{
			Long idCurso;
			JSONSerializer serializer;
			String jsonStr;
			switch(list)
			{
				case "listarModulos":
					
					List<Modulo> listaModulos = new ArrayList<Modulo>();
					
					idCurso = Long.valueOf(request.getParameter("idCurso"));					
					listaModulos = cursoDAO.listarModulosPorCursoId(idCurso);
					
					
					serializer = new JSONSerializer().prettyPrint(true); 
				    jsonStr = serializer.serialize(listaModulos);
				    System.out.println(jsonStr);								
					
				    response.setContentType("application/json");  
				    response.setCharacterEncoding("UTF-8"); 
				    response.getWriter().write(jsonStr); 	
					
					return ;
				case "listarTurmas":
					
					List<Turma> listaTurmas = new ArrayList<Turma>();
					
					idCurso = Long.valueOf(request.getParameter("idCurso"));					
					listaTurmas = cursoDAO.obter(idCurso).getTurmas();
					
					serializer = new JSONSerializer().prettyPrint(true); 
				    jsonStr = serializer.serialize(listaTurmas);
				    System.out.println(jsonStr);								
					
				    response.setContentType("application/json");  
				    response.setCharacterEncoding("UTF-8"); 
				    response.getWriter().write(jsonStr); 	
					
					return ;
				case "listarProfessores":
					
					List<Professor> listaProfessores = new ArrayList<Professor>();
					
					Long idModulo = Long.valueOf(request.getParameter("idModulo"));					
					listaProfessores.add(moduloDAO.obter(idModulo).getProfessor());

					serializer = new JSONSerializer().prettyPrint(true); 
				    jsonStr = serializer.serialize(listaProfessores);
				    System.out.println(jsonStr);								
					
				    response.setContentType("application/json");  
				    response.setCharacterEncoding("UTF-8"); 
				    response.getWriter().write(jsonStr); 	
					
					return ;
			}	
		}
		request.setAttribute("agendamentos", agendamento.listar());
		request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		AgendamentoAvaliacao a = null;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		java.util.Date dataInicio = null;
		java.util.Date dataFim = null;
		if(action != null)
		{
			switch(action)
			{
				case "cadastrar":
					
					System.out.println("Testando a data");
					
					a = new AgendamentoAvaliacao();
					
					try
					{
						dataInicio = (java.util.Date)sdf.parse(request.getParameter("dataInicio"));
						dataFim = (java.util.Date)sdf.parse(request.getParameter("dataFim"));
						
						System.out.println(dataInicio);
						System.out.println(dataFim);
						
						a.setDataInicio(new java.sql.Date(dataInicio.getTime()));
						a.setDataFim(new java.sql.Date(dataFim.getTime()));
					}
					catch (ParseException e)
					{
						e.printStackTrace();
					}
					
					a.setAvaliacao(avaliacao.obter(Long.valueOf(request.getParameter("avaliacao"))));
					a.setTurma(turma.obter(Long.valueOf(request.getParameter("turma"))));
					a.setCurso(cursoDAO.obter(Long.valueOf(request.getParameter("curso"))));
					a.setModulo(moduloDAO.obter(Long.valueOf(request.getParameter("modulo"))));
					a.setProfessor(professor.obterProfessor(Long.valueOf(request.getParameter("professor"))));
					request = checkReturn(agendamento.incluir(a), action, request);
					break;
				case "alterar":
					a = agendamento.obter(Long.valueOf(request.getParameter("id")));
					try
					{
						dataInicio = (java.util.Date)sdf.parse(request.getParameter("dataInicio"));
						dataFim = (java.util.Date)sdf.parse(request.getParameter("dataFim"));
						a.setDataInicio(new java.sql.Date(dataInicio.getTime()));
						a.setDataFim(new java.sql.Date(dataFim.getTime()));
					}
					catch (ParseException e)
					{
						e.printStackTrace();
					}
					
					a.setAvaliacao(avaliacao.obter(Long.valueOf(request.getParameter("avaliacao"))));
					a.setTurma(turma.obter(Long.valueOf(request.getParameter("turma"))));
					a.setCurso(cursoDAO.obter(Long.valueOf(request.getParameter("curso"))));
					a.setModulo(moduloDAO.obter(Long.valueOf(request.getParameter("modulo"))));
					a.setProfessor(professor.obterProfessor(Long.valueOf(request.getParameter("professor"))));
					request = checkReturn(agendamento.alterar(a), action, request);
					break;
				case "consultar":
					String tipoConsulta = request.getParameter("tipoConsulta");
					switch(tipoConsulta)
					{
						case "agendamento":
							List<AgendamentoAvaliacao> procurado = new ArrayList<AgendamentoAvaliacao>();
							procurado.add(agendamento.obter(Long.valueOf(request.getParameter("valor"))));
							request.setAttribute("agendamentos", procurado);
							break;
						case "avaliacao":
						case "dataInicio":
							
						case "dataFim":
						case "turma":
						case "curso":
						case "modulo":
						case "professor":
						default:
							request.setAttribute("agendamentos", agendamento.listar());
					}
					request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
					return;
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		request.setAttribute("agendamentos", agendamento.listar());
		request.getRequestDispatcher("sistema/agendamentoIndex.jsp").forward(request, response);
	}

}
