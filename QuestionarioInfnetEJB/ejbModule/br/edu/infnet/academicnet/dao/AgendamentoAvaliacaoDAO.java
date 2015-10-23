package br.edu.infnet.academicnet.dao;

import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;

public interface AgendamentoAvaliacaoDAO extends GenericoDAO<AgendamentoAvaliacao>
{
	public AgendamentoAvaliacao obterAtivo(long id);
}
