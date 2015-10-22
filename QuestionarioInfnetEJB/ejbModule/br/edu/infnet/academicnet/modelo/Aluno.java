package br.edu.infnet.academicnet.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_aluno")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Aluno extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAluno;
	*/
	
	@ManyToMany(mappedBy = "alunos")
	private List<Turma> turmas;
	
		
	public Aluno() {
		// TODO Auto-generated constructor stub
	}


	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	/*
	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	} */
	
	

}
