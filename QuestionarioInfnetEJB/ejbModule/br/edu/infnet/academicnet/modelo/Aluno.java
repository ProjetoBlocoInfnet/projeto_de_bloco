package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_aluno")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Aluno extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	
	@ManyToMany(mappedBy = "alunos")
	private List<Turma> turmas;
	
		
	public Aluno() {
	}


	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
		
	

}
