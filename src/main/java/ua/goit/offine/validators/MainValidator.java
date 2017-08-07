package ua.goit.offine.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainValidator {

  @Autowired
  private List<Validator> validators;

  public boolean isValid(String message) {
    return validators
        .stream()
        .allMatch(v -> v.isValid(message));
  }
}
