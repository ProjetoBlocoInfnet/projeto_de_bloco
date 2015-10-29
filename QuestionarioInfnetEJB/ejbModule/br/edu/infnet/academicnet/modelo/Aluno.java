package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tbl_aluno")
@PrimaryKeyJoinColumn(name = "pessoa_id")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Aluno extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	
	@ManyToMany(mappedBy = "alunos")
	@XmlTransient
	private List<Turma> turmas;
	
		
	public Aluno() {
	}


	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}


	@Override
	public String toString() {
		return "Aluno [turmas=" + turmas + ", getMatricula()=" + getMatricula()
				+ ", getNome()=" + getNome() + ", getEndereco()="
				+ getEndereco() + ", getCep()=" + getCep() + ", getEmail()="
				+ getEmail() + ", getUsuario()=" + getUsuario()
				+ ", getStatus()=" + getStatus() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
