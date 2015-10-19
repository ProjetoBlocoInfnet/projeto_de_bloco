package br.edu.infnet.academicnet.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_resultadoAvaliacao")
public class ResultadoAvaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idResultadoAvaliacao;
	
	@Column(nullable=false)
	private double media;
	
	@ElementCollection
	@MapKeyColumn(name="idQuestao")
	@Column(name="respostas")
	@CollectionTable(name="questoes_respostas", joinColumns = @JoinColumn(name="resposta_valor"))
	private Map<Questao,String> respostas = new HashMap<Questao,String>();

	public ResultadoAvaliacao()
	{
		
	}
		
	public ResultadoAvaliacao(long idResultadoAvaliacao, double media,
			Map<Questao, String> respostas) {
		super();
		this.idResultadoAvaliacao = idResultadoAvaliacao;
		this.media = media;
		this.respostas = respostas;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}


	public long getIdResultadoAvaliacao() {
		return idResultadoAvaliacao;
	}

	public void setIdResultadoAvaliacao(long idResultadoAvaliacao) {
		this.idResultadoAvaliacao = idResultadoAvaliacao;
	}

	public Boolean efetuarAvaliacao() {
		return null;
	}

}
