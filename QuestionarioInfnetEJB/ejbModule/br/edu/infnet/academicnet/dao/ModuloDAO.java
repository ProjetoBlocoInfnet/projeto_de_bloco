package br.edu.infnet.academicnet.dao;

import java.util.List;

import br.edu.infnet.academicnet.modelo.Modulo;

public interface ModuloDAO extends GenericoDAO<Modulo>
{
	public List<Modulo> obterPorNome(String nome);

	//public boolean excluirModulo(long idAvaliacao, long idQuestao);
}
