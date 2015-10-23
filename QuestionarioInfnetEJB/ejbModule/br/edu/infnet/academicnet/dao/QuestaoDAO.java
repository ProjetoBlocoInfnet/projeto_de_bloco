package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Local;

import br.edu.infnet.academicnet.modelo.Questao;

@Local
public interface QuestaoDAO extends GenericoDAO<Questao> {
	
	public List<Questao> consultarPorTextoDaQuestao(String texto);

	public List<Questao> listarAtivas();

}
