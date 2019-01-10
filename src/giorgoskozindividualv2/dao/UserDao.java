/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.dao;

import giorgoskozindividualv2.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author giorgoskoz
 */
public class UserDao {
    
    private Database db;
    
    public UserDao() {
        db = new Database();
    }
    
    public ArrayList<User> fetchAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `users` ORDER BY role DESC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
                
            }
            con.close();
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return users;
    }
    
}
