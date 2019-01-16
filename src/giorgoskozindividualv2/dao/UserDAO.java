/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.dao;

import giorgoskozindividualv2.MessengerException;
import giorgoskozindividualv2.model.User;
import java.util.List;

/**
 *
 * @author giorgoskoz
 */
public interface UserDAO {
    
    User create(String name, String password, int roleId) throws MessengerException;
    
    void update(User user) throws MessengerException;
    
    void delete(User user) throws MessengerException;
    
    User getUserById(int id) throws MessengerException;
    
    User getUser(String username, String password) throws MessengerException;
    
    List<User> getAllUsers() throws MessengerException;
    
}
