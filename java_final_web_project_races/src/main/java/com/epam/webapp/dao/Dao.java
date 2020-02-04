package com.epam.webapp.dao;

import com.epam.webapp.entity.Identifiable;
import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    Optional<T> findById(Long id);

    void removeById(Long id);

    List<T> getAll();

    void save(T entity);
}

