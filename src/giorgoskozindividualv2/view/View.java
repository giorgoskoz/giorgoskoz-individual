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
import java.util.Map;
import java.util.Map.Entry;

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
    
    public void displayGoodbye(){
        System.out.println("\n" + ui.getGoodbye() + "\n");
    }
    
    public void displayRestrictedUserMenu(){
        System.out.println("\n" + ui.getRestrictedUserMainMenu() + "\n");
    }
    
    public void displayRegularUserMenu(){
        System.out.println("\n" + ui.getRegularUserMainMenu() + "\n");
    }
    
    public void displayViewerMenu(){
        System.out.println("\n" + ui.getViewerMainMenu() + "\n");
    }
    
    public void displayEditorMenu(){
        System.out.println("\n" + ui.getEditorMainMenu() + "\n");
    }
    
    public void displayEditOtherUserMessageIntro() {
        System.out.println("\n" + ui.getEditOtherUserMessageIntro() + "\n");
    }
    
    public void displayEditMessagePrompt(){
        System.out.println("\n" + ui.getEditMessagePrompt() + "\n");
    }
    
    public void displayEditMessageSuccess() {
        System.out.println("\n" + ui.getEditMessageSuccess() + "\n");
    }
    
    public void displayEditMessageFailure() {
        System.out.println("\n" + ui.getEditMessageFailure() + "\n");
    }
    
    public void displayReadOtherUserMessagesIntro(){
        System.out.println("\n" + ui.getReadOtherUserMessagesIntro() + "\n");
    }
    
    public void displayReadAllMessagesIntro(){
        System.out.println("\n" + ui.getReadAllMessagesIntro() + "\n");
    }
    
    public void displayOwnMessagesIntro(){
        System.out.println("\n" + ui.getOwnMessagesIntro() + "\n");
    }
    
    public void displayMessages(List<Message> messages){
        for (Message message : messages) {
            displayMessage(message);
        }
    }
    
    public void displayUsers(List<User> users){
        for (User user : users) {
            displayUser(user);
        }
    }
    
    public void displayUsers(Map<Integer, String> usersMap){
        System.out.println("\n" + ui.getAllUsersIntro() + "\n");
        for (Map.Entry<Integer, String> entry : usersMap.entrySet()) {
            System.out.println(ui.getPromptId() + entry.getKey() + ui.getSeparator()
                    + ui.getPromptUsername() + entry.getValue() + "\n");
        }
    }
    
    public void displayMessage(Message message){
        System.out.println(message);
    }
    
    public void displayUser(User user){
        System.out.println(ui.getPromptId() + user.getId() + ui.getSeparator() 
                    + ui.getPromptUsername() + user.getUsername() + ui.getSeparator() 
                    + ui.getPromptBanned() + user.getBanStatus() + "\n");
    }
    
    public void displayYouAreBanned(){
        System.out.println("\n" + ui.getYouAreBanned() + "\n");
    }
    
    public void displayInvalidOption(){
        System.out.println("\n" + ui.getInvalidOption() + "\n");
    }
    
    public void displayMessaDeletionPrompt(){
        System.out.println("\n" + ui.getMessageDeletionPromt() + "\n");
    }
    
    public void displayMessageDeletionConfirmation(){
        System.out.println("\n" + ui.getMessageDeletionConfirmation() + "\n");
    }
    
    public void displayInputMessagePrompt(){
        System.out.println("\n" + ui.getInputMessagePrompt() + "\n");
    }
    
    public void displayMessageSentSuccess(){
        System.out.println("\n" + ui.getMessageSentSuccess() + "\n");
    }
    
    public void displayChooseUserToMessagePrompt(){
        System.out.println("\n" + ui.getChooseUserToMessagePrompt() + "\n");
    }

    public UI getUi() {
        return ui;
    }
    
    
    
    
    
}
