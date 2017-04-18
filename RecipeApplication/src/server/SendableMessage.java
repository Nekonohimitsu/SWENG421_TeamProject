package server;

import java.io.Serializable;

public interface SendableMessage extends Serializable {

    int getMessageSenderID();

    Object getMessageContent();

    String getMessageTitle();
}
