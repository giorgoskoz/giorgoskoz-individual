/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

/**
 *
 * @author giorgoskoz
 */
public interface SuperAdminOperationsInterface extends DeleterOperationsInterface {
    
    void createUser();
    
    void editUserUsername();
    
    void editUserPassword();
    
    void changeUserRole();
    
    void deleteUser();
    
    void readArchivedMessages();
    
    void showBannedUsers();
    
    void banUser();
    
    void unBanUser();
    
}
