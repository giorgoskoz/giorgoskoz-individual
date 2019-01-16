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

    public String getPromptSender() {
        return promptSender;
    }

    public String getPromptReceiver() {
        return promptReceiver;
    }

    public String getPromptDate() {
        return promptDate;
    }

    public String getSplashScreen() {
        return splashScreen;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getPromptUsername() {
        return promptUsername;
    }

    public String getPromptPassword() {
        return promptPassword;
    }

    public String getPromptWrongUsername() {
        return promptWrongUsername;
    }

    public String getPromptWrongPassword() {
        return promptWrongPassword;
    }

    public String getPromptId() {
        return promptId;
    }

    public String getSeparator() {
        return separator;
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
