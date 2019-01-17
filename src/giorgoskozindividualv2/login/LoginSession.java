/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.login;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.dao.MessageDAO;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.EngUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.RegularUserOperations;
import giorgoskozindividualv2.operations.RestrictedUserOperations;
import giorgoskozindividualv2.view.UI;
import giorgoskozindividualv2.view.View;

/**
 *
 * @author giorgoskoz
 */
public class LoginSession {
    private User loggedUser;
    private Dao dao;
    private UI ui;
    private User user;
    private UserDAO udao;
    private MessageDAO mdao;
    private View view;
    
    public LoginSession(Dao dao, UI ui, UserDAO udao, MessageDAO mdao, View view) throws MessengerException {
        this.dao = dao;
        this.ui = ui;
        System.out.println(ui.getSplashScreen());;
        int dailypassInput = Utils.readInputInt();
        if (dailypassInput != dao.fetchDailypass()) {
            System.exit(0);
        }
        System.out.println(ui.getWelcome());
        String existingUsername = usernameInputAndCheck(getUsersMap());
        loggedUser = passwordInputAndCheck(existingUsername, getUsersMap());
        mainMenuDispacher(loggedUser, udao, mdao, view);
        
    }
    
    public User passwordInputAndCheck(String username, Map<String, String> usersMap){
        System.out.println(ui.getPromptPassword());
        String passwordInput = Utils.readPassword();
        boolean found = false;
        for (String value : usersMap.values()) {
            if (passwordInput.equals(value)) {
                return dao.fetchUserByUsername(username);
            }
        }
        if (!found) {
            System.out.println(ui.getPromptWrongPassword());
            passwordInputAndCheck(username, usersMap);
        }
        return null;
    }
    
    public String usernameInputAndCheck(Map<String, String> usersMap){
        System.out.println(ui.getPromptUsername());
        String usernameInput = Utils.readInputString();
        boolean found = false;
        for (String key : usersMap.keySet()) {
            if (usernameInput.equals(key)) {
                found = true;
                return usernameInput;
            }
        }
        if (!found) {
                System.out.println(ui.getPromptWrongUsername());
                usernameInputAndCheck(usersMap);
            }
        return null;
    }
    
    public Map getUsersMap(){
        Map<String, String> usersMap = new HashMap<>();
        ArrayList<User> users = dao.fetchAllUsers(); 
        for (User user : users) {
            usersMap.put(user.getUsername(), user.getPassword());
        }
        
        return usersMap;
    }
    
    public RestrictedUserOperations mainMenuDispacher(User user, UserDAO udao, MessageDAO mdao, View view) throws MessengerException {
        switch(user.getRole()){
            case RESTRICTED_USER:
                RestrictedUserOperations restrictedUserOperations = new RestrictedUserOperations(user, udao, mdao, view);
                restrictedUserOperations.mainMenu();
                break;
            case REGULAR_USER:
                RegularUserOperations regularUserOperations = new RegularUserOperations(user, udao, mdao, view);
                regularUserOperations.mainMenu();
                break;
        }
        return null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    
    
    
}
