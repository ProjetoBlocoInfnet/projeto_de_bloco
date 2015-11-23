package br.edu.infnet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.academicnet.dao.ResultadoAvaliacaoDAO;
import br.edu.infnet.academicnet.enumerators.Categoria;
import br.edu.infnet.academicnet.enumerators.TipoResposta;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;
import br.edu.infnet.academicnet.modelo.Questao;
import br.edu.infnet.academicnet.modelo.ResultadoAvaliacao;

/**
 * Servlet implementation class ControllerMediaHistorica
 */
@WebServlet("/ControllerMediaHistorica")
public class ControllerMediaHistorica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ResultadoAvaliacaoDAO resultado;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerMediaHistorica() {
        super();
    }

    //Sumariza a média do Resultado da avaliação
    private List<ResultadoAvaliacao> sumarizarMedia(List<ResultadoAvaliacao> entrada)
    {
    	List<ResultadoAvaliacao> lista = new ArrayList<ResultadoAvaliacao>();
    	Map<AgendamentoAvaliacao,Integer> listaHash = new HashMap<AgendamentoAvaliacao,Integer>();
    	for(ResultadoAvaliacao r : entrada)
    	{
    		//Inicialização da lista
    		if(lista.size() == 0)
    		{
    			lista.add(r);
    			listaHash.put(r.getAgendamentoAvaliacao(), 1);
    		}
    		else
    		{
    			//Se encontrar na lista já montada, acrescenta ao valor da média e aumenta +1 no contador de quantidade
    			//de vezes que aquele agendamento aconteceu
    			boolean encontrou = false;
    			for(int i = 0; i < lista.size(); i++)
    			{
    				if(lista.get(i).getAgendamentoAvaliacao().equals(r.getAgendamentoAvaliacao()))
    				{
    					encontrou = true;
    					lista.get(i).setMedia(lista.get(i).getMedia()+r.getMedia());
    					listaHash.replace(r.getAgendamentoAvaliacao(),listaHash.get(r.getAgendamentoAvaliacao())+1);
    					break;
    				}
    			}
    			
    			//Se não encontrou, atualiza a lista
    			if(!encontrou)
    			{
    				lista.add(r);
        			listaHash.put(r.getAgendamentoAvaliacao(), 1);
    			}
    		}
    	}

    	//Ajustar a média simples
    	for(int i=0; i<lista.size(); i++)
    	{
    		for(Map.Entry<AgendamentoAvaliacao, Integer> linha : listaHash.entrySet())
    		{
    			if(lista.get(i).getAgendamentoAvaliacao().equals(linha.getKey()))
    			{
    				lista.get(i).setMedia(lista.get(i).getMedia()/linha.getValue());
    				break;
    			}
    		}
    	}
    	return lista;
    }

    //Sumariza a média do Resultado da avaliação de acordo com o tipo de pergunta
    //OBS.: Fiz overload só pra não perder a lógica do método acima
    private List<ResultadoAvaliacao> sumarizarMedia(List<ResultadoAvaliacao> entrada, Categoria tipo)
    {
    	List<ResultadoAvaliacao> lista = new ArrayList<ResultadoAvaliacao>();
    	Map<AgendamentoAvaliacao,Integer> listaHash = new HashMap<AgendamentoAvaliacao,Integer>();
    	for(ResultadoAvaliacao r : entrada)
    	{
    		//Inicialização da lista
    		if(lista.size() == 0)
    		{
    			r.setMedia(0); //Refazendo média para exibição
    			listaHash.put(r.getAgendamentoAvaliacao(), 0);
    			for(Map.Entry<Questao, String> q : r.getRespostas().entrySet())
    			{
    				if(tipo.compareTo(q.getKey().getCategoria()) == 0 && TipoResposta.LIKERT.compareTo(q.getKey().getTipoResposta()) == 0)
    				{
    					r.setMedia(r.getMedia()+Integer.valueOf(q.getValue()));
    					listaHash.replace(r.getAgendamentoAvaliacao(),listaHash.get(r.getAgendamentoAvaliacao())+1);
    				}
    			}
    			lista.add(r);
    		}
    		else
    		{
    			//Se encontrar na lista já montada, acrescenta ao valor da média e aumenta +1 no contador de quantidade
    			//de vezes que aquele agendamento aconteceu
    			boolean encontrou = false;
    			for(int i = 0; i < lista.size(); i++)
    			{
    				if(lista.get(i).getAgendamentoAvaliacao().equals(r.getAgendamentoAvaliacao()))
    				{
    					encontrou = true;
            			for(Map.Entry<Questao, String> q : r.getRespostas().entrySet())
            			{
            				if(tipo.compareTo(q.getKey().getCategoria()) == 0 && TipoResposta.LIKERT.compareTo(q.getKey().getTipoResposta()) == 0)
            				{
            					lista.get(i).setMedia(lista.get(i).getMedia()+Integer.valueOf(q.getValue()));
            					listaHash.replace(r.getAgendamentoAvaliacao(),listaHash.get(r.getAgendamentoAvaliacao())+1);
            				}
            			}
    					break;
    				}
    			}
    			
    			//Se não encontrou, atualiza a lista
    			if(!encontrou)
    			{
        			r.setMedia(0); //Refazendo média para exibição
        			listaHash.put(r.getAgendamentoAvaliacao(), 0);
        			for(Map.Entry<Questao, String> q : r.getRespostas().entrySet())
        			{
        				if(tipo.compareTo(q.getKey().getCategoria()) == 0 && TipoResposta.LIKERT.compareTo(q.getKey().getTipoResposta()) == 0)
        				{
        					r.setMedia(r.getMedia()+Integer.valueOf(q.getValue()));
        					listaHash.replace(r.getAgendamentoAvaliacao(),listaHash.get(r.getAgendamentoAvaliacao())+1);
        				}
        			}
        			lista.add(r);
    			}
    		}
    	}

    	//Ajustar a média simples
    	for(int i=0; i<lista.size(); i++)
    	{
    		for(Map.Entry<AgendamentoAvaliacao, Integer> linha : listaHash.entrySet())
    		{
    			if(lista.get(i).getAgendamentoAvaliacao().equals(linha.getKey()))
    			{
    				lista.get(i).setMedia(lista.get(i).getMedia()/linha.getValue());
    				break;
    			}
    		}
    	}
    	return lista;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("tipoRetorno", "total");
		request.setAttribute("resultados", resultado.listar());
		request.getRequestDispatcher("sistema/mediaHistoricaIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		System.out.println(action);
		if(action != null)
		{
			switch(action)
			{
				case "consultar":
					String tipoConsulta = request.getParameter("tipoConsulta");
					System.out.println(tipoConsulta);
					switch(tipoConsulta)
					{
						case "total":
							request.setAttribute("tipoRetorno", "total");
							request.setAttribute("resultados", this.sumarizarMedia(resultado.listar()));
							break;
						case "curso":
							request.setAttribute("tipoRetorno", "curso");
							request.setAttribute("resultados", this.sumarizarMedia(resultado.obterPorNomeCurso(request.getParameter("valor")),Categoria.CURSO));
							break;
						case "infra":
							request.setAttribute("tipoRetorno", "infra");
							request.setAttribute("resultados", this.sumarizarMedia(resultado.obterPorInfra(),Categoria.MODULO_INFRA));
							break;
						case "professor":
							request.setAttribute("tipoRetorno", "professor");
							request.setAttribute("resultados", this.sumarizarMedia(resultado.obterPorNomeProfessor(request.getParameter("valor")),Categoria.PROFESSOR));
							break;
						default:
							request.setAttribute("tipoRetorno", "total");
							request.setAttribute("resultados", this.sumarizarMedia(resultado.listar()));
					}
					break;
				default:
					request.setAttribute("result_error", "Não houve ação válida inserida");
			}
		}
		request.getRequestDispatcher("sistema/mediaHistoricaIndex.jsp").forward(request, response);
	}
}