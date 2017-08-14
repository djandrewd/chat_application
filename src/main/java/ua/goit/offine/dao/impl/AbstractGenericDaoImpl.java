package ua.goit.offine.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.goit.offine.dao.GenericDao;

/**
 * Implementation for the basic DAO methods.
 *
 * @author Andrey Minov
 */
public abstract class AbstractGenericDaoImpl<K extends Serializable, V> implements GenericDao<K, V> {

  private SessionFactory sessionFactory;

  public AbstractGenericDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public V getById(K id, Class<? extends V> idClass) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(idClass, id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<V> getAll(Class<? extends V> entityClass) {
    Session session = sessionFactory.getCurrentSession();
    return (List<V>) session.createCriteria(entityClass).list();
  }

  @Override
  public void save(V entity) {
    Session session = sessionFactory.getCurrentSession();
    session.save(entity);
  }

  @Override
  public void update(V entity) {
    Session session = sessionFactory.getCurrentSession();
    session.update(entity);
  }

  @Override
  public void remove(V entity) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(entity);
  }
}
