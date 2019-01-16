/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.view;

import giorgoskozindividualv2.model.Message;
import java.util.ArrayList;

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
    
    public void displayMessages(ArrayList<Message> messages){
        for (Message message : messages) {
            System.out.println(ui.getPromptId() + message.getMessageId() + 
            ui.getPromptDate() + message.getDate() + ui.getPromptSender() +
            dao.fetchUsernameByUserId(message.getSenderId()) + ui.getPromptReceiver() + 
            dao.fetchUsernameByUserId(message.getReceiverId()) + "\n" + message.getContent());
        }
    }
    
    
    
}
