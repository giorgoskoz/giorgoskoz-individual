/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.db.jdbc.DatabaseHelper;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.RegularUserOperationsInterface;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.View;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class RegularUserOperations extends RestrictedUserOperations implements RegularUserOperationsInterface {

    public RegularUserOperations() {
    }

    public RegularUserOperations(User user, UserDAO udao, MessageDAO mdao, View view) {
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
    public void sendMessage() throws MessengerException {
        this.showAllUsers();
        this.getView().displayChooseUserToMessagePrompt();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        User receiver = new User();
        try {
            receiver = this.getUdao().getUserById(userChoice);
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        
        this.getView().displayInputMessagePrompt();
        String content = Utils.readInputStringLine();
        Date date = new Date();
        long now = date.getTime();
        Timestamp dateSent = new Timestamp(now);
        Message messageSent = this.getMdao().create(dateSent, this.getUser(), receiver, content);
        //file write here
        this.getView().displayMessageSentSuccess();
        mainMenu();
    }

    @Override
    public void deleteOwnMessage() throws MessengerException {
        this.readOwnMessages();
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
        if (this.getUser().equals(messageToDelete.getSender())) {
            this.getMdao().softDeleteMessageBySender(messageToDelete);
        }else if (this.getUser().equals(messageToDelete.getReceiver())) {
            this.getMdao().softDeleteMessageByReceiver(messageToDelete);
        }else{
            this.getView().displayInvalidOption();
            mainMenu();
        }
        this.getView().displayMessageDeletionConfirmation();
        mainMenu();
    }

    @Override
    public void showAllUsers() throws MessengerException {
        this.getView().displayUsers(this.getUdao().getAllUserIdsAndUsernames());
    }
    
    @Override
    public void userChoiceDispacher(int userChoice) throws MessengerException {
        super.userChoiceDispacher(userChoice);
        switch(userChoice){
            case 3:
                sendMessage();
                break;
            case 4:
                deleteOwnMessage();
                break;
            case 5:
                showAllUsers();
                mainMenu();
                break;
        }
    }
    
    boolean isAvailable(int userChoice){
        boolean isAvailable = false;
        for (int i = 1; i < 6; i++) {
            if (userChoice == i) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
    
    
}
