/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.utils;

import java.util.Scanner;

/**
 *
 * @author giorgoskoz
 */
public class Utils {
    
    public static String getInputString(){
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        
        return userInput;
    }
    
    public static int getInputInt() {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        
        return userInput;
    }
    
}
