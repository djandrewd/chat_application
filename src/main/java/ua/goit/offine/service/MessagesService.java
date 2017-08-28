package ua.goit.offine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offine.dao.MessageDao;
import ua.goit.offine.entity.Messages;

/**
 * Service for accessing messages data from storage.
 *
 * @author Andrey Minov
 */
@Service
public class MessagesService {

  private final MessageDao messageDao;

  @Autowired
  public MessagesService(MessageDao messageDao) {
    this.messageDao = messageDao;
  }

  @Transactional(readOnly = true)
  public List<Messages> getLastN(long n) {
    return messageDao.getTopById(n);
  }

  @Transactional
  public void save(Messages entity) {
    messageDao.saveAndFlush(entity);
  }
}
