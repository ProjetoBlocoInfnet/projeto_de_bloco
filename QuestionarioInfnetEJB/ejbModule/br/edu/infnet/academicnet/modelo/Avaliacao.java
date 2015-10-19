package br.edu.infnet.academicnet.modelo;

import java.util.List;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAvaliacao;
	
	@ManyToMany
	@JoinTable(name="avaliacao_questoes")
	private List<Questao> listQuestao;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
		

	public Avaliacao()
	{
		
	}
	
	public Avaliacao(int idAvaliacao, List<Questao> listQuestao, Date dataInicio, Date dataFim)
	{
		super();
		this.idAvaliacao = idAvaliacao;
		this.listQuestao = listQuestao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + idAvaliacao;
		result = prime * result
				+ ((listQuestao == null) ? 0 : listQuestao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (idAvaliacao != other.idAvaliacao)
			return false;
		if (listQuestao == null) {
			if (other.listQuestao != null)
				return false;
		} else if (!listQuestao.equals(other.listQuestao))
			return false;
		return true;
	}

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
