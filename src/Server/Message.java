package Server;

import common.Utils;

public class Message {
    private String sender;
    private String content;
    private String timestamp;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = Utils.getFormattedCurrentTime();
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String serialize() {

        return String.format("[%s] %s: %s", timestamp, sender, content);
    }

}
