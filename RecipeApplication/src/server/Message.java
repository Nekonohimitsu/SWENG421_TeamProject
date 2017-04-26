package server;

public class Message extends SendableMessageAbs implements SendableMessage {

    public Message(String messageTitle, Object messageContent, ServerThread client) {
        super(messageTitle, messageContent, client);
    }
    public Message(String messageTitle, Object messageContent) {
        super(messageTitle, messageContent);
    }
}
