package br.edu.infnet.academicnet.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_administrador")
@PrimaryKeyJoinColumn(name="pessoa_id")
public class Administrador extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Administrador() {
	
	}
	
}
