package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_professor")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Professor extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idProfessor;
	*/
	
	@ManyToMany(mappedBy = "professores")
	private List<Turma> turmas;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	/*
	public long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(long idProfessor) {
		this.idProfessor = idProfessor;
	} */

	
	
	
	
	
}
