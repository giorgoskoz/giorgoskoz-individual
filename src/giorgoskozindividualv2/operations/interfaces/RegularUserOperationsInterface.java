/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public interface RegularUserOperationsInterface extends RestrictedUserOperationsInterface {
    
    public Message sendMessage();
    
    public int deleteOwnMessage();
    
    public List<User> getAllUsers() throws MessengerException;
    
}
