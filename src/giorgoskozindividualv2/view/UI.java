/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.view;

/**
 *
 * @author giorgoskoz
 */
public interface UI {
    
    String getSplashScreen();

    String getWelcome();

    String getPromptUsername();

    String getPromptPassword();

    String getPromptWrongUsername();

    String getPromptWrongPassword();

    String getPromptId();
    
    String getPromptDate();
    
    String getPromptReceiver();
    
    String getPromptSender();
    
    String getPromptBanned();
    
    String getAllUsersIntro();
    
    String getMessageDeletionPromt();
    
    String getMessageDeletionConfirmation();
    
    String getMessageDeletionFailure();
    
    String getChooseUserToMessagePrompt();
    
    String getInputMessagePrompt();
    
    String getMessageSentSuccess();
    
    String getSeparator();
    
    String getOwnMessagesIntro();
    
    String getYouAreBanned();
    
    String getRestrictedUserMainMenu();
    
    String getRegularUserMainMenu();
    
    String getViewerMainMenu();
    
    String getEditorMainMenu();
    
    String getDeleterMainMenu();
    
    String getSuperAdminMenu();
    
    String getPromptRoleId();
    
    String getPromptSuccess();
    
    String getArchivedMessagesIntro();
    
    String getDeleteUserWarning();
    
    String getPromptFailed();
    
    String getEditOtherUserMessageIntro();
    
    String getEditMessagePrompt();
    
    String getEditMessageSuccess();
    
    String getEditMessageFailure();
    
    String getGoodbye();
    
    String getInvalidOption();
    
    String getReadOtherUserMessagesIntro();
    
    String getReadAllMessagesIntro();
    
}
