package ua.goit.offine.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.offine.dao.ChatDao;
import ua.goit.offine.entity.Chat;

/**
 * Dao implementation for {@link ua.goit.offine.entity.Chat}
 */
@Repository
public class ChatDaoImpl extends AbstractGenericDaoImpl<String, Chat> implements ChatDao {

  @Autowired
  public ChatDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}
