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
public interface DeleterOperationsInterface extends EditorOperationsInterface {
    
    public void deleteOtherUserMessage() throws MessengerException;
    
}
