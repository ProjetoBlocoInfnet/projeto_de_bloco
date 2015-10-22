package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.infnet.academicnet.enumerators.Status;

@Entity
@Table(name="tbl_agendamento")
public class AgendamentoAvaliacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAgendamento;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	/*@OneToMany(mappedBy="agendamentoAvaliacao")
	private List<Avaliacao> avaliacao;*/
	
	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@ManyToOne 
	@JoinColumn(name="avaliacao_id") 
	private Avaliacao avaliacao;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public AgendamentoAvaliacao() {

	}

	
	public long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(long idAgendamento) {
		this.idAgendamento = idAgendamento;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idAgendamento ^ (idAgendamento >>> 32));
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
		AgendamentoAvaliacao other = (AgendamentoAvaliacao) obj;
		if (idAgendamento != other.idAgendamento)
			return false;
		return true;
	}
	
	

}