/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;
import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.EditorOperationsInterface;
import giorgoskozindividualv2.utils.FileLogger;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.View;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class EditorOperations extends ViewerOperations implements EditorOperationsInterface {

    public EditorOperations() {
    }

    public EditorOperations(User user, UserDAO udao, MessageDAO mdao, View view) {
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
    public void editOtherUserMessage() throws MessengerException {
        readAllMessages();
        this.getView().displayEditOtherUserMessageIntro();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        Message messageToEdit = new Message();
        try {
            messageToEdit = this.getMdao().getMessageById(userChoice);
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        this.getView().displayEditMessagePrompt();
        String newContent = Utils.readInputStringLine();
        int linesAffected = this.getMdao().editMessage(messageToEdit, newContent);
        if (linesAffected != 0) {
            this.getView().displayEditMessageSuccess();
            FileLogger.writeToFile(messageToEdit, newContent);
        }
        
    }
    
    @Override
    public void userChoiceDispacher(int userChoice) throws MessengerException {
        super.userChoiceDispacher(userChoice);
        switch(userChoice){
            case 8:
                editOtherUserMessage();
                mainMenu();
                break;
        }
    }
    
    @Override
    boolean isAvailable(int userChoice){
        boolean isAvailable = false;
        for (int i = 1; i < 9; i++) {
            if (userChoice == i) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
    
    
    
}
