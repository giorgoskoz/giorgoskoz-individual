/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.db.jdbc;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.dao.UserDAO;
import giorgoskozindividualv2.model.User;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public class UserDAOImpl implements UserDAO {
    
    @Override
    public User create(String name, String password, int roleId) throws MessengerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        User user = DatabaseHelper.fetchUserOrNull("select * from users where id = ?", id);
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
    
}
