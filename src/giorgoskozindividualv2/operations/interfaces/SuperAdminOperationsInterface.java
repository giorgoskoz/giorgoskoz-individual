/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

import giorgoskozindividualv2.MessengerException;

/**
 *
 * @author giorgoskoz
 */
public interface SuperAdminOperationsInterface extends DeleterOperationsInterface {
    
    void createUser() throws MessengerException;
    
    void editUserUsername() throws MessengerException;
    
    void editUserPassword() throws MessengerException;
    
    void changeUserRole() throws MessengerException;
    
    void deleteUser() throws MessengerException;
    
    void readArchivedMessages() throws MessengerException;
    
//    void showBannedUsers();
//    
//    void banUser();
//    
//    void unBanUser();
    
}
