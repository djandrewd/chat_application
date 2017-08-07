package ua.goit.offine.validators;

import org.springframework.stereotype.Component;

@Component
public class PlainTextValidator implements Validator {

  // [a-zA-Z0-9_]
  private String checkPattern = "\\w+";

  public PlainTextValidator(String checkPattern) {
    this.checkPattern = checkPattern;
  }

  private void call() {
    Runnable r = () -> {};
    r.run();
  }

  @Override
  public boolean isValid(String message) {
    return message.matches(checkPattern);
  }
}
