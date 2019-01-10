/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author giorgoskoz
 */
public class Message {
    
    private int messageId;
    private Timestamp date;
    private int senderId;
    private int receiverId;
    private String content;
    private int deletedBySender;
    private int deletedByReceiver;

    public Message() {
    }

    public Message(int messageId, Timestamp date, int senderId, int receiverId, String content, int deletedBySender, int deletedByReceiver) {
        this.messageId = messageId;
        this.date = date;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.deletedBySender = deletedBySender;
        this.deletedByReceiver = deletedByReceiver;
    }
    
    @Override
    public String toString() {
        return "Message id: " + messageId + "  |  Date Sent: " + date + "  |  Sender:" + senderId + "  |  Receiver: " + receiverId + "\n" + content + "\n";
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
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
