package br.edu.infnet.academicnet.dao;

import java.util.Date;
import java.util.List;

import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;
import br.edu.infnet.academicnet.modelo.AgendamentoAvaliacao;

public interface AgendamentoAvaliacaoDAO extends GenericoDAO<AgendamentoAvaliacao>
{
	public AgendamentoAvaliacao obterAtivo(long id);
	public List<AgendamentoAvaliacao> obterPorStatusDataInicio(StatusAvaliacao status, Date data);
	public List<AgendamentoAvaliacao> obterPorStatusDataFim(StatusAvaliacao status, Date data);
}
