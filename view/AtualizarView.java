package view;
import java.awt.*;
import javax.swing.*;

public class AtualizarView extends JFrame{

    private final JLabel nomeJLabel = new JLabel("Nome: ");
    private final JLabel emaiLJLabel = new JLabel("Email: ");
    private final JLabel senhaJLabel = new JLabel("Senha: ");
    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JPasswordField senhPasswordField = new JPasswordField();
    private final JButton atualizarJButton = new JButton("✔");
    private final JLabel notificacaoJLabel = new JLabel("Notificação: ");


    public AtualizarView(){

        super("Atualizar Registro");
        setLayout(new GridLayout(5, 3, 5, 5));

        JPanel linha1JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha5JPanel = new JPanel(new GridLayout(1, 2, 5, 5));


        linha1JPanel.add(nomeJLabel);
        linha1JPanel.add(nomeTextField);
        add(linha1JPanel);

        linha2JPanel.add(emaiLJLabel);
        linha2JPanel.add(emailJTextField);
        add(linha2JPanel);

        linha3JPanel.add(senhaJLabel);
        linha3JPanel.add(senhPasswordField);
        add(linha3JPanel);

        linha4JPanel.add(new JLabel());
        linha4JPanel.add(atualizarJButton);
        add(linha4JPanel);

        linha5JPanel.add(notificacaoJLabel);
        add(linha5JPanel);


        setSize(400, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        AtualizarView att = new AtualizarView();
        att.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}


