package br.edu.infnet.academicnet.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_turma")
public class Turma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTurma;
	
	@ManyToMany
	@JoinTable(name="turma_alunos")
	private List<Aluno> alunos;
	
	@ManyToMany
	@JoinTable(name="turma_professores")
	private List<Professor> professores;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Curso> cursos;

	public Turma()
	{
		
	}
	
	public Turma(long idTurma)
	{
		super();
		this.idTurma = idTurma;
	}

	public long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(long idTurma) {
		this.idTurma = idTurma;
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
