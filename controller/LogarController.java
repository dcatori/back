package controller;

import javax.swing.*;
import model.*;
import view.*;

public class LogarController extends JFrame{

    public static void logar() {
        try {
            if (TelaLoginView.txtLogin.getText().trim().length() == 0) {
                TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("É necessário digitar um login para acessar! Por favor, verifique e tente novamente."));
                TelaLoginView.txtLogin.requestFocus();
            } else if (String.valueOf(TelaLoginView.txtSenha.getPassword()).trim().length() == 0) {
                TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("É necessário digitar uma senha para acessar! Por favor, verifique e tente novamente."));
                TelaLoginView.txtSenha.requestFocus();
            } else {
                boolean achouUsuario = Login.loginUsuario(TelaLoginView.txtLogin.getText(), String.valueOf(TelaLoginView.txtSenha.getPassword()).trim());
                if (achouUsuario == true) {
                    TelaPrincipalView appMenuFrame = new TelaPrincipalView();
                    appMenuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    TelaLoginView.telaLogin.dispose();
                } else {
                    TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Não foi encontrado o login e/ou senha digitados! Por favor, verifique e tente novamente."));
                }
            }
        } catch (Exception e) {
            TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Ops! Deu ruim no banco de dados, veja o erro: " + e));
        }        
    }

}
