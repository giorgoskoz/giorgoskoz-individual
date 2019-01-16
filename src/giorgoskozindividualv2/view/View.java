/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.view;

import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class View {
    
    private UI ui;

    public View() {
    }

    public View(UI ui) {
        this.ui = ui;
    }
    
    public void displayMessages(List<Message> messages){
        System.out.println(ui.getOwnMessagesIntro() + "\n");
        for (Message message : messages) {
            displayMessage(message);
        }
    }
    
    public void displayUsers(List<User> users){
        for (User user : users) {
            displayUser(user);
        }
    }
    
    public void displayMessage(Message message){
        System.out.println(message);
    }
    
    public void displayUser(User user){
        System.out.println("id: " + user.getId() + ui.getSeparator() 
                    + "username: " + user.getUsername() + ui.getSeparator() 
                    + "banned: " + user.getBanStatus() + "\n");
    }
    
    
    
}
