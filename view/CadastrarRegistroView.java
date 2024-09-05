package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.sql.*;

import model.MySQLConnector;

public class CadastrarRegistroView extends JFrame{

    private final String db = "db_teste";
    private final String tbl = "tbl_teste";
    private String strNome;
    private String strEmail;

    private final JButton cadJButton = new JButton("Cadastrar");
    private final JLabel nomeCadastrarJLabel = new JLabel("Digite um nome: ");
    private final JLabel emailCadastrarJLabel = new JLabel("Digite um email: ");
    private final JLabel senhaCadastrarJLabel =  new JLabel("Digite uma senha: ");
    private final JTextField nomeCadastrarJTextField = new JTextField();
    private final JTextField emailCadastrarTextField = new JTextField();
    private final JPasswordField senhaCadastrarPasswordField = new JPasswordField();
    private final JLabel notificacaoJLabel = new JLabel("Notificações");


    public CadastrarRegistroView() {
        super("Cadastrar Registro");
        setLayout(new GridLayout(5, 3, 5, 5));


        JPanel linha1PJPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha5JPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        linha1PJPanel.add(nomeCadastrarJLabel);
        linha1PJPanel.add(nomeCadastrarJTextField);
        add(linha1PJPanel);

        linha2JPanel.add(emailCadastrarJLabel);
        linha2JPanel.add(emailCadastrarTextField);
        add(linha2JPanel);

        linha3JPanel.add(senhaCadastrarJLabel);
        linha3JPanel.add(senhaCadastrarPasswordField);
        add(linha3JPanel);

        linha4JPanel.add(new JLabel());
        linha4JPanel.add(cadJButton);
        add(linha4JPanel);

        linha5JPanel.add(notificacaoJLabel);
        add(linha5JPanel);

         
        setSize(400, 200);
        setVisible(true);

        cadJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlPesquisarEmail = "select * from `" + db + "`.`" + tbl + "` where `email` = '" + emailCadastrarTextField.getText() + "';";
                        Statement stmSqlPesquisarEmail = conexao.createStatement();
                        ResultSet rstPesquisarEmail = stmSqlPesquisarEmail.executeQuery(strSqlPesquisarEmail);
                        if (rstPesquisarEmail.next()) {
                            notificacaoJLabel.setText("Ops! Parece que há um cadastro com esse email. Porfavor, verifique e tente novamente com outro email.");
                            stmSqlPesquisarEmail.close();
                        } else {
                            String strSqlCadastrarRegistro = "insert into `" + db + "`.`" + tbl + "` (`nome`,`email`,`senha`) values ('" + nomeCadastrarJTextField.getText() + "','" + emailCadastrarTextField.getText() + "','" + String.valueOf(senhaCadastrarPasswordField.getPassword()) +"');";
                            Statement stmSqlCadastrarRegistro = conexao.createStatement();
                            stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
                            stmSqlCadastrarRegistro.executeBatch();
                            stmSqlCadastrarRegistro.close();
                            notificacaoJLabel.setText("Cadastro realizado com sucesso!");
                            TelaLoginView.notificacaoJLabel.setText("Cadastro realizado com sucesso!");
                            TelaLoginView.telaLogin.setVisible(true);
                            dispose(); // fechar a própria tela, sem fechar a tela anterior
                        }
                    } catch (Exception e) {
                        notificacaoJLabel.setText("Não foi possível realizar o cadastro. Por favor, verifique e tente novamente.");
                    }
                }
            }
        );
    }

    public static void main(String[] args) {
        CadastrarRegistroView application = new CadastrarRegistroView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}