/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import java.util.ArrayList;

/**
 *
 * @author giorgoskoz
 */
public interface RegularUserOperationsInterface {
    
    public Message sendMessage(int receiverUserId, String content);
    public int deleteOwnMessage(int messageId);
    public ArrayList<User> getAllUsers();
    public int deleteOwnProfile();
    
}
