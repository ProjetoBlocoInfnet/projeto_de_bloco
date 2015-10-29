package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tbl_turma")
@XmlRootElement
public class Turma implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTurma;
	
	private String nomeTurma;
	
	@ManyToMany
	@JoinTable(name="turma_alunos")
	@XmlTransient
	private List<Aluno> alunos;
		
	@ManyToMany
	@JoinTable(name="turma_professores")
	private List<Professor> professores;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Curso> cursos;
	
	@OneToOne(mappedBy = "turma")
	private AgendamentoAvaliacao avaliacao;
	

	public Turma()
	{
		
	}
	

	public Long getIdTurma() {
		return idTurma;
	}
	
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}	
		
	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public AgendamentoAvaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AgendamentoAvaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
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
		Turma other = (Turma) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		return true;
	}

	
}
