package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.infnet.academicnet.enumerators.TipoResposta;

@Entity
@Table(name="tbl_questao")
public class Questao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idQuestao;
	
	@Column(nullable=false, unique = true)
	private String textoQuestao;
	
	@ManyToMany(mappedBy = "listQuestao")
	private List<Avaliacao> avaliacoes;
	
	@Enumerated(EnumType.STRING)
	private TipoResposta tipoResposta;

	public Questao()
	{
		
	}
		
	public Questao(int idQuestao, String textoQuestao,
			List<Avaliacao> avaliacoes, TipoResposta tipoResposta) {
		super();
		this.idQuestao = idQuestao;
		this.textoQuestao = textoQuestao;
		this.avaliacoes = avaliacoes;
		this.tipoResposta = tipoResposta;
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
	
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public TipoResposta getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(TipoResposta tipoResposta) {
		this.tipoResposta = tipoResposta;
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
