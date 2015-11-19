package br.edu.infnet.academicnet.dao;

import br.edu.infnet.academicnet.modelo.ResultadoAvaliacao;

public interface ResultadoAvaliacaoDAO extends GenericoDAO<ResultadoAvaliacao>
{
	public boolean seAlunoRespondeuAvaliacao(Long idAgendamento, Long idAluno);
	
	public ResultadoAvaliacao obterPorNomeProfessor(String nome);

	public ResultadoAvaliacao obterPorNomeCurso(String nome);
	
	public ResultadoAvaliacao obterPorInfra();
}
