package view;
import java.awt.*;
import javax.swing.*;

public class DeletarRegistro extends JFrame{

    private final JLabel idJLabel = new JLabel("ID");
    private final JLabel nomeJLabel = new JLabel("Nome");
    private final JTextField idTextField = new JTextField();
    private final JTextField nomeJTextField = new JTextField();
    private final JButton deletarJButton = new JButton("Deletar");
    private final JLabel notificacaoJLabel = new JLabel("Notificação: ");


    public DeletarRegistro(){

        super("Deletar Registro");
        setLayout(new GridLayout(4, 3, 5, 5));

        JPanel linha1JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        
        linha1JPanel.add(idJLabel);
        linha1JPanel.add(idTextField);
        add(linha1JPanel);

        linha2JPanel.add(nomeJLabel);
        linha2JPanel.add(nomeJTextField);
        add(linha2JPanel);

        linha3JPanel.add(new JLabel());
        linha3JPanel.add(deletarJButton);
        add(linha3JPanel);

        linha4JPanel.add(notificacaoJLabel);
        add(linha4JPanel);

        setSize(400, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        DeletarRegistro del = new DeletarRegistro();
        del.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}