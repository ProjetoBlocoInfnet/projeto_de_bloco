package br.edu.infnet.academicnet.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_aluno")
public class Aluno extends Pessoa {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAluno;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Turma> turmas;
	
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (idAluno ^ (idAluno >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (idAluno != other.idAluno)
			return false;
		if (turmas == null) {
			if (other.turmas != null)
				return false;
		} else if (!turmas.equals(other.turmas))
			return false;
		return true;
	}
	
	
	

}
