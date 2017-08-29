package ua.goit.offine.service;

import static org.springframework.data.domain.Sort.Direction.DESC;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offine.dao.MessageDao;
import ua.goit.offine.entity.ChatMessage;
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
  public List<ChatMessage> getLastN(long n) {
    PageRequest pageRequest = new PageRequest(0, (int) n, new Sort(DESC, "id"));
    return messageDao.findAll(pageRequest).getContent().stream()
                     .sorted(Comparator.comparingLong(Messages::getId)).map(
            v -> new ChatMessage(v.getId(), v.getText(),
                v.getChat() != null ? v.getChat().getName() : null,
                v.getUser() != null ? v.getUser().getLogin() : null)).collect(Collectors.toList());
  }

  @Transactional
  public ChatMessage save(Messages entity) {
    Messages message = messageDao.saveAndFlush(entity);
    return new ChatMessage(message.getId(), message.getText(),
        message.getChat() != null ? message.getChat().getName() : null,
        message.getUser() != null ? message.getUser().getLogin() : null);
  }
}
