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

import br.edu.infnet.academicnet.enumerators.StatusAvaliacao;

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

	//TODO essa rela��o ternaria entre turma, curso e professor tem que existir. ela n�o existe em lugar algum.
	//TODO turma j� estava aqui, coloquei o curso e o professor, avaliar se este � o local correto
	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;

	@OneToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@OneToOne
	@JoinColumn(name="modulo_id")
	private Modulo modulo;
	
	@ManyToOne 
	@JoinColumn(name="avaliacao_id") 
	private Avaliacao avaliacao;
	
	@Enumerated(EnumType.STRING)
	private StatusAvaliacao status;
	
	@OneToOne(mappedBy="agendamentoAvaliacao")	
	private ResultadoAvaliacao resultadoAvaliacao;
	
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public StatusAvaliacao getStatus() {
		return status;
	}

	public void setStatus(StatusAvaliacao status) {
		this.status = status;
	}

	public ResultadoAvaliacao getResultadoAvaliacao() {
		return resultadoAvaliacao;
	}

	public void setResultadoAvaliacao(ResultadoAvaliacao resultadoAvaliacao) {
		this.resultadoAvaliacao = resultadoAvaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((avaliacao == null) ? 0 : avaliacao.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ (int) (idAgendamento ^ (idAgendamento >>> 32));
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		result = prime * result
				+ ((professor == null) ? 0 : professor.hashCode());
		result = prime
				* result
				+ ((resultadoAvaliacao == null) ? 0 : resultadoAvaliacao
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
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
		if (idAgendamento != other.idAgendamento)
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (resultadoAvaliacao == null) {
			if (other.resultadoAvaliacao != null)
				return false;
		} else if (!resultadoAvaliacao.equals(other.resultadoAvaliacao))
			return false;
		if (status != other.status)
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}

	
	
	

}
