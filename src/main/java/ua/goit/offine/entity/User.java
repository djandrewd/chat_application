package ua.goit.offine.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
  @JoinTable(name = "user_groups",
             joinColumns = @JoinColumn(name = "user_login"),
             inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<Group> groups;

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

  public Set<Group> getGroups() {
    return groups;
  }

  public void setGroups(Set<Group> groups) {
    this.groups = groups;
  }


  @Override
  public String toString() {
    return "User{" + "login='" + login + '\'' + ", username='" + username + '\'' + ", password='"
           + password + '\'' + ", registrationDate=" + registrationDate + '}';
  }
}
