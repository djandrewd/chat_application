package ua.goit.offine.dao;

import java.util.List;

import ua.goit.offine.entity.Messages;

/**
 * Data access object for {@link ua.goit.offine.entity.Messages}
 */
public interface MessageDao extends GenericDao<Long, Messages> {
  List<Messages> getTopById(long n);
}
