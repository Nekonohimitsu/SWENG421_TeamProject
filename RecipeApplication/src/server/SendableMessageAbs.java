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

    public String getMessageTitle() {
        return messageTitle;
    }

    public Object getMessageContent() {
        return messageContent;
    }

    public int getMessageSenderID() {
        return clientID;
    }
}
