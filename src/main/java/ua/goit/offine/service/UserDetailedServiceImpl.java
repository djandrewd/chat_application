package ua.goit.offine.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.goit.offine.entity.Group;

/**
 * Get information about user from repository.
 *
 * @author Andrey Minov
 */
public class UserDetailedServiceImpl implements UserDetailsService {

  private final UserService userService;

  public UserDetailedServiceImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ua.goit.offine.entity.User user = userService.getById(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not exists!");
    }

    String[] roles = user.getGroups()
                         .stream()
                         .map(Group::getRole)
                         .map(Enum::name)
                         .toArray(String[]::new);
    return User.withUsername(user.getUsername())
               .password(user.getPassword())
               .roles(roles)
               .build();
  }
}
