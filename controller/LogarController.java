package controller;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.LoginModel;
import view.TelaLoginView;
import view.TelaPrincipalView;

public class LogarController {

         public static void logar() {
        try {
            boolean achouUsuario = LoginModel.loginUsuario(TelaLoginView.txtLogin.getText(), String.valueOf(TelaLoginView.txtSenha.getPassword()).trim());
            if (achouUsuario == true) {
                TelaPrincipalView appMenuFrame = new TelaPrincipalView();
                appMenuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                TelaLoginView.telaLogin.dispose();
            } else {
                TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Não foi encontrado o login e/ou senha digitados! Por favor, verifique e tente novamente."));
            }
        } catch (Exception e) {
            System.err.println(e);
            TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Ops! Houve um problema com o banco de dados. Por favor, tente novamente mais tarde, obrigado."));
        }        
    }
}
