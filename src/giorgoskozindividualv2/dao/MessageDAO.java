/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.dao;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public interface MessageDAO {
    
    Message create (Timestamp dateSent, User sender, User receiver, String content) throws MessengerException;
    
    void update(Message msg) throws MessengerException;
    
    void delete(Message msg) throws MessengerException;
    
    Message getMessageById(int id) throws MessengerException;
    
    List<Message> getAllMessages() throws MessengerException;
    
    List<Message> getMessagesSentBy(User sender) throws MessengerException;
    
    List<Message> getMessagesSentTo(User receiver) throws MessengerException;
    
    List<Message> getMessagesOfUser(User senderOrReceiver) throws MessengerException;
    
    List<Message> getMessagesOfUserExceptDeleted(User senderOrReceiver) throws MessengerException;
    
    void softDeleteMessageBySender(Message msg);
    
    void softDeleteMessageByReceiver(Message msg);
    
    int softDeleteMessageByModerator(Message msg);
    
    int editMessage(Message message, String newContent);
    
}
