/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.utils;

import giorgoskozindividualv2.model.Message;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileLogger {

    private static final String FILENAME = System.getProperty("user.home") + "/log.txt";

    public static void initFile() {
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME, true);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    public static void writeToFile(Message message) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "\nid:" + message.getMessageId() + ", sender: "
                    + message.getSender().getUsername()
                    + ", receiver: " + message.getReceiver().getUsername()
                    + ", sent: " + message.getDateSent()
                    + ", content: " + message.getContent() + "  |  ";

            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAME, true), StandardCharsets.UTF_8));
            bw.write(content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
    
    public static void writeToFile(Message message, String newContent) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "\nid:" + message.getMessageId() + ", sender: "
                    + message.getSender().getUsername()
                    + ", receiver: " + message.getReceiver().getUsername()
                    + ", sent: " + message.getDateSent()
                    + ", content: " + message.getContent() + " edited to: " 
                    + newContent + "  |  ";

            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAME, true), StandardCharsets.UTF_8));
            bw.write(content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}

//writer.append(message.getMessageId() + ", "
//                    + message.getSender().getUsername()
//                    + ", " + message.getReceiver().getUsername()
//                    + ", " + message.getDateSent()
//                    + ", " + message.getContent());
//        writer.append(message.toString());
