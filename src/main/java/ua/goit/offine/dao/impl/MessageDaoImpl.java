package ua.goit.offine.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.offine.dao.MessageDao;
import ua.goit.offine.entity.Messages;

/**
 * Data access object implementation for {@link ua.goit.offine.entity.Messages}
 */
@Repository
public class MessageDaoImpl extends AbstractGenericDaoImpl<Long, Messages> implements MessageDao {

  @Autowired
  public MessageDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}
