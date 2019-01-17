/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.model.Message;
import giorgoskozindividualv2.model.User;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author giorgoskoz
 */
public class DatabaseHelper {
    
//    private static final String URL  = "jdbc:mysql://localhost:3306/messenger?serverTimezone=UTC&characterEncoding=utf-8&autoReconnect=true";
//    private static final String USER = "messAdmin";
//    private static final String PASS = "messAdmin123";
    private static final String URL  = "jdbc:mysql://localhost:3306/giorgoskozindividualv2?serverTimezone=Europe/Athens&characterEncoding=utf-8&autoReconnect=true";
    private static final String USER = "giorgoskozindividualv2Admin";
    private static final String PASS = "giorgoskozindividualv2Admin";
    
    static int updateMessageContent(String query, String content, int messageId){
        int rowsAffected = 0;
        try(Connection con = openConnection();
            PreparedStatement ps = con.prepareStatement(query);
        ) {
            ps.setString(1, content);
            ps.setInt(2, messageId);
            rowsAffected = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    
    static int insertNewMessage(String query, Timestamp dateSent, int senderId, int receiverId, String content) {
        int createdMessageId = -1;
        try(Connection con = openConnection();
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setTimestamp(1, dateSent);
            ps.setInt(2, senderId);
            ps.setInt(3, receiverId);
            ps.setString(4, content);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    createdMessageId = generatedKeys.getInt("message_id");
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return createdMessageId;
    }
    
    static void softDeleteMessage(String query, int messageId){
        try(Connection con = openConnection();
            PreparedStatement ps = con.prepareStatement(query);
        ) {
            ps.setInt(1, messageId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    static Map<Integer, String> fetchAllUserIdsUsernames() throws MessengerException {
        Map<Integer, String> usersMap = new TreeMap<>();
        try(Connection con = openConnection();
            PreparedStatement ps = con.prepareStatement("SELECT `user_id`, `username` FROM `users` ORDER BY `username`");
        ) { 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usersMap.put(rs.getInt("user_id"), rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return usersMap;
    }
    
    static User fetchUserOrNull(String query, int id) throws MessengerException {
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query);    
        ){            
            ps.setInt(1, id);            
            return fetchUserOrNull(ps);
        }        
        catch(SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }        
    }
    
    static User fetchUserOrNull(String query, String username, String password) throws MessengerException {
                
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query);    
        ){            
            ps.setString(1, username);
            ps.setString(2, password);
            return fetchUserOrNull(ps);
        }        
        catch(SQLException e) {
            throw new MessengerException(e.getMessage(), e);
        }        
    }
    
    static List<User> fetchUsers(String query) throws MessengerException {
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query);    
        ){      
            return fetchUsers(ps);
        }        
        catch(SQLException e) {
            throw new MessengerException(e.getMessage(), e);
        }        
    }
    
    static Message fetchMessageOrNull(String query, int id) throws MessengerException {
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query); 
             
        ){      
            ps.setInt(1, id);
            return fetchMessageOrNull(ps);
        }        
        catch(SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }        
    }
    
    static List<Message> fetchMessages(String query) throws MessengerException {
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query);    
        ){      
            return fetchMessages(ps);
        }        
        catch(SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }        
    }
    
    static List<Message> fetchMessages(String query, int userId) throws MessengerException {
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query);    
        ){      
            ps.setInt(1, userId);
            return fetchMessages(ps);
        }        
        catch(SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }        
    }
    
    static List<Message> fetchMessages(String query, int senderId, int receiverId) throws MessengerException {
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(query);    
        ){      
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            return fetchMessages(ps);
        }        
        catch(SQLException e) {
            throw new MessengerException(e.getMessage(), e);
        }        
    }
    
    private static Connection openConnection() throws SQLException {               
        return DriverManager.getConnection(URL, USER, PASS);                       
    }        
    
    private static User fetchUserOrNull(PreparedStatement ps) throws SQLException, MessengerException {
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return createUser(rs);
        }
        else {
            return null;
        }
    }
    
    private static List<User> fetchUsers(PreparedStatement ps) throws SQLException, MessengerException {
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User u = createUser(rs);
            users.add(u);
        }  
        return users;
    }
    
    //na mpoune oi mastoroi
    private static User createUser(ResultSet rs) throws SQLException, MessengerException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRoleById(rs.getInt("role_id"));
        user.setBanStatusByBanStatusId(rs.getInt("banned"));
        return user;
    }
    
    private static Message fetchMessageOrNull(PreparedStatement ps) throws SQLException, MessengerException {
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return createMessage(rs);
        }
        else {
            return null;
        }
    }
    
    private static List<Message> fetchMessages(PreparedStatement ps) throws SQLException, MessengerException {
        ArrayList<Message> messages = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Message m = createMessage(rs);
            messages.add(m);
        }  
        return messages;
    }
    
    //na mpoune oi mastoroi
    private static Message createMessage(ResultSet rs) throws SQLException, MessengerException {
        Message msg = new Message();
        
        msg.setMessageId(rs.getInt("message_id"));                
        
        int senderId = rs.getInt("sender_id");
        User sender = fetchUserOrNull("select * from users where user_id = ?", senderId);
        msg.setSender(sender);
        
        int receiverId = rs.getInt("receiver_id");
        User receiver = fetchUserOrNull("select * from users where user_id = ?", receiverId);               
        msg.setReceiver(receiver);
        
        Timestamp dateSent = new Timestamp(rs.getTimestamp("date_sent").getTime());
        msg.setDateSent(dateSent);
        
        msg.setContent(rs.getString("content"));
        
        msg.setDeletedBySender(rs.getInt("deleted_by_sender"));
        
        msg.setDeletedByReceiver(rs.getInt("deleted_by_receiver"));
        
        return msg;
    }
    
    
}
