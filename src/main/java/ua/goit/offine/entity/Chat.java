package ua.goit.offine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chat entity
 */
@Entity
@Table(name = "chats")
public class Chat {
  @Id
  private String name;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Chat{" + "name='" + name + '\'' + ", description='" + description + '\'' + '}';
  }
}
