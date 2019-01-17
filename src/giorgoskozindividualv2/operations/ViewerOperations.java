/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.ViewerOperationsInterface;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.View;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class ViewerOperations extends RegularUserOperations implements ViewerOperationsInterface {

    public ViewerOperations() {
    }

    public ViewerOperations(User user, UserDAO udao, MessageDAO mdao, View view) {
        super(user, udao, mdao, view);
    }
    
    @Override
    public void mainMenu() throws MessengerException {
        banCheck();
        int userChoice = 0;
        userChoice = userDisplayMenuAndChoiceInputAndCheck(this.getUser());
        if (!isAvailable(userChoice)) {
            this.getView().displayInvalidOption();
            mainMenu();
        }else{
            userChoiceDispacher(userChoice);
        }
    }

    @Override
    public void readOtherUserMessages() throws MessengerException {
        showAllUsers();
        this.getView().displayReadOtherUserMessagesIntro();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        User user = new User();
        try {
            user = this.getUdao().getUserById(userChoice);
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        List<Message> messages = this.getMdao().getMessagesOfUser(user);
        this.getView().displayMessages(messages);
        mainMenu();
    }

    @Override
    public void readAllMessages() throws MessengerException {
        this.getView().displayReadAllMessagesIntro();
        List<Message> messages = this.getMdao().getAllMessages();
        this.getView().displayMessages(messages);
        mainMenu();
    }
    
    @Override
    public void userChoiceDispacher(int userChoice) throws MessengerException {
        super.userChoiceDispacher(userChoice);
        switch(userChoice){
            case 6:
                readOtherUserMessages();
                break;
            case 7:
                readAllMessages();
                break;
        }
    }
    
    @Override
    boolean isAvailable(int userChoice){
        boolean isAvailable = false;
        for (int i = 1; i < 8; i++) {
            if (userChoice == i) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
    
}
