package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.academicnet.enumerators.Status;

@Entity
@Table(name="tbl_avaliacao")
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAvaliacao;
	
	@Column
	private String nome;
	
	@ManyToMany
	@JoinTable(name="avaliacao_questoes",
	joinColumns = @JoinColumn(name = "avaliacao_id"),
	inverseJoinColumns = @JoinColumn(name = "questao_id"))
	private List<Questao> listQuestao;
	
	/*
	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;	*/
	
	/*@ManyToOne
	@JoinColumn(name="agendamento_id") 
	private AgendamentoAvaliacao agendamentoAvaliacao;*/
	
	@OneToMany(mappedBy="avaliacao")
	private List<AgendamentoAvaliacao> agendamentoAvaliacao;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	

	public Avaliacao()
	{
		
	}
	
	
	public long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Questao> getListQuestao() {
		return listQuestao;
	}

	public void setListQuestao(List<Questao> listQuestao) {
		this.listQuestao = listQuestao;
	}

	public List<AgendamentoAvaliacao> getAgendamentoAvaliacao() {
		return agendamentoAvaliacao;
	}

	public void setAgendamentoAvaliacao(
			List<AgendamentoAvaliacao> agendamentoAvaliacao) {
		this.agendamentoAvaliacao = agendamentoAvaliacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((agendamentoAvaliacao == null) ? 0 : agendamentoAvaliacao
						.hashCode());
		result = prime * result + (int) (idAvaliacao ^ (idAvaliacao >>> 32));
		result = prime * result
				+ ((listQuestao == null) ? 0 : listQuestao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (agendamentoAvaliacao == null) {
			if (other.agendamentoAvaliacao != null)
				return false;
		} else if (!agendamentoAvaliacao.equals(other.agendamentoAvaliacao))
			return false;
		if (idAvaliacao != other.idAvaliacao)
			return false;
		if (listQuestao == null) {
			if (other.listQuestao != null)
				return false;
		} else if (!listQuestao.equals(other.listQuestao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	

}
