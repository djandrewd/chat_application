package ua.goit.offine.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.offine.dao.UsersDao;
import ua.goit.offine.entity.User;

/**
 * Users DAO implementation.
 *
 * @author Andrey Minov
 */
@Repository
public class UsersDaoImpl extends AbstractGenericDaoImpl<String, User>
    implements UsersDao {

  @Autowired
  public UsersDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}
