package br.edu.infnet.academicnet.dao;

import java.util.List;

import br.edu.infnet.academicnet.modelo.Avaliacao;

public interface AvaliacaoDAO extends GenericoDAO<Avaliacao>{
	public List<Avaliacao> obterPorNome(String nome);

	public boolean excluirQuestao(long idAvaliacao, long idQuestao);
}
