package ua.goit.offine.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity
 *
 * @author Andrey Minov
 */
@Entity
@Table(name = "users")
public class User {
  @Id
  private String login;
  private String username;
  private String password;
  @Column(name = "REGISTRATION_DATE")
  private Timestamp registrationDate;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Timestamp getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Timestamp registrationDate) {
    this.registrationDate = registrationDate;
  }

  @Override
  public String toString() {
    return "User{" + "login='" + login + '\'' + ", username='" + username + '\'' + ", password='"
           + password + '\'' + ", registrationDate=" + registrationDate + '}';
  }
}
