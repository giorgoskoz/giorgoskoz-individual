/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.RestrictedUserOperationsInterface;
import giorgoskozindividualv2.view.EngUI;
import giorgoskozindividualv2.view.UI;
import java.util.ArrayList;

/**
 *
 * @author giorgoskoz
 */
public class RestrictedUserOperations implements RestrictedUserOperationsInterface {
    
    private User user;
    private Dao dao;
    private UI ui;

    public RestrictedUserOperations() {
    }

    public RestrictedUserOperations(User user, Dao dao, UI ui) {
        this.user = user;
        this.dao = dao;
        this.ui = ui;
    }
    
    @Override
    public void readOwnMessages() {
        ArrayList<Message> messages = dao.fetchUserMessages(user);
        for (Message message : messages) {
            System.out.println(ui.getPromptId() + message.getMessageId() + 
            ui.getPromptDate() + message.getDate() + ui.getPromptSender() +
            dao.fetchUsernameByUserId(message.getSenderId()) + ui.getPromptReceiver() + 
            dao.fetchUsernameByUserId(message.getReceiverId()) + "\n" + message.getContent());
        }
    }

    public User getUser() {
        return user;
    }
    
}
