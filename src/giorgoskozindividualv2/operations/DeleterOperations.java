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
import giorgoskozindividualv2.operations.interfaces.DeleterOperationsInterface;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.View;

/**
 *
 * @author giorgoskoz
 */
public class DeleterOperations extends EditorOperations implements DeleterOperationsInterface {

    public DeleterOperations() {
    }

    public DeleterOperations(User user, UserDAO udao, MessageDAO mdao, View view) {
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
    public void deleteOtherUserMessage() throws MessengerException {
        readAllMessages();
        this.getView().displayMessaDeletionPrompt();
        this.getView().displayMessaDeletionPrompt();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        Message messageToDelete = new Message();
        try {
            messageToDelete = this.getMdao().getMessageById(userChoice);
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        int rowsAffected = 0;
        rowsAffected = this.getMdao().softDeleteMessageByModerator(messageToDelete);
        if (rowsAffected != 0) {
            this.getView().displayMessageDeletionConfirmation();
        }else{
            this.getView().displayMessageDeletionFailure();
        }
    }
    
    @Override
    public void userChoiceDispacher(int userChoice) throws MessengerException {
        super.userChoiceDispacher(userChoice);
        switch(userChoice){
            case 9:
                deleteOtherUserMessage();
                mainMenu();
                break;
        }
    }
    
    @Override
    boolean isAvailable(int userChoice){
        boolean isAvailable = false;
        for (int i = 1; i < 10; i++) {
            if (userChoice == i) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

}
