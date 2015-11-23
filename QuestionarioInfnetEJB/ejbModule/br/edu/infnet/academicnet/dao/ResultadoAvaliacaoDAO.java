package br.edu.infnet.academicnet.dao;

import java.util.List;

import br.edu.infnet.academicnet.modelo.ResultadoAvaliacao;

public interface ResultadoAvaliacaoDAO extends GenericoDAO<ResultadoAvaliacao>
{
	public boolean seAlunoRespondeuAvaliacao(Long idAgendamento, Long idAluno);
	
	public List<ResultadoAvaliacao> obterPorNomeProfessor(String nome);

	public List<ResultadoAvaliacao> obterPorNomeCurso(String nome);
	
	public List<ResultadoAvaliacao> obterPorInfra();
}
