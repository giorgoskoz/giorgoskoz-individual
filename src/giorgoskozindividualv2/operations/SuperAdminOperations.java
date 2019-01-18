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
import giorgoskozindividualv2.operations.interfaces.SuperAdminOperationsInterface;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class SuperAdminOperations extends DeleterOperations implements SuperAdminOperationsInterface {

    public SuperAdminOperations() {
    }

    public SuperAdminOperations(User user, UserDAO udao, MessageDAO mdao, View view) {
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
    public void createUser() throws MessengerException {
        this.getView().displayUsernamePrompt();
        String username = Utils.readInputString();
        this.getView().displayPasswordPrompt();
        String password = Utils.readInputString();
        this.getView().displayRoleIdPrompt();
        int roleId = Utils.readInputInt();
        int affectedRows = 0;
        affectedRows = this.getUdao().createUser(username, password, roleId);
        if (affectedRows != 0) {
            this.getView().displayPromptSuccess();
        }else{
            this.getView().displayPromptFailed();
        }
    }

    @Override
    public void editUserUsername() throws MessengerException {
        this.showAllUsers();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        this.getView().displayUsernamePrompt();
        String username = Utils.readInputString();
        int affectedRows = 0;
        affectedRows = this.getUdao().updateUserUsername(username, userChoice);
        if (affectedRows != 0) {
            this.getView().displayPromptSuccess();
        }else{
            this.getView().displayPromptFailed();
        }
    }

    @Override
    public void editUserPassword() throws MessengerException {
        this.showAllUsers();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        this.getView().displayPasswordPrompt();
        String password = Utils.readInputString();
        int affectedRows = 0;
        affectedRows = this.getUdao().updateUserPassword(password, userChoice);
        if (affectedRows != 0) {
            this.getView().displayPromptSuccess();
        }else{
            this.getView().displayPromptFailed();
        }
    }

    @Override
    public void changeUserRole() throws MessengerException {
        this.showAllUsers();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        this.getView().displayRoleIdPrompt();
        int roleId = Utils.readInputInt();
        int affectedRows = 0;
        affectedRows = this.getUdao().updateUserRole(roleId, roleId);
        if (affectedRows != 0) {
            this.getView().displayPromptSuccess();
        }else{
            this.getView().displayPromptFailed();
        }
    }

    @Override
    public void deleteUser() throws MessengerException {
        this.showAllUsers();
        this.getView().displayDeleteUserWarning();
        int userChoice = 0;
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            this.getView().displayInvalidOption();
            mainMenu();
        }
        int affectedRows = 0;
        affectedRows = this.getUdao().deleteUser(userChoice);
        if (affectedRows != 0) {
            this.getView().displayPromptSuccess();
        }else{
            this.getView().displayPromptFailed();
        }
    }

    @Override
    public void readArchivedMessages() throws MessengerException {
        this.getView().displayArchivedMessagesIntro();
        List<Message> messages = this.getMdao().getAllMessages();
        messages = filterOutArchivedMessages(messages);
        this.getView().displayMessages(messages);
    }
    
    public List<Message> filterOutArchivedMessages(List<Message> messages) {
        List<Message> archivedMessages = new ArrayList<Message>();
        for (Message message : messages) {
            if ((message.getDeletedByReceiver() == 0) && (message.getDeletedBySender() == 0)) {
                archivedMessages.add(message);
            }
        }
        return archivedMessages;
    }

//    @Override
//    public void showBannedUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void banUser() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void unBanUser() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    @Override
    public void userChoiceDispacher(int userChoice) throws MessengerException {
        super.userChoiceDispacher(userChoice);
        switch(userChoice){
            case 10:
                createUser();
                mainMenu();
                break;
            case 11:
                editUserUsername();
                mainMenu();
                break;
            case 12:
                editUserPassword();
                mainMenu();
                break;
            case 13:
                changeUserRole();
                mainMenu();
                break;
            case 14:
                deleteUser();
                mainMenu();
                break;
            case 15:
                readArchivedMessages();
                mainMenu();
                break;
        }
    }
    
    @Override
    boolean isAvailable(int userChoice){
        boolean isAvailable = false;
        for (int i = 1; i < 16; i++) {
            if (userChoice == i) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
    
}
