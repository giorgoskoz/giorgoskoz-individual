/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.RestrictedUserOperationsInterface;
import giorgoskozindividualv2.view.EngUI;
import giorgoskozindividualv2.view.UI;
import giorgoskozindividualv2.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giorgoskoz
 */
public class RestrictedUserOperations implements RestrictedUserOperationsInterface {
    
    private User user;
    private UserDAO udao;
    private MessageDAO mdao;
    private View view;

    public RestrictedUserOperations() {
    }

    public RestrictedUserOperations(User user, UserDAO udao, MessageDAO mdao, View view) {
        this.user = user;
        this.udao = udao;
        this.mdao = mdao;
        this.view = view;
    }
    
    @Override
    public void readOwnMessages() throws MessengerException {
            List<Message> messages = mdao.getMessagesOfUser(user);
            view.displayMessages(messages);
    }

    public User getUser() {
        return user;
    }

    public UserDAO getUdao() {
        return udao;
    }

    public MessageDAO getMdao() {
        return mdao;
    }

    public View getView() {
        return view;
    }
    
    
}
