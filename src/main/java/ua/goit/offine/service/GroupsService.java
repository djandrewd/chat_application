package ua.goit.offine.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offine.dao.GroupsDao;
import ua.goit.offine.entity.Group;

/**
 * Service for all user groups.
 *
 * @author Andrey Minov
 */
@Service
public class GroupsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(GroupsService.class);

  private final GroupsDao groupsDao;

  @Autowired
  public GroupsService(GroupsDao groupsDao) {
    this.groupsDao = groupsDao;
  }

  @Transactional(readOnly = true)
  public List<Group> findAll() {
    return groupsDao.findAll();
  }

  @Transactional(readOnly = true)
  public List<Group> findAll(Iterable<Long> ids) {
    return groupsDao.findAll(ids);
  }

  @Transactional(readOnly = true)
  public Group getOne(Long id) {
    LOGGER.info("Get group by id: {}", id);
    return groupsDao.getOne(id);
  }
}
