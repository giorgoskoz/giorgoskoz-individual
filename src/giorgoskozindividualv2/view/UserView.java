/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.view;

import giorgoskozindividualv2.model.Message;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author giorgoskoz
 */
public class UserView {
    
    private AbstractUI ui;
    
    
    
    public void displayMessageArrayList(ArrayList<Message> messages) {
        for (Message message : messages) {
            
//            System.out.println(EngUI.promptId + message.getMessageId() + );
        }
    }
    
    public void displayAllUsers(ResultSet rs) {
        
    }
    
    public void displayAllMessages(ResultSet rs) {
        
    }
    
}
