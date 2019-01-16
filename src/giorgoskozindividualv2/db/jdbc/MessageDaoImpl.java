/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.db.jdbc;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class MessageDaoImpl implements MessageDAO {
    
    @Override
    public Message create(User sender, User receiver, String text) throws MessengerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Message msg) throws MessengerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Message msg) throws MessengerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getMessageById(int id) throws MessengerException {
        Message msg = DatabaseHelper.fetchMessageOrNull("select * from message where id = ?", id);
        if (msg == null) {
            throw new RuntimeException("Invalid message id: " + id);
        }
        return msg;
    }

    @Override
    public List<Message> getAllMessages() throws MessengerException {
        return DatabaseHelper.fetchMessages("select * from messages");
    }

    @Override
    public List<Message> getMessagesSentBy(User sender) throws MessengerException {
        return DatabaseHelper.fetchMessages("select * from messages where sender_id = ?", sender.getId());
    }

    @Override
    public List<Message> getMessagesSentTo(User receiver) throws MessengerException {
        return DatabaseHelper.fetchMessages("select * from messages where receiver_id = ?", receiver.getId());
    }

    @Override
    public List<Message> getMessagesOfUser(User senderOrReceiver) throws MessengerException {
        int id = senderOrReceiver.getId();
        return DatabaseHelper.fetchMessages("select * from messages where sender_id = ? or receiver_id = ?", id, id);
    }
    
}
