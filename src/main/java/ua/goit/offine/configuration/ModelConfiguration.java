package ua.goit.offine.configuration;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"ua.goit.offine.dao", "ua.goit.offine.service"})
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class ModelConfiguration {

  @Value("${db.url}")
  private String url;
  @Value("${db.username}")
  private String username;
  @Value("${db.password}")
  private String password;
  @Value("${db.driver}")
  private String driverClassname;
  @Value("${db.dialect}")
  private String dialect;

  @Bean(destroyMethod = "close")
  public BasicDataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setDriverClassName(driverClassname);
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
    // Set database connections
    bean.setDataSource(dataSource);
    // Set where to scan @Table and @Entity
    bean.setPackagesToScan("ua.goit.offine.entity");
    // Set hibernate properties
    Properties properties = new Properties();
    properties.put("hibernate.dialect", dialect);
    bean.setHibernateProperties(properties);
    //
    return bean;
  }

  @Bean
  public HibernateTransactionManager transactionManager
      (SessionFactory sessionFactory) {
    return new HibernateTransactionManager(sessionFactory);
  }
}
