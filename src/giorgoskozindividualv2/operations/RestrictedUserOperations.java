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
import giorgoskozindividualv2.model.BannedEnum;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.RestrictedUserOperationsInterface;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.EngUI;
import giorgoskozindividualv2.view.UI;
import giorgoskozindividualv2.view.View;
import java.util.ArrayList;
import java.util.Iterator;
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
    public void banCheck(){
        if (user.getBanStatus() == BannedEnum.BANNED) {
            view.displayYouAreBanned();
            System.exit(0);
        }
    }
    
    @Override
    public void mainMenu() throws MessengerException {
        banCheck();
        int userChoice = 0;
        userChoice = userDisplayMenuAndChoiceInputAndCheck(user);
        if (userChoice != 1 && userChoice != 2) {
            view.displayInvalidOption();
            mainMenu();
        }else{
            userChoiceDispacher(userChoice);
        }
    }
    
    @Override
    public void readOwnMessages() throws MessengerException {
            List<Message> messages = mdao.getMessagesOfUser(user);
            messages = filterOutDeletedMessages(user, messages);
            view.displayOwnMessagesIntro();
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
    
    public List<Message> filterOutDeletedMessages(User user, List<Message> messages) {
        List<Message> nonDeletedMessages = new ArrayList<Message>();
        for (Message message : messages) {
            if ((user.getId() == message.getSender().getId()) && (message.getDeletedBySender() == 0)) {
                nonDeletedMessages.add(message);
            } else if ((user.getId() == message.getReceiver().getId()) && (message.getDeletedByReceiver() == 0)) {
                nonDeletedMessages.add(message);
            }
        }
        return nonDeletedMessages;
    }
    
    public void userChoiceDispacher(int userChoice) throws MessengerException {
        switch(userChoice){
            case 1:
                view.displayGoodbye();
                System.exit(0);
            case 2:
                readOwnMessages();
                mainMenu();
                break;
            }
        
    }
    
    int userDisplayMenuAndChoiceInputAndCheck(User user) throws MessengerException {
        int userChoice = 0;
        banCheck();
        menuDisplayDispacher(user);
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            view.displayInvalidOption();
            mainMenu();
        }
        return userChoice;
    }
    
    void menuDisplayDispacher(User user){
        switch (user.getRole()) {
            case RESTRICTED_USER:
                view.displayRestrictedUserMenu();
                break;
            case REGULAR_USER:
                view.displayRegularUserMenu();
                break;
            case VIEWER:
                view.displayViewerMenu();
                break;
            case EDITOR:
                view.displayEditorMenu();
                break;
            case DELETER:
                view.displayDeleterMenu();
                break;
            case SUPER_ADMIN:
                view.displaySuperAdminMenu();
                break;
        }
    }
    
    
}
