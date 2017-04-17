package server;

public abstract class MessageAbs {
    private final String messageTitle;
    private final Object messageContent;
    private final ServerThread client;
    
    MessageAbs(String messageTitle, Object messageContent, ServerThread client) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.client = client;
    }
    
    public String getMessageTitle(){
            return messageTitle;
    }
    public Object getMessageContent(){
        return messageContent;
    }
    
    ServerThread getMessageSender(){
        return client;
    }
    public int getMessageSenderID() {
        return client.getClientID();
    }
}
