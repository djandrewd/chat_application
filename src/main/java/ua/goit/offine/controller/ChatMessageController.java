package ua.goit.offine.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ua.goit.offine.entity.Chat;
import ua.goit.offine.entity.ChatMessage;
import ua.goit.offine.entity.Messages;
import ua.goit.offine.entity.User;
import ua.goit.offine.service.MessagesService;

/**
 * WebSocket chat message controller.
 *
 * @author Andrey Minov
 */
@Component
public class ChatMessageController extends TextWebSocketHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(ChatMessageController.class);

  private final MessagesService messagesService;
  private final Map<String, WebSocketSession> sessions;
  private final Gson gson;

  @Autowired
  public ChatMessageController(MessagesService messagesService) {
    this.messagesService = messagesService;
    sessions = new ConcurrentHashMap<>();
    gson = new Gson();
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    LOGGER.info("Established new connection: {}", session);
    ////
    //session.getId()
    // (UserDetails) session.getPrincipal()
    sessions.put(session.getId(), session);
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    LOGGER.info("Received new message from client {}", message);
    try {
      ChatMessage chatMessage = gson.fromJson(message.getPayload(), ChatMessage.class);

      Messages messages = new Messages();
      messages.setText(chatMessage.getText());

      Authentication authentication = (Authentication) session.getPrincipal();
      User user = (User) authentication.getPrincipal();
      messages.setUser(user);

      Chat chat = new Chat();
      chat.setName(chatMessage.getChat());
      messages.setChat(chat);

      chatMessage = messagesService.save(messages);
      LOGGER.debug("Saved chat message {}", chatMessage);

      String json = gson.toJson(chatMessage);

      for (WebSocketSession ws : sessions.values()) {
        try {
          if (ws.isOpen()) {
            ws.sendMessage(new TextMessage(json));
          }
        } catch (Exception e) {
          LOGGER.warn(String.format("Unable to send message %s to session %s", message.getPayload(),
              session.getId()), e);
        }
      }
    } catch (Exception e) {
      LOGGER.warn(String.format("Unable to process chat request : %s", message.getPayload()), e);
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    LOGGER.info("Close connection: {}", session);
    sessions.remove(session.getId(), session);

  }
}
