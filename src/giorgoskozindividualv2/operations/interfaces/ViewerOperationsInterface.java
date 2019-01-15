/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

import giorgoskozindividualv2.model.User;

/**
 *
 * @author giorgoskoz
 */
public interface ViewerOperationsInterface {
    
    public void readOtherUserMessages(User user);
    public void readAllMessages();
    
}
