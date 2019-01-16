/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.model.User;

/**
 *
 * @author giorgoskoz
 */
public interface RestrictedUserOperationsInterface {
    
    public void banCheck(User user)  throws MessengerException;
    public void mainMenu()  throws MessengerException;
    public void readOwnMessages() throws MessengerException;
    
}
