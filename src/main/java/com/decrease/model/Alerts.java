package com.decrease.model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Classe utilitária para exibição de alertas e mensagens.
 */
public class Alerts {
    
    private static String viewPath = "src/main/resources/com/decrease/view/";
    
    /**
     * Exibe uma mensagem de sucesso.
     * @param message O texto da mensagem.
     * @param title O título da janela de mensagem.
     * @param icon O ícone a ser exibido na mensagem.
     */
    public static void showSuccessMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/success.gif");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, icon);
    }
    
    /**
     * Exibe uma mensagem de erro.
     * @param message O texto da mensagem.
     * @param title O título da janela de mensagem.
     * @param icon O ícone a ser exibido na mensagem.
     */
    public static void showErrorMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/error.gif");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE, icon);
    }
    
    /**
     * Exibe uma mensagem de alerta.
     * @param message O texto da mensagem.
     * @param title O título da janela de mensagem.
     * @param icon O ícone a ser exibido na mensagem.
     */
    public static void showAlertMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/alert.gif");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, icon);
    }
    
    /**
     * Exibe uma mensagem de confirmação.
     * @param message O texto da mensagem.
     * @param title O título da janela de mensagem.
     * @param icon O ícone a ser exibido na mensagem.
     * @return Um valor indicando a opção selecionada pelo usuário.
     */
    public static int showConfirmMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "videos/gifs/confirm.gif");
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    }
    
    /**
     * Exibe uma mensagem informativa.
     * @param message O texto da mensagem.
     * @param title O título da janela de mensagem.
     * @param icon O ícone a ser exibido na mensagem.
     */
    public static void showInformationMessage(String message, String title, ImageIcon icon){
        icon = new ImageIcon(viewPath + "images/icons/info.png");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }   
    
}
