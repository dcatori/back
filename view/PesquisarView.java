package view;

import java.awt.*;
import javax.swing.*;

public class PesquisarView extends JFrame {

    public static final JLabel nomeJLabel = new JLabel("Nome");
    public static final JTextField nomeTextField = new JTextField();
    private final JButton pesquisarJButton = new JButton("🔎");
    private final JLabel notificacaoJLabel = new JLabel("Notificação: ");

    public PesquisarView(TelaPrincipalView telaPrincipal) {
        super("Pesquisar Registro");
        setLayout(new GridLayout(5, 3, 5, 5));

        JPanel linha1JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha2JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha3JPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha4JPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        linha1JPanel.add(new JLabel());
        linha1JPanel.add(new JLabel());
        add(linha1JPanel);

        linha2JPanel.add(nomeJLabel);
        linha2JPanel.add(nomeTextField);
        add(linha2JPanel);

        
        linha3JPanel.add(new JLabel());
        linha3JPanel.add(pesquisarJButton);
        add(linha3JPanel);

        linha4JPanel.add(notificacaoJLabel);
        add(linha4JPanel);

        setSize(400, 200);
        setVisible(true);
        setLocationRelativeTo(null);

        pesquisarJButton.addActionListener(event -> {
            // Aqui você pode implementar a lógica para pesquisar
            notificacaoJLabel.setText("Registro encontrado!"); // Exemplo
            dispose(); // Fecha a tela
        });
    }
}
