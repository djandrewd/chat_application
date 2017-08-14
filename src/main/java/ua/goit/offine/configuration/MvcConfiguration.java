package ua.goit.offine.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration for MVC security.
 *
 * @author Andrey Minov
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration
    extends WebMvcConfigurerAdapter {

}
