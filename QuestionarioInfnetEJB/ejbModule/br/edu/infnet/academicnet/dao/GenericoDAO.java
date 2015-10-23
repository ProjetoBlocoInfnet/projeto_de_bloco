package br.edu.infnet.academicnet.dao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GenericoDAO<T>
{
		
    boolean incluir(T objeto);
    
    boolean alterar(T objeto);
    
    boolean excluir(long id);
    
    T obter(long id);
    
    List<T> listar();
}
