package br.edu.infnet.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.AgendamentoAvaliacaoDAO;
import br.edu.infnet.academicnet.dao.AvaliacaoDAO;
import br.edu.infnet.academicnet.dao.CursoDAO;
import br.edu.infnet.academicnet.dao.ModuloDAO;
import br.edu.infnet.academicnet.dao.PessoaDAO;
import br.edu.infnet.academicnet.dao.TurmaDAO;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;

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
    ModuloDAO modulo;
    
    @EJB
    CursoDAO curso;
    
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null)
		{
			switch(action)
			{
				case "telaCadastro":
					request.setAttribute("avaliacoes", avaliacao.listar());
					request.setAttribute("turmas", turma.listar());
					request.setAttribute("professores", professor.obterProfessores());
					request.setAttribute("modulos", modulo.listar());
					request.setAttribute("cursos", curso.listar());
					request.getRequestDispatcher("sistema/cadastroAgendamento.jsp").forward(request, response);
					return;
				case "editar":
					request.getRequestDispatcher("sistema/alterarAgendamento.jsp").forward(request, response);
					return;
				case "excluir":
					long id = Long.valueOf(request.getParameter("id"));
					request = checkReturn(agendamento.excluir(id), action, request);
					break;
				//case "excluirQuestao":
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
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
					a = new AgendamentoAvaliacao();
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
					a.setCurso(curso.obter(Long.valueOf(request.getParameter("curso"))));
					a.setModulo(modulo.obter(Long.valueOf(request.getParameter("modulo"))));
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
					a.setCurso(curso.obter(Long.valueOf(request.getParameter("curso"))));
					a.setModulo(modulo.obter(Long.valueOf(request.getParameter("modulo"))));
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
