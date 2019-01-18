/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.operations;

import giorgoskozindividualv2.utils.Utils;
import giorgoskozindividualv2.view.EngUI;
import giorgoskozindividualv2.view.ItaUI;
import giorgoskozindividualv2.view.UI;

/**
 *
 * @author giorgoskoz
 */
public class LanguagePicker {
    
    UI ui;

    public LanguagePicker() {
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }
    
    public UI askForLanguage(){
        int userChoice = 0;
        System.out.println("\n1  |  English");
        System.out.println("\n2  |  Italiano");
        System.out.println("");
        try {
            userChoice = Utils.readInputInt();
        } catch (Exception e) {
            askForLanguage();
        }
        switch(userChoice){
            case 1:
                ui = new EngUI();
                return new EngUI();
            case 2:
                ui = new ItaUI();
                return new ItaUI();
            default:
                return askForLanguage();
        }
    }
    
}
