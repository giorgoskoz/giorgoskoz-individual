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
    
    private String splashScreen = "FAKE error";
    private String welcome = "Welcome";
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
                                          + "1" + separator + "Quit\n" 
                                          + "2" + separator + "Show messages";
    private String regularUserMainMenu = restrictedUserMainMenu + "\n" 
                                          + "3" + separator + "Send Message\n" 
                                          + "4" + separator + "Delete Message\n" 
                                          + "5" + separator + "Show All Users";
    private String goodbye = "See you in the shadows, sibling";
    private String invalidOption = "Invalid option, try again";

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
