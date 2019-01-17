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
import giorgoskozindividualv2.operations.interfaces.RegularUserOperationsInterface;
import giorgoskozindividualv2.view.View;
import java.util.ArrayList;
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
    public Message sendMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteOwnMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsers() throws MessengerException {
        return this.getUdao().getAllUsers();
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
                getAllUsers();
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
