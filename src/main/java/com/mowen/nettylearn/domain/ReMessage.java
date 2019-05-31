package com.mowen.nettylearn.domain;

import java.io.Serializable;
import java.util.Objects;

/***
 * desc  : com.mowen.nettylearn.domain
 * author: mowen
 * create_time: 2019/5/31 9:24
 * project_name : mowen_parent
 */
public class ReMessage implements Serializable {

    private String messageId;

    private String command;

    private String content;

    private String fromUser;

    private String toUser;

    public ReMessage(){}

    public ReMessage(String command, String content){
        this.command = command;
        this.content = content;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReMessage reMessage = (ReMessage) o;
        return Objects.equals(getMessageId(), reMessage.getMessageId()) &&
            Objects.equals(getCommand(), reMessage.getCommand()) &&
            Objects.equals(getContent(), reMessage.getContent()) &&
            Objects.equals(getFromUser(), reMessage.getFromUser()) &&
            Objects.equals(getToUser(), reMessage.getToUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessageId(), getCommand(), getContent(), getFromUser(), getToUser());
    }

    @Override
    public String toString() {
        return "ReMessage{" +
            "command='" + command + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
