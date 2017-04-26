package server;

public class Message extends SendableMessageAbs implements SendableMessage {

    Message(String messageTitle, Object messageContent, ServerThread client) {
        super(messageTitle, messageContent, client);
    }
}
