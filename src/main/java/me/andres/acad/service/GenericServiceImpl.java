package me.andres.acad.service;

import jakarta.inject.Inject;
import me.andres.acad.dao.IDAO;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class GenericServiceImpl<T, ID> implements IGenericService<T, ID> {
    protected Class<T> className;
    protected abstract IDAO<T, ID> getDAO();

    public GenericServiceImpl(Class<T> className) {
        this.className = className;
    }

    @Override
    public T save(T t) {
        return getDAO().save(t);
    }

    @Override
    public T update(T t) {
        return getDAO().save(t);
    }

    @Override
    public T findById(ID id) throws NoSuchElementException {
        return getDAO().findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("%s with id %d not found", className.getName(), id)));
    }

    @Override
    public List<T> findAll() {
        return getDAO().findAll();
    }

    @Override
    public void delete(ID id) {
        getDAO().deleteById(id);
    }
}
