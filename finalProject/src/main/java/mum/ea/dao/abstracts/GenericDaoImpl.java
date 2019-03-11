package mum.ea.dao.abstracts;

import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericDaoImpl<TDomain extends BaseDomain> implements GenericDao<TDomain> {

    @PersistenceContext
    private EntityManager entityManager;

    protected Class<TDomain> domainClass;


    public void save(TDomain t) {
        entityManager.persist(t);
    }

    private void delete(TDomain entity) {
        entityManager.remove(entity);
    }

    public void delete(Long id) {
        TDomain entity = findById(id);
        delete(entity);
    }

    public void update(TDomain t) {
        entityManager.merge(t);
    }

    public TDomain findById(Long id) {
        return (TDomain) entityManager.find( domainClass, id );
    }

    public List<TDomain> findAll() {
        return entityManager.createQuery("from " + domainClass.getName()).getResultList();
    }
}
