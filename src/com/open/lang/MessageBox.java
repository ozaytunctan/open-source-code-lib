/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.lang;

import java.awt.Component;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author ozaytunctan13
 */
public class MessageBox {

    public static void showErrorMessage(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.ERROR_MESSAGE);
    }

    public static String showQestionsValue(String msg) {
        String value = JOptionPane.showInputDialog(null, msg, "", JOptionPane.QUESTION_MESSAGE);
        return value;
    }
    
    public static void showMessage(Component com, String title, String msg) {
        JOptionPane.showMessageDialog(com, msg, title, JOptionPane.DEFAULT_OPTION);
    }

    public static void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.DEFAULT_OPTION);
    }

    public static void showMessage(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.DEFAULT_OPTION);
    }

    public static void showMessage(Component com, String msg) {
        JOptionPane.showMessageDialog(com, msg, "", JOptionPane.DEFAULT_OPTION);
    }
    
    
    public static void main(String[] args) {
        MessageBox.showMessage("Hello", "Uyarı");
      //  System.out.println(MessageBox.showQestionsValue("5 karesi kaçtır."));
    }
}
