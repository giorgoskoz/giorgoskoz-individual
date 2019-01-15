/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.login;

import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.EngUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import giorgoskozindividualv2.model.User;

/**
 *
 * @author giorgoskoz
 */
public class LoginSession {
    private User loggedUser;
    
    public LoginSession() {
        Dao udao = new Dao();
        EngUI.welcome1();
        int dailypassInput = Utils.readInputInt();
        if (dailypassInput != udao.fetchDailypass()) {
            System.exit(0);
        }
        EngUI.welcome2();
        String existingUsername = usernameInputAndCheck(getUsersMap());
        loggedUser = passwordInputAndCheck(existingUsername, getUsersMap());
        
    }
    
    public User passwordInputAndCheck(String username, Map<String, String> usersMap){
        Dao udao = new Dao();
        EngUI.promptPassword();
        String passwordInput = Utils.readPassword();
        for (String value : usersMap.values()) {
            if (passwordInput.equals(value)) {
                return udao.fetchUserByUsername(username);
            }else{
                EngUI.promptWrongPassword();
                passwordInputAndCheck(username, usersMap);
            }
        }
        return null;
    }
    
    public String usernameInputAndCheck(Map<String, String> usersMap){
        EngUI.promptUsername();
        String usernameInput = Utils.readInputString();
        for (String key : usersMap.keySet()) {
            if (usernameInput.equals(key)) {
                return usernameInput;
            }else{
                EngUI.promptWrongUsername();
                usernameInputAndCheck(usersMap);
            }
        }
        return null;
    }
    
    public Map getUsersMap(){
        Map<String, String> usersMap = new HashMap<>();
        Dao udao = new Dao();
        ArrayList<User> users = udao.fetchAllUsers();
        for (User user : users) {
            usersMap.put(user.getUsername(), user.getPassword());
        }
        
        return usersMap;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    
    
    
}
