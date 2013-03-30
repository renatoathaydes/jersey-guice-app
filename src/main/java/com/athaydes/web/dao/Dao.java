package com.athaydes.web.dao;

import java.util.List;

/**
 * User: Renato
 */
public interface Dao<T> {

	List<? extends T> getAll();

	T getById(String id);

}
