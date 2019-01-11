                                                /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2;

import giorgoskozindividualv2.dao.Dao;
import giorgoskozindividualv2.db.Database;
import java.util.ArrayList;
import model.Message;
import model.User;

/**
 *
 * @author giorgoskoz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        User user = new User(16, "q", "q", 0, 0);
        Dao udao = new Dao();
        String sql = "SELECT * FROM `users`";
        ArrayList<User> users = udao.fetchAllUsers();
        ArrayList<Message> messages = udao.fetchAllMessages();
        ArrayList<Message> qMessages = udao.fetchUserMessages(user, user);
        System.out.println(users);
        System.out.println(messages);
        System.out.println(user.getId());
        System.out.println(qMessages);
        User q = udao.fetchUserByUsername("q");
        System.out.println(q);
        
    }
    
}
