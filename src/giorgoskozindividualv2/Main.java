                                                /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2;

import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.db.Database;
import giorgoskozindividualv2.db.jdbc.MessageDaoImpl;
import giorgoskozindividualv2.db.jdbc.UserDAOImpl;
import giorgoskozindividualv2.login.LoginSession;
import giorgoskozindividualv2.utils.Utils;
import java.util.ArrayList;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import giorgoskozindividualv2.operations.LanguagePicker;
import giorgoskozindividualv2.operations.RegularUserOperations;
import giorgoskozindividualv2.operations.RestrictedUserOperations;
import giorgoskozindividualv2.utils.FileLogger;
import giorgoskozindividualv2.view.EngUI;
import giorgoskozindividualv2.view.UI;
import giorgoskozindividualv2.view.View;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessengerException {
        // TODO code application logic here
        
        FileLogger.initFile();
        Dao dao = new Dao();
        UserDAOImpl udao = new UserDAOImpl();
//        UI ui = new EngUI();
        LanguagePicker lp = new LanguagePicker();
        View view = new View(lp.askForLanguage());
        MessageDaoImpl mdao = new MessageDaoImpl();
        LoginSession login = new LoginSession(dao, lp.getUi(), udao, mdao, view);
        
        
//        RestrictedUserOperations ruo = new RestrictedUserOperations(login.getLoggedUser(), udao, mdao, view);
//        ruo.mainMenu();
//        List<User> allUsers = udao.getAllUsers();
//        for (User user : allUsers) {
//            System.out.println(user);
//        }
//        
//        view.displayUsers(allUsers);
//        
//        
//        List<Message> allMessages = mdao.getAllMessages();
//        for (Message message : allMessages) {
//            System.out.println(message);
//        }
//        
//        User user = new User(16, "q", "q", 5, 0);
//        System.out.println(user);
//        List<Message> qsMessages = mdao.getMessagesOfUser(user);
//        view.displayMessages(qsMessages);
        
        
//        Dao dao = new Dao();
//        EngUI ui = new EngUI();
//        LoginSession loginSession = new LoginSession(dao, ui);
//        RestrictedUserOperations ruo = new RestrictedUserOperations((loginSession.getLoggedUser()), dao, ui);
//        ruo.readOwnMessages();
//        System.out.println("**BANG!**");
        
//        User user = new User(16, "q", "q", 0, 0);
//        Dao udao = new Dao();
//        String sql = "SELECT * FROM `users`";
//        ArrayList<User> users = udao.fetchAllUsers();
//        ArrayList<Message> messages = udao.fetchAllMessages();
//        ArrayList<Message> qMessages = udao.fetchUserMessages(user, user);
//        System.out.println(users);
//        System.out.println(messages);
//        System.out.println(user.getId());
//        System.out.println(qMessages);
//        User q = udao.fetchUserByUsername("q");
//        System.out.println(q);
//        String pass = Utils.readPassword();
//        System.out.println(pass);
//        System.out.println(udao.fetchDailypass());
        
    }
    
}
