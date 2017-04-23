package server;

abstract class SendableMessageAbs implements SendableMessage {

    private final String messageTitle;
    private final Object messageContent;
    private final int clientID;

    SendableMessageAbs(String messageTitle, Object messageContent, ServerThread client) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.clientID = client.getClientID();
    }
    
    SendableMessageAbs(String messageTitle, Object messageContent) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.clientID = -1;
    }

    @Override
    public String getMessageTitle() {
        return messageTitle;
    }

    @Override
    public Object getMessageContent() {
        return messageContent;
    }

    @Override
    public int getMessageSenderID() {
        return clientID;
    }
}
