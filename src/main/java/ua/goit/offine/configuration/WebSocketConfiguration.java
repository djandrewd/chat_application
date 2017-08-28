package ua.goit.offine.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ua.goit.offine.controller.ChatMessageController;

/**
 * Configuration for web sockets.
 *
 * @author andreymi
 */
@Configuration
@EnableWebSocket
@ComponentScan("ua.goit.offine.controller")
public class WebSocketConfiguration
    implements WebSocketConfigurer {

  @Autowired
  private ChatMessageController messageController;

  @Override
  public void registerWebSocketHandlers(
      WebSocketHandlerRegistry registry) {
    registry.addHandler(messageController, "/chat");
  }
}
