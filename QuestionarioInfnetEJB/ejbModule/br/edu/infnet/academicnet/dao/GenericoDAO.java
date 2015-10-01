package br.edu.infnet.academicnet.dao;

import java.util.List;

public interface GenericoDAO<T>
{
    void incluir(T objeto);
    
    void alterar(T objeto);
    
    void excluir(long id);
    
    T obter(long id);
    
    List<T> listar();
}
