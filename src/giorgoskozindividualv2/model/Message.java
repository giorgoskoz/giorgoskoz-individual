/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author giorgoskoz
 */
public class Message {
    
    private int messageId;
    private Timestamp dateSent;
    private User sender;
    private User receiver;
    private String content;
    private int deletedBySender;
    private int deletedByReceiver;

    public Message() {
    }

    public Message(int messageId, Timestamp dateSent, User sender, User receiver, String content, int deletedBySender, int deletedByReceiver) {
        this.messageId = messageId;
        this.dateSent = dateSent;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.deletedBySender = deletedBySender;
        this.deletedByReceiver = deletedByReceiver;
    }
    
    @Override
    public String toString() {
        return "Message id: " + messageId + "  |  Date Sent: " + dateSent + "  |  Sender:" + sender.getUsername() + "  |  Receiver: " + receiver.getUsername() + "\n" + content + "\n";
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Timestamp getDateSent() {
        return dateSent;
    }

    public void setDateSent(Timestamp dateSent) {
        this.dateSent = dateSent;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDeletedBySender() {
        return deletedBySender;
    }

    public void setDeletedBySender(int deletedBySender) {
        this.deletedBySender = deletedBySender;
    }

    public int getDeletedByReceiver() {
        return deletedByReceiver;
    }

    public void setDeletedByReceiver(int deletedByReceiver) {
        this.deletedByReceiver = deletedByReceiver;
    }
    
    
    
}
