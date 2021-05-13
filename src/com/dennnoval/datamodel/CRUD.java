package com.dennnoval.datamodel;

import java.util.List;

/**
 *
 * @author dennnoval
 */
public abstract interface CRUD<T> {
  public List<T> read();
  public T readById(T id);
  public boolean create(T t);
  public boolean update(T t);
  public boolean delete(T id);
}
