/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.db.jdbc;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.UserDAO;
import static giorgoskozindividualv2.db.jdbc.DatabaseHelper.fetchAllUserIdsUsernames;
import giorgoskozindividualv2.model.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author giorgoskoz
 */
public class UserDAOImpl implements UserDAO {
    
    @Override
    public int deleteUser(int userId){
        String query = "DELETE FROM users WHERE user_id = ?";
        return DatabaseHelper.updateUser(query, userId);
    }
    
    @Override
    public int updateUserUsername(String username, int userId){
        String query = "UPDATE users SET username = ? WHERE user_id = ?";
        return DatabaseHelper.updateUser(query, username, userId);
    }
    
    @Override
    public int updateUserPassword(String password, int userId){
        String query = "UPDATE users SET password = ? WHERE user_id = ?";
        return DatabaseHelper.updateUser(query, password, userId);
    }
    
    @Override
    public int updateUserRole(int roleId, int userId){
        String query = "UPDATE users SET role_id = ? WHERE user_id = ?";
        return DatabaseHelper.updateUser(query, roleId, userId);
    }
    
    @Override
    public int createUser(String name, String password, int roleId) throws MessengerException {
        String query = "INSERT INTO `users` VALUES(default, ?, ?, ?, 0)";
        return DatabaseHelper.insertNewUser(query, name, password, roleId);
    }

    @Override
    public void update(User user) throws MessengerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User user) throws MessengerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserById(int id) throws MessengerException {
        User user = DatabaseHelper.fetchUserOrNull("select * from users where user_id = ?", id);
        if (user == null) {
            throw new MessengerException("Invalid user id: " + id);
        }
        return user;
    }

    @Override
    public User getUser(String username, String password) throws MessengerException {
        User user = DatabaseHelper.fetchUserOrNull("select * from users where name = ? and password = ?", username, password);
        if (user == null) {
            throw new MessengerException("Invalid username / password");
        }
        return user;
    }        

    @Override
    public List<User> getAllUsers() throws MessengerException {
        return DatabaseHelper.fetchUsers("select * from users");
    }

    @Override
    public Map<Integer, String> getAllUserIdsAndUsernames() throws MessengerException {
        return fetchAllUserIdsUsernames();
    }
    
}
