package br.edu.infnet.academicnet.modelo;

public class Turma {

	private int idTurma;

	public Turma()
	{
		
	}
	
	public Turma(int idTurma)
	{
		super();
		this.idTurma = idTurma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTurma;
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
		if (idTurma != other.idTurma)
			return false;
		return true;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

}
