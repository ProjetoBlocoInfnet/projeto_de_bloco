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

import br.edu.infnet.academicnet.enumerators.Categoria;
import br.edu.infnet.academicnet.enumerators.Status;
import br.edu.infnet.academicnet.enumerators.TipoResposta;

@Entity
@Table(name="tbl_questao")
public class Questao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idQuestao;
	
	@Column(nullable=false, unique = true)
	private String textoQuestao;
	
	@ManyToMany(mappedBy = "listQuestao")
	private List<Avaliacao> avaliacoes;
	
	@Enumerated(EnumType.STRING)
	@Column(length=50)
	private TipoResposta tipoResposta;
	
	@Enumerated(EnumType.STRING)
	@Column(length=50)
	private Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Questao()
	{
		
	}
		

	public long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getTextoQuestao() {
		return textoQuestao;
	}

	public void setTextoQuestao(String textoQuestao) {
		this.textoQuestao = textoQuestao;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((avaliacoes == null) ? 0 : avaliacoes.hashCode());
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + (int) (idQuestao ^ (idQuestao >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((textoQuestao == null) ? 0 : textoQuestao.hashCode());
		result = prime * result
				+ ((tipoResposta == null) ? 0 : tipoResposta.hashCode());
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
		if (avaliacoes == null) {
			if (other.avaliacoes != null)
				return false;
		} else if (!avaliacoes.equals(other.avaliacoes))
			return false;
		if (categoria != other.categoria)
			return false;
		if (idQuestao != other.idQuestao)
			return false;
		if (status != other.status)
			return false;
		if (textoQuestao == null) {
			if (other.textoQuestao != null)
				return false;
		} else if (!textoQuestao.equals(other.textoQuestao))
			return false;
		if (tipoResposta != other.tipoResposta)
			return false;
		return true;
	}
	
	
	



}
