/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2;

import giorgoskozindividualv2.dao.UserDao;
import giorgoskozindividualv2.db.Database;
import java.util.ArrayList;
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
        
        UserDao udao = new UserDao();
        String sql = "SELECT * FROM `users`";
        ArrayList<User> users = udao.fetchAllUsers();
        System.out.println(users);
        
    }
    
}
