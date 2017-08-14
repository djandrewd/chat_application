package ua.goit.offine.applications;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ua.goit.offine.configuration.ModelConfiguration;
import ua.goit.offine.configuration.MvcConfiguration;
import ua.goit.offine.configuration.SecurityConfiguration;

/**
 * Main application entry.
 *
 * @author Andrey Minov
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {ModelConfiguration.class, SecurityConfiguration.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {MvcConfiguration.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
