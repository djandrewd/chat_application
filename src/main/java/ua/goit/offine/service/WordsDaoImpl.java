package ua.goit.offine.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class WordsDaoImpl implements WordsDao {

  private static final List<String> WORDS =
      Arrays.asList("A", "B");

  @Override
  public boolean isBadWord(String name) {
    return WORDS.contains(name);
  }
}
