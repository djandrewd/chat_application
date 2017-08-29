package ua.goit.offine.entity;

/**
 * Value send by client to chat. Introduced to avoid using JPA entities in the client.
 *
 * @author Andrey Minov
 */
public class ChatMessage {
  private long id;
  private String text;
  private String chat;
  private String user;

  public ChatMessage(long id, String text, String chat, String user) {
    this.id = id;
    this.text = text;
    this.chat = chat;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public String getUser() {
    return user;
  }

  public String getChat() {
    return chat;
  }

  @Override
  public String toString() {
    return "ChatMessage{" + "id=" + id + ", text='" + text + '\'' + ", user='" + user + '\'' + '}';
  }
}
