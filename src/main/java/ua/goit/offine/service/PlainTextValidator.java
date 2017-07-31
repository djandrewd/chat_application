package ua.goit.offine.service;

import org.springframework.stereotype.Component;

@Component
public class PlainTextValidator implements Validator {

  // [a-zA-Z0-9_]
  private String checkPattern = "\\w+";

  @Override
  public boolean isValid(String message) {
    return message.matches(checkPattern);
  }
}
