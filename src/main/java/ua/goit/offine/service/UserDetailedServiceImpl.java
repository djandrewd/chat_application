package ua.goit.offine.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    return null;
  }
}
