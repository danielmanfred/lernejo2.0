package br.com.lernejo.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Funcionalidades básicas do banco de dados.
 * @author Daniel Tiago e Givanildo.
 */
public interface InterfaceDAO<T> 
{
    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void merge(T entity);
    T getEntity(Serializable id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    List<T> getEntities();
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
}
