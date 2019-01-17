/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations.interfaces;

import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;
import giorgoskozindividualv2.MessengerException;

/**
 *
 * @author giorgoskoz
 */
public interface EditorOperationsInterface extends ViewerOperationsInterface {
    
    void editOtherUserMessage() throws MessengerException;
    
}
