package br.edu.infnet.academicnet.dao;

import br.edu.infnet.academicnet.modelo.ResultadoAvaliacao;

public interface ResultadoAvaliacaoDAO extends GenericoDAO<ResultadoAvaliacao>
{
	public boolean seAlunoRespondeuAvaliacao(Long idAgendamento, Long idAluno);
}
