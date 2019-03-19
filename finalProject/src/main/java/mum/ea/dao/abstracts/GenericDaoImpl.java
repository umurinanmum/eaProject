package mum.ea.dao.abstracts;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
	protected EntityManager entityManager;

    protected Class<T> domainClass;


    public void save(T t) {
        entityManager.persist(t);
    }

    private void delete(T entity) {
        entityManager.remove(entity);
    }

    public void delete(Long id) {
        T entity = findOne(id);
        delete(entity);
    }

    public T update(T t) {
        return entityManager.merge(t);
    }

    public T findOne(Long id) {
        return (T) entityManager.find( domainClass, id );
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + domainClass.getName()).getResultList();
    }
}
