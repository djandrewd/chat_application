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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ChatMessage that = (ChatMessage) o;

    if (id != that.id) {
      return false;
    }
    if (text != null ? !text.equals(that.text) : that.text != null) {
      return false;
    }
    if (chat != null ? !chat.equals(that.chat) : that.chat != null) {
      return false;
    }
    return user != null ? user.equals(that.user) : that.user == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (text != null ? text.hashCode() : 0);
    result = 31 * result + (chat != null ? chat.hashCode() : 0);
    result = 31 * result + (user != null ? user.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ChatMessage{" + "id=" + id + ", text='" + text + '\'' + ", user='" + user + '\'' + '}';
  }
}
