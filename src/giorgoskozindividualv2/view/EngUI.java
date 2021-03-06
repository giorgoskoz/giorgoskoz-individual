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
public class EngUI implements UI {
    
    private static final String ANSI_RED = "\u001B[31m";
    
    private String splashScreen = ANSI_RED + "Something went wrong, try again later\n"
                                + ANSI_RED + "BUILD FAILED";
    private String welcome = ".           ..         .           .       .           .           .\n" +
"      .         .            .          .       .\n" +
"            .         ..xxxxxxxxxx....               .       .             .\n" +
"    .             MWMWMWWMWMWMWMWMWMWMWMWMW                       .\n" +
"              IIIIMWMWMWMWMWMWMWMWMWMWMWMWMWMttii:        .           .\n" +
" .      IIYVVXMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWxx...         .           .\n" +
"     IWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMx..\n" +
"   IIWMWMWMWMWMWMWMWMWBY%ZACH%AND%OWENMWMWMWMWMWMWMWMWMWMWMWMWMx..        .\n" +
"    \"\"MWMWMWMWMWM\"\"\"\"\"\"\"\".  .:..   .\"\"\"\"\"MWMWMWMWMWMWMWMWMWMWMWMWMWti.\n" +
" .     \"\"   . `  .: . :. : .  . :.  .  . . .  \"\"\"\"MWMWMWMWMWMWMWMWMWMWMWMWMti=\n" +
"        . .   :` . :   .  .'.' '....xxxxx...,'. '   ' .\"\"\"YWMWMWMWMWMWMWMWMWMW+\n" +
"     ; . ` .  . : . .' :  . ..XXXXXXXXXXXXXXXXXXXXx.    `     . \"YWMWMWMWMWMWMW\n" +
".    .  .  .    . .   .  ..XXXXXXXXWWWWWWWWWWWWWWWWXXXX.  .     .     \"\"\"\"\"\"\"\n" +
"        ' :  : . : .  ...XXXXXWWW\"   W88N88@888888WWWWWXX.   .   .       . .\n" +
"   . ' .    . :   ...XXXXXXWWW\"    M88N88GGGGGG888^8M \"WMBX.          .   ..  :\n" +
"         :     ..XXXXXXXXWWW\"     M88888WWRWWWMW8oo88M   WWMX.     .    :    .\n" +
"           \"XXXXXXXXXXXXWW\"       WN8888WWWWW  W8@@@8M    BMBRX.         .  : :\n" +
"  .       XXXXXXXX=MMWW\":  .      W8N888WWWWWWWW88888W      XRBRXX.  .       .\n" +
"     ....  \"\"XXXXXMM::::. .        W8@889WWWWWM8@8N8W      . . :RRXx.    .\n" +
"         ``...'''  MMM::.:.  .      W888N89999888@8W      . . ::::\"RXV    .  :\n" +
" .       ..'''''      MMMm::.  .      WW888N88888WW     .  . mmMMMMMRXx\n" +
"      ..' .            \"\"MMmm .  .       WWWWWWW   . :. :,miMM\"\"\"  : \"\"`    .\n" +
"   .                .       \"\"MMMMmm . .  .  .   ._,mMMMM\"\"\"  :  ' .  :\n" +
"               .                  \"\"MMMMMMMMMMMMM\"\"\" .  : . '   .        .\n" +
"          .              .     .    .                      .         .\n" +
".                                         .          .         .";
    private String promptUsername = "Username: ";
    private String promptPassword = "Password: ";
    private String promptWrongUsername = "No such username";
    private String promptWrongPassword = "Wrong password";
    private String promptId = "id: ";
    private String promptDate = "Date: ";
    private String promptSender = "Sender: ";
    private String promptReceiver = "Receiver: ";
    private String separator = "  |  ";
    private String ownMessagesIntro = "Your messages: (Newest at the bottom)";
    private String youAreBanned = "**You are BANNED. Pray to the powers that be that this gets reverted**";
    private String restrictedUserMainMenu = "Choose an option:\n"
                                          + "1 " + separator + "Quit\n" 
                                          + "2 " + separator + "Show messages";
    private String regularUserMainMenu = restrictedUserMainMenu + "\n" 
                                          + "3 " + separator + "Send Message\n" 
                                          + "4 " + separator + "Delete Message\n" 
                                          + "5 " + separator + "Show All Users";
    private String viewerMainMenu = regularUserMainMenu + "\n" 
                                          + "6 " + separator + "Read other user messages\n" 
                                          + "7 " + separator + "Read all messages";
    private String editorMainMenu = viewerMainMenu + "\n" 
                                          + "8 " + separator + "Edit other user message";
    private String deleterMainMenu = editorMainMenu + "\n" 
                                          + "9 " + separator + "Delete other user message";
    private String superAdminMenu = deleterMainMenu + "\n" 
                                          + "10" + separator + "Create new user\n" 
                                          + "11" + separator + "Edit user username\n" 
                                          + "12" + separator + "Edit user password\n"
                                          + "13" + separator + "Change user role\n"
                                          + "14" + separator + "Delete user\n"
                                          + "15" + separator + "Read archived messages";
    private String goodbye = "See you in the shadows, sibling";
    private String invalidOption = "Invalid option, try again";
    private String promptBanned = "Banned: ";
    private String allUsersIntro = "List of all the users: ";
    private String messageDeletionPromt = "Choose the id of the message to delete: ";
    private String messageDeletionConfirmation = "Message deleted successfully";
    private String chooseUserToMessagePrompt = "Choose the id of the user to message: ";
    private String inputMessagePrompt = "Type your message: ";
    private String messageSentSuccess = "Message sent successfully";
    private String readOtherUserMessagesIntro = "Choose the id of the user to see messages: ";
    private String readAllMessagesIntro = "List of all the Messages: ";
    private String editOtherUserMessageIntro = "Choose the id of the message to edit: ";
    private String editMessagePrompt = "Type the new content of the message: ";
    private String editMessageSuccess = "Message edited successfully";
    private String editMessageFailure = "Failed to edit message";
    private String messageDeletionFailure = "Failed to delete message";
    private String promptRoleId = "Role id: ";
    private String promptSuccess = "Success";
    private String promptFailed = "Failed";
    private String archivedMessagesIntro = "List of archived messages: ";
    private String deleteUserWarning = "Chose the id of the user to be DELETED\n"
                                     + "***WARNING THIS IS FINAL***";
    
    @Override
    public String getDeleteUserWarning(){
        return deleteUserWarning;
    }
    
    @Override
    public String getArchivedMessagesIntro(){
        return archivedMessagesIntro;
    }
    
    @Override
    public String getPromptSuccess(){
        return promptSuccess;
    }
    
    @Override
    public String getPromptFailed(){
        return promptFailed;
    }
    
    @Override
    public String getPromptRoleId(){
        return promptRoleId;
    }
    
    @Override
    public String getSuperAdminMenu(){
        return superAdminMenu;
    }
    
    @Override
    public String getMessageDeletionFailure(){
        return messageDeletionFailure;
    }
    
    @Override
    public String getDeleterMainMenu(){
        return deleterMainMenu;
    }
    
    @Override
    public String getEditMessageFailure(){
        return editMessageFailure;
    }
    
    @Override
    public String getEditMessageSuccess(){
        return editMessageSuccess;
    }
    
    public String getEditMessagePrompt() {
        return editMessagePrompt;
    }
    
    public String getEditOtherUserMessageIntro(){
        return editOtherUserMessageIntro;
    }
    
    public String getReadAllMessagesIntro(){
        return readAllMessagesIntro;
    }
    
    public String getReadOtherUserMessagesIntro(){
        return readOtherUserMessagesIntro;
    }
    
    @Override
    public String getMessageSentSuccess(){
        return messageSentSuccess;
    }
    
    @Override
    public String getInputMessagePrompt(){
        return inputMessagePrompt;
    }
    
    @Override
    public String getChooseUserToMessagePrompt(){
        return chooseUserToMessagePrompt;
    }
    
    public String getMessageDeletionConfirmation(){
        return messageDeletionConfirmation;
    }
    
    @Override
    public String getMessageDeletionPromt(){
        return messageDeletionPromt;
    }
    
    @Override
    public String getAllUsersIntro(){
        return allUsersIntro;
    }
    
    @Override
    public String getPromptBanned(){
        return promptBanned;
    }
    
    @Override
    public String getPromptSender() {
        return promptSender;
    }

    @Override
    public String getPromptReceiver() {
        return promptReceiver;
    }

    @Override
    public String getPromptDate() {
        return promptDate;
    }

    @Override
    public String getSplashScreen() {
        return splashScreen;
    }

    @Override
    public String getWelcome() {
        return welcome;
    }

    @Override
    public String getPromptUsername() {
        return promptUsername;
    }

    @Override
    public String getPromptPassword() {
        return promptPassword;
    }

    @Override
    public String getPromptWrongUsername() {
        return promptWrongUsername;
    }

    @Override
    public String getPromptWrongPassword() {
        return promptWrongPassword;
    }

    @Override
    public String getPromptId() {
        return promptId;
    }

    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public String getOwnMessagesIntro() {
        return ownMessagesIntro;
    }

    @Override
    public String getYouAreBanned() {
        return youAreBanned;
    }

    @Override
    public String getRestrictedUserMainMenu() {
        return restrictedUserMainMenu;
    }

    @Override
    public String getRegularUserMainMenu() {
        return regularUserMainMenu;
    }
    
    @Override
    public String getViewerMainMenu() {
        return viewerMainMenu;
    }
    
    @Override
    public String getEditorMainMenu(){
        return editorMainMenu;
    }
    
    @Override
    public String getGoodbye() {
        return goodbye;
    }

    @Override
    public String getInvalidOption() {
        return invalidOption;
    }
    
}
    

//    public static void welcome1(){
//        System.out.println("Welcome 1");
//    }
//    
//    public static void welcome2(){
//        System.out.println("Welcome 2");
//    }
//    
//    public static void promptUsername(){
//        System.out.println("Username: ");
//    }
//    
//    public static void promptPassword(){
//        System.out.println("Password: ");
//    }
//    
//    public static void promptWrongUsername(){
//        System.out.println("No such username");
//    }
//    
//    public static void promptWrongPassword(){
//        System.out.println("Wrong password");
//    }
