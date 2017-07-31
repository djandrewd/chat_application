package ua.goit.offine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBValidator implements Validator {

  @Autowired
  private WordsDao wordsDao;

  @Override
  public boolean isValid(String message) {
    return !wordsDao.isBadWord(message);
  }
}
