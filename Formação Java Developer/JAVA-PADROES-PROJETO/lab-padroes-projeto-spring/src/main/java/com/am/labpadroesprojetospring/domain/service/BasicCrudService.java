package com.am.labpadroesprojetospring.domain.service;

import java.util.Optional;
import java.util.Set;

public interface BasicCrudService<T, ID> {
    Set<T> all();
    Optional<T> byId(ID id);
    T save(T obj) throws IllegalArgumentException;
    T update(T obj,ID id) throws IllegalArgumentException;
    void deleteAll(Set<T> setObj);
    void deleteById(ID id);
}
