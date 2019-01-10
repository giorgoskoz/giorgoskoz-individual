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
        
        Dao udao = new Dao();
        String sql = "SELECT * FROM `users`";
        ArrayList<User> users = udao.fetchAllUsers();
        ArrayList<Message> messages = udao.fetchAllMessages();
        System.out.println(users);
        System.out.println(messages);
        
    }
    
}
