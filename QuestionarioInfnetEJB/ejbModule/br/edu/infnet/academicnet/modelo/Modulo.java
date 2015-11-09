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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import br.edu.infnet.academicnet.enumerators.Status;

@Entity
@Table(name="tbl_modulo")
public class Modulo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	private long idModulo;
	
	@Column(length=100)
	@Expose
	private String nomeModulo;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	@JoinColumn(name="professor_id")		
	private Professor professor;
	
	@ManyToMany(mappedBy="modulo")
	private List<Curso> cursos;
	
	@OneToOne(mappedBy="modulo")
	private AgendamentoAvaliacao agendamentoAvaliacao;

	public Modulo() {
		
	}

	public long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public AgendamentoAvaliacao getAgendamentoAvaliacao() {
		return agendamentoAvaliacao;
	}

	public void setAgendamentoAvaliacao(AgendamentoAvaliacao agendamentoAvaliacao) {
		this.agendamentoAvaliacao = agendamentoAvaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idModulo ^ (idModulo >>> 32));
		result = prime * result
				+ ((nomeModulo == null) ? 0 : nomeModulo.hashCode());
		
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
		Modulo other = (Modulo) obj;
		if (idModulo != other.idModulo)
			return false;
		if (nomeModulo == null) {
			if (other.nomeModulo != null)
				return false;
		} else if (!nomeModulo.equals(other.nomeModulo))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", nomeModulo=" + nomeModulo
				+ ", status=" + status 
				+ ", agendamentoAvaliacao=" + agendamentoAvaliacao + "]";
	}

	

	

}
