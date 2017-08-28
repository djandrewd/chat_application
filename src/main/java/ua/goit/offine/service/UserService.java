package ua.goit.offine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offine.dao.UsersDao;
import ua.goit.offine.entity.User;

/**
 * Service for user repository.
 */
@Service
public class UserService {
  private final UsersDao usersDao;

  @Autowired
  public UserService(UsersDao usersDao) {
    this.usersDao = usersDao;
  }

  @Transactional(readOnly = true)
  public User getById(String id) {
    return usersDao.findOne(id);
  }

  @Transactional(readOnly = true)
  public List<User> getAll() {
    return usersDao.findAll();
  }

  @Transactional
  public void save(User entity) {
    usersDao.save(entity);
  }

  @Transactional
  public void update(User entity) {
    usersDao.save(entity);
  }

  @Transactional
  public void remove(User entity) {
    usersDao.delete(entity);
  }
}
