package ua.goit.offine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.offine.entity.User;
import ua.goit.offine.service.GroupsService;
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
  private final GroupsService groupsService;

  @Autowired
  public RegistrationController(UserService userService, GroupsService groupsService) {
    this.userService = userService;
    this.groupsService = groupsService;
  }

  @GetMapping
  public ModelAndView getRegistrationPage() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("registration");
    modelAndView.addObject("groups", groupsService.findAll());
    return modelAndView;
  }

  @PostMapping
  public String registerUser(@ModelAttribute("user") User user) {
    userService.save(user);
    return "redirect:/login";
  }
}
