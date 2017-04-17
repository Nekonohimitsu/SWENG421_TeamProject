package server;

public class Message extends MessageAbs{
     Message(String messageTitle, Object messageContent, ServerThread client) {
         super(messageTitle, messageContent, client);
     }
}
