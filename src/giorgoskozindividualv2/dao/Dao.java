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
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;

/**
 *
 * @author giorgoskoz
 */
public class Dao {
    
    private Database db;
    
    public Dao() {
        db = new Database();
    }
    
    public int fetchDailypass(){
        int dailypass = 0;
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `dailypass`");
            rs = stmt.executeQuery();
            while (rs.next()) {
                dailypass = rs.getInt(3);
                
            }
            con.close();
            return dailypass;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return dailypass;
    }
    
    public String fetchUsernameByUserId(int userId) {
        String username = null;
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `users` WHERE `user_id`=?");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                username = rs.getString(2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return username;
    }
    
    public User fetchUserByUsername(String username) {
        User user = new User();
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `users` WHERE `username`=?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoleById(rs.getInt(4));
                user.setBanStatusByBanStatusId(rs.getInt(5));
            }
            con.close();
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
    
    public ArrayList fetchAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `users` ORDER BY `username` DESC");
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
    
    public ArrayList<Message> fetchAllMessages(){
        ArrayList<Message> messages = new ArrayList<>();
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `messages` ORDER BY `date` ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                
            }
            con.close();
            return messages;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return messages;
    }
    
    public ArrayList<Message> fetchUserMessages(User user) {
         return fetchUserMessages(user,user);
        
    }
    
    public ArrayList<Message> fetchUserMessages(User sender, User receiver){
        ArrayList<Message> messages = new ArrayList<>();
        ResultSet rs = null;
        Database db = new Database();
        try {
            Connection con = db.connectToDB();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `messages` WHERE `sender_id`= ? || `receiver_id` = ? ORDER BY `date` ASC");
            stmt.setInt(1, sender.getId());
            stmt.setInt(2, receiver.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                if ((rs.getInt(6) == 0) && (rs.getInt(7) == 0)) {
                    messages.add(new Message(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                }
            }
            con.close();
            return messages;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return messages;
    }
    
}
