package view;

import controller.CadastrarController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class CadastrarView extends JFrame {

    public static CadastrarView appNovoCadastro = null;


    private final JButton cadJButton = new JButton("Cadastrar");
    private final JButton insFotoJButton = new JButton("Inserir uma foto: ");
    private final JLabel insertFotoJLabel = new JLabel("Selecione uma foto: ");
    private final JLabel nomeCadastrarJLabel = new JLabel("Digite um nome: ");
    private final JLabel emailCadastrarJLabel = new JLabel("Digite um email: ");
    private final JLabel senhaCadastrarJLabel = new JLabel("Digite uma senha: ");
    public static final JTextField nomeCadastrarJTextField = new JTextField();
    public static final JTextField emailCadastrarTextField = new JTextField();
    public static final JPasswordField senhaCadastrarPasswordField = new JPasswordField();
    public static  final JLabel notificacaoJLabel = new JLabel("Notificações");
    public static String txtFoto = "Sua foto aqui";
    public static JLabel lblImg = new JLabel(txtFoto);

    public static boolean propriaTela = false;


    public CadastrarView(TelaPrincipalView telaPrincipal) {
        super("Cadastrar Registro");
        setLayout(new GridLayout(6, 3, 5, 5));

        JPanel linha1PJPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha5JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha6JPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        linha1PJPanel.add(nomeCadastrarJLabel);
        linha1PJPanel.add(nomeCadastrarJTextField);
        add(linha1PJPanel);

        linha2JPanel.add(emailCadastrarJLabel);
        linha2JPanel.add(emailCadastrarTextField);
        add(linha2JPanel);

        linha3JPanel.add(senhaCadastrarJLabel);
        linha3JPanel.add(senhaCadastrarPasswordField);
        add(linha3JPanel);

        linha4JPanel.add(insertFotoJLabel);
        linha4JPanel.add(insFotoJButton);
        add(linha4JPanel);

        linha5JPanel.add(cadJButton);
        add(linha5JPanel);

        linha6JPanel.add(notificacaoJLabel);
        add(linha6JPanel);

        setSize(400, 200);
        setVisible(true);
        setLocationRelativeTo(null);



        insFotoJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    CadastrarController.selecionarArquivoController();
                }
            }
        );



        cadJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (nomeCadastrarJTextField.getText().trim().length() <= 0) {
                        notificacaoJLabel.setText("Ops! Digite um nome para prosseguir e tente novamente.");
                        nomeCadastrarJTextField.requestFocus();
                        return;
                    }
                    if (emailCadastrarTextField.getText().trim().length() <= 0) {
                        notificacaoJLabel.setText("Ops! Digite um email para prosseguir e tente novamente.");
                        emailCadastrarTextField.requestFocus();
                        return;
                    }
                    if (String.valueOf(senhaCadastrarPasswordField.getPassword()).trim().length() <= 0) {
                        notificacaoJLabel.setText("Ops! Digite uma senha para prosseguir e tente novamente.");
                        senhaCadastrarPasswordField.requestFocus();
                        return;
                    }
                    if (CadastrarController.fileFullName.equals("")) {
                        int respostaUsuario = JOptionPane.showConfirmDialog(null, "Ops! Não foi selecionado um arquivo para foto no cadastro. Deseja continuar?");
                        System.out.println("respostaUsuario: " + respostaUsuario);
                        if (respostaUsuario < 1) {
                            CadastrarController.novoCadastroController();
                        } else {
                            notificacaoJLabel.setText("Clique em: \"Selecionar arquivo\" para escolher uma foto.");
                        }
                    }
                }
            }
        );


        ImageIcon img = new ImageIcon("./img/logo-perfect-burguer.png");
        setIconImage(img.getImage());
        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        appNovoCadastro = new CadastrarView(null);
        appNovoCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        propriaTela = true;
        appNovoCadastro.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (CadastrarController.fileFullName.equals("") == false) {
                    CadastrarController.removerArquivo();
                }
            }
        });
    }

}
