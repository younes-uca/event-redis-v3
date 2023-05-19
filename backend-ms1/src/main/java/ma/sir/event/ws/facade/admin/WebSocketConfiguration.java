/*
package ma.sir.event.ws.facade.admin;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {


    class WebSocketHandler extends TextWebSocketHandler {
        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message)
                throws IOException {
            String payload = message.getPayload();
            session.sendMessage(new TextMessage("Received: " + payload));
        }
    }
}
*/
