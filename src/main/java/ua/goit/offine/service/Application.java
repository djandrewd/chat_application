package ua.goit.offine.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext
            (ApplicationConfiguration.class);
    MainValidator validator =
        applicationContext.getBean(MainValidator.class);

    System.out.println(validator.isValid("hello"));
    System.out.println(validator.isValid("A"));
    System.out.println(validator.isValid("{}{"));

  }
}
