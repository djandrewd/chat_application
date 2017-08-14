package ua.goit.offine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.goit.offine.configuration.ModelConfiguration;
import ua.goit.offine.entity.User;
import ua.goit.offine.service.UserService;

public class TestChatApplication {
  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ModelConfiguration.class)) {

      UserService userService = context.getBean(UserService.class);
      User user = userService.getById("test");

      if (user == null) {
        user = new User();
        user.setLogin("test");
        user.setPassword("test");
        user.setUsername("Test user!");
        userService.save(user);
      }

      System.out.println(userService.getAll());
      userService.remove(user);
      System.out.println(userService.getAll());
    }
  }
}
