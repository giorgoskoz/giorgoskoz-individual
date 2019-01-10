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
import model.Message;
import model.User;

/**
 *
 * @author giorgoskoz
 */
public class Dao {
    
    private Database db;
    
    public Dao() {
        db = new Database();
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
