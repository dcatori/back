package view;

import controller.HelperController;
import controller.LogarController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaLoginView extends JFrame {

    private final JLabel loginJLabel = new JLabel("Login");
    private final JTextField loginTextField = new JTextField();
    private final JLabel senhaJLabel = new JLabel("Senha");
    private final JPasswordField senhaPasswordField = new JPasswordField();
    private final JButton entrarJButton = new JButton("Entrar");
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    public static final JLabel notificacaoJLabel = new JLabel(HelperController.setHtmlFormat("Bem vindo! Faça login ou cadastre-se."), SwingConstants.CENTER);
    public static final JTextField txtLogin = new JTextField();
    public static final JPasswordField txtSenha = new JPasswordField();
    public static final JCheckBox checkBox = new JCheckBox("Aceito os termos");

    public TelaLoginView() {
        super("Tela de Login");
        setLayout(new GridLayout(9, 1, 5, 5));

        JPanel linha1JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha5JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha6JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha7JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha8JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha9JPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        linha1JPanel.add(new JLabel());
        add(linha1JPanel);

        linha2JPanel.add(loginJLabel);
        add(linha2JPanel);

        linha3JPanel.add(loginTextField);
        add(linha3JPanel);

        linha4JPanel.add(senhaJLabel);
        add(linha4JPanel);

        linha5JPanel.add(senhaPasswordField);
        add(linha5JPanel);

        linha6JPanel.add(entrarJButton);
        linha6JPanel.add(cadastrarJButton);
        add(linha6JPanel);

        linha7JPanel.add(new JLabel());
        add(linha7JPanel);

        checkBox.setSelected(true);
        linha8JPanel.add(checkBox);
        add(linha8JPanel);

        linha9JPanel.add(notificacaoJLabel);
        add(linha9JPanel);

        setSize(300, 400);
        setVisible(true);
        setLocationRelativeTo(null); // Centraliza a janela

        entrarJButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        if (TelaLoginView.txtLogin.getText().trim().length() == 0) {
                            TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("É necessário digitar um login para acessar! Por favor, verifique e tente novamente."));
                            TelaLoginView.txtLogin.requestFocus();
                        } else if (String.valueOf(TelaLoginView.txtSenha.getPassword()).trim().length() == 0) {
                            TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("É necessário digitar uma senha para acessar! Por favor, verifique e tente novamente."));
                            TelaLoginView.txtSenha.requestFocus();
                        } else if (TelaLoginView.checkBox.isSelected() == false) {
                            TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("É necessário aceitar os termos para acessar! Por favor, clique abaixo em \"Aceito os termos\" e tente novamente."));
                            TelaLoginView.checkBox.requestFocus();
                        } else {
                            LogarController.logar();
                        }
                    } catch (Exception e) {
                        TelaLoginView.notificacaoJLabel.setText(HelperController.setHtmlFormat("Ops! Algo de errado não está certo com a digitação dos campos de login e senha. Por favor verifique e tente novamente mais tarde, mas, se preferir, veja o erro do sistema: " + e));
                    }
                }
            }
        );

        cadastrarJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    setVisible(false);
                    CadastrarView cadastrarView = new CadastrarView(null);
                    cadastrarView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        );

        
    }

    public static TelaLoginView telaLogin;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLoginView telaLogin = new TelaLoginView();
            telaLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        });
    }
}
