package br.edu.infnet.academicnet.modelo;

import java.util.List;
import java.util.Date;

public class Avaliacao {

	private int idAvaliacao;

	private List<Questao> listQuestao;

	private Date dataInicio;

	private Date dataFim;

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public List<Questao> getListQuestao() {
		return listQuestao;
	}

	public void setListQuestao(List<Questao> listQuestao) {
		this.listQuestao = listQuestao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Boolean inicializarAvaliacao() {
		return null;
	}

	public Boolean finalizarAvaliacao() {
		return null;
	}

	public Boolean incluirAvaliacao(Avaliacao avaliacao) {
		return null;
	}

	public Boolean alterarAvaliacao(Avaliacao avaliacao) {
		return null;
	}

	public Boolean excluirAvaliacao(Avaliacao avaliacao) {
		return null;
	}

	public Boolean consultarAvaliacao(Avaliacao avaliacao) {
		return null;
	}

}
