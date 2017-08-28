package ua.goit.offine.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ua.goit.offine.entity.Messages;

/**
 * WebSocket chat message controller.
 *
 * @author Andrey Minov
 */
@Component
public class ChatMessageController extends TextWebSocketHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(ChatMessageController.class);

  private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
  private Gson gson = new Gson();

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
    Messages messages = new Messages();
    messages.setText(message.getPayload());

    // TODO: Set user and all data
    // TODO: Save message

    String json = gson.toJson(messages);
    for (WebSocketSession ws : sessions.values()) {
      ws.sendMessage(new TextMessage(json));
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    LOGGER.info("Close connection: {}", session);
    sessions.remove(session.getId(), session);

  }
}
