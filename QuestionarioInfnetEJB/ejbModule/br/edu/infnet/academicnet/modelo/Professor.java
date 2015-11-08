package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_professor")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Professor extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToMany(mappedBy = "professores")
	private List<Turma> turmas;
	
	@OneToMany(mappedBy="professor")
	private List<Modulo> modulos;
	
	public Professor() {
	
	}

	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}


	public List<Modulo> getModulos() {
		return modulos;
	}


	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
		result = prime * result + ((turmas == null) ? 0 : turmas.hashCode());
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
		Professor other = (Professor) obj;
		if (modulos == null) {
			if (other.modulos != null)
				return false;
		} else if (!modulos.equals(other.modulos))
			return false;
		if (turmas == null) {
			if (other.turmas != null)
				return false;
		} else if (!turmas.equals(other.turmas))
			return false;
		return true;
	}
	
	
	
	
	
}
