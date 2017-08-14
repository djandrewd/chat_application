package ua.goit.offine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.offine.service.UserDetailedServiceImpl;
import ua.goit.offine.service.UserService;

/**
 * Spring web security configuration.
 *
 * @author Andrey Minov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends
    WebSecurityConfigurerAdapter {

  @Bean
  public UserDetailsService userDetailsService(UserService userService) {
    return new UserDetailedServiceImpl(userService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
             .anyRequest()
             .authenticated()
         .and()
         .formLogin();
  }
}
