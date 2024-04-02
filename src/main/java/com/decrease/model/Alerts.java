package com.decrease.model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Alerts {
    
    private static String viewPath = "src/main/resources/com/decrease/view/";
    
    public static void showSuccessMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/success.gif");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, icon);
    }
    
    public static void showErrorMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/error.gif");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE, icon);
    }
    
    public static void showAlertMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/alert.gif");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icon);
    }
    
    public static int showConfirmMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/confirm.gif");
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    }
    
    public static void showInformationMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "images/icons/info.png");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }   
    
}
