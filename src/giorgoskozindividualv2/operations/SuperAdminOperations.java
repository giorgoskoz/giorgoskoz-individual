/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.interfaces.SuperAdminOperationsInterface;
import giorgoskozindividualv2.view.View;

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
    public void createUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editUserUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editUserPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeUserRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readArchivedMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showBannedUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void banUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unBanUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
            case 16:
                showBannedUsers();
                mainMenu();
                break;
            case 17:
                banUser();
                mainMenu();
                break;
            case 18:
                unBanUser();
                mainMenu();
                break;
        }
    }
    
    @Override
    boolean isAvailable(int userChoice){
        boolean isAvailable = false;
        for (int i = 1; i < 19; i++) {
            if (userChoice == i) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
    
}
