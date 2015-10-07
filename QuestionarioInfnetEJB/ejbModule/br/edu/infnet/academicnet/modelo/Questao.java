package br.edu.infnet.academicnet.modelo;

public class Questao {

	private int idQuestao;

	private String textoQuestao;

	public Questao()
	{
		
	}
	
	public Questao(int idQuestao, String textoQuestao)
	{
		super();
		this.idQuestao = idQuestao;
		this.textoQuestao = textoQuestao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idQuestao;
		result = prime * result
				+ ((textoQuestao == null) ? 0 : textoQuestao.hashCode());
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
		Questao other = (Questao) obj;
		if (idQuestao != other.idQuestao)
			return false;
		if (textoQuestao == null) {
			if (other.textoQuestao != null)
				return false;
		} else if (!textoQuestao.equals(other.textoQuestao))
			return false;
		return true;
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getTextoQuestao() {
		return textoQuestao;
	}

	public void setTextoQuestao(String textoQuestao) {
		this.textoQuestao = textoQuestao;
	}

	public Boolean incluirQuestao(Questao questao) {
		return null;
	}

	public Boolean alterarQuestao(Questao questao) {
		return null;
	}

	public Boolean excluirQuestao(Questao questao) {
		return null;
	}

	public Boolean consultarQuestao(Questao questao) {
		return null;
	}

}
