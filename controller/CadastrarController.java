package controller;
import java.awt.*;
import javax.swing.*;
import model.*;
import view.*;

public class CadastrarController extends CadastrarView {
    public static final String dbPadrao = "db_teste";
    public static final String tblPadrao = "tbl_teste";
    public static String fileFullPath = "";
    public static String fileFullName = "";

    public static void notificarUsuario(String textoNotificacao) {
        notificacaoJLabel.setText(setHtmlFormat(textoNotificacao));
    }

    public static void mostrarFoto() {
        try {
            ImageIcon img = new ImageIcon(new ImageIcon(fileFullPath).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            lblImg.setIcon(img);
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public static void memorizarArquivo(String fullPath, String fullName) {
        fileFullPath = fullPath;
        fileFullName = fullName;
    }

    public static void novoCadastroController() {
        CadastrarModel.novoCadastro(nomeCadastrarJTextField.getText(), emailCadastrarTextField.getText(), String.valueOf(senhaCadastrarPasswordField.getPassword()));
    }

    public static void exibirMenu() {
        TelaPrincipalView.telaPrincipal.setVisible(true);
        //TelaPrincipalView.telaPrincipal.setVisible(true);
    }

    public static void fecharNovoCadastroView() {
        TelaPrincipalView.telaPrincipal.dispose();
    }

    public static void selecionarArquivoController() {
        CadastrarModel.copyFile();
    }

    public static String setHtmlFormat(String txt) {
        return "<html><body>" + txt + "</body></html>";
    }

    public static void removerArquivo() {
        CadastrarModel.removerArquivoModel(fileFullPath);
    }

    public CadastrarController(TelaPrincipalView telaPrincipal) {
        super(telaPrincipal);
    }
}


