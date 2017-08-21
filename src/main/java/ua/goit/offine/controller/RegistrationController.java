package ua.goit.offine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.offine.entity.User;
import ua.goit.offine.service.UserService;

/**
 * Controller for registering users.
 *
 * @author Andrey Minov
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

  private final UserService userService;

  @Autowired
  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public String registerUser(@ModelAttribute("user") User user) {
      userService.save(user);
      return "redirect:/login";
  }
}
