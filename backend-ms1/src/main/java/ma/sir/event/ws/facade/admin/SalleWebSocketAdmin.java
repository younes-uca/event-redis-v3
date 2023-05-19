/*

package ma.sir.event.ws.facade.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.net.http.websocket.WebSocketRequest;
import ma.sir.event.bean.core.Salle;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.ws.converter.SalleConverter;
import ma.sir.event.ws.dto.SalleDto;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ServerEndpoint("/api/admin/salle/")
public class SalleWebSocketAdmin {

    @Autowired
    private SalleAdminService salleAdminService;

    @Autowired
    private SalleConverter salleConverter;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        WebSocketMessage webSocketMessage = objectMapper.readValue(payload, WebSocketMessage.class);

        switch (webSocketMessage.getType()) {
            case "findAll":
                List<Salle> salles = salleAdminService.findAllOptimized();
                List<SalleDto> salleDtos = salles.stream().map(salleConverter::toDto).collect(Collectors.toList());
                WebSocketMessage responseMessage = new WebSocketMessage("findAllResponse", salleDtos);
                session.sendMessage(new TextMessage(objectMapper.writeValueAsString(responseMessage)));
                break;
            // Handle other message types here...
            default:
                // Handle unknown message types here...
        }
    }

}

*/
