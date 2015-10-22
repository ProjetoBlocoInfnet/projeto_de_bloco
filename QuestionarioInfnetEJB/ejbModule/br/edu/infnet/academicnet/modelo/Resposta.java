package br.edu.infnet.academicnet.modelo;



public class Resposta {
	
	
	private int idResposta;
	
	
	private String textoResposta;

	public int getIdResposta() {
		return idResposta;
	}

	public Resposta()
	{
		
	}
	
	public Resposta(int idResposta, String textoResposta)
	{
		super();
		this.idResposta = idResposta;
		this.textoResposta = textoResposta;
	}
	
	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	public String getTextoResposta() {
		return textoResposta;
	}

	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}

	public Boolean incluirResposta(Resposta resposta) {
		return null;
	}

	public Boolean alterarResposta(Resposta resposta) {
		return null;
	}

	public Boolean excluirResposta(Resposta resposta) {
		return null;
	}

	public Boolean consultarResposta(Resposta resposta) {
		return null;
	}

}
