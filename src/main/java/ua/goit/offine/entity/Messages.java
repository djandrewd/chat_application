package ua.goit.offine.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Messages entity
 */
@Entity
@Table(name = "messages")
public class Messages {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String text;
  @Column(insertable = false)
  private Timestamp time;

  @ManyToOne
  private User user;
  @ManyToOne
  @JoinColumn(name = "NAME")
  private Chat chat;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Chat getChat() {
    return chat;
  }

  public void setChat(Chat chat) {
    this.chat = chat;
  }
}
