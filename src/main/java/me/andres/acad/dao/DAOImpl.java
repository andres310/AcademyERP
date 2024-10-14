package me.andres.acad.dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(Transactional.TxType.REQUIRED)
public abstract class DAOImpl<T, ID> implements IDAO<T, ID> {

    @Inject
    private EntityManager em;

    @Override
    public Optional<T> findById(ID id) {
        return Optional.of(em.find(this.getDAOClass(), id));
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getDAOClass());
        Root<T> r = cq.from(this.getDAOClass());
        cq.select(r);
        TypedQuery<T> q = em.createQuery(cq);
        return q.getResultList();
    }

    @Override
    public T save(T entity) {
        return em.merge(entity);
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void deleteById(ID id) {
        em.remove(em.find(getDAOClass(), id));
    }

    public abstract Class<T> getDAOClass();
}
