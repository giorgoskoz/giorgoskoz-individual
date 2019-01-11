/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author giorgoskoz
 */
public class Utils {
    
    public static String readInputString(){
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        
        return userInput;
    }
    
    public static int readInputInt() {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        
        return userInput;
    }
    
    public static String readPassword() {
        // google code to completely hide user input in javaw here
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        
        return userInput;
    }
    
}
