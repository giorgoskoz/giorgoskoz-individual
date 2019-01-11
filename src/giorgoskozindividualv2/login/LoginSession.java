/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.login;

import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.UI;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author giorgoskoz
 */
public class LoginSession {
//break the class into methods, no spaghettini pls    
    private User loggedUser;
    
    public LoginSession() {
        Dao udao = new Dao();
        String existingUsername = "";
        User existingUser = new User();
        
        UI.welcome1();
        
        int dailypassInput = Utils.readInputInt();
        if (dailypassInput == udao.fetchDailypass()) {
            
        }else{
            System.exit(0);
        }
        
        UI.welcome2();
        
        UI.promptUsername();
        String usernameInput = Utils.readInputString();
        ArrayList<User> users = udao.fetchAllUsers();
        for (User user : users) {
            if (usernameInput.equals(user.getUsername())) {
                existingUsername = usernameInput;
                existingUser = user;
            }
        }
        if (existingUsername.equals("")) {
            UI.promptWrongUsername();
        }else{
            UI.promptPassword();
            String passwordInput = Utils.readPassword();
            if (passwordInput.equals(existingUser.getPassword())) {
                loggedUser = existingUser;
                //start UserController with loggedUser parameter here?
                //current session will remain open this way until System.exit(0) or
                //end of UserController
            }else{
                UI.promptWrongPassword();
            }
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    
    
    
}
