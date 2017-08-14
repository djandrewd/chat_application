package ua.goit.offine.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic data access object for all of the entities.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author Andrey Minov
 */
public interface GenericDao<K extends Serializable, V> {

  /**
   * Gets entity by identifier.
   *
   * @param id      the identifier
   * @param idClass identity class.
   * @return the entity by id
   */
  V getById(K id, Class<? extends V> idClass);

  /**
   * Gets all stored entities from database.
   *
   * @param entityClass the entity class
   * @return the all the entities in database
   */
  List<V> getAll(Class<? extends V> entityClass);

  /**
   * Save entity into persisted context.
   *
   * @param entity the newly created entity
   */
  void save(V entity);

  /**
   * Update current entity.
   *
   * @param entity the entity from persisted context
   */
  void update(V entity);

  /**
   * Remove from persisted context.
   *
   * @param entity the entity to remove
   */
  void remove(V entity);
}
