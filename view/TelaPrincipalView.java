package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaPrincipalView extends JFrame {

    public TelaPrincipalView() {
        super("PERFECT BURGUER");

        JMenu usuarioMenu = new JMenu("Usuarios");
        usuarioMenu.setMnemonic('U');

        JMenuItem cadastrarMenu = new JMenuItem("Cadastrar");
        cadastrarMenu.setMnemonic('C');
        usuarioMenu.add(cadastrarMenu);

        JMenuItem pesquisarMenu = new JMenuItem("Pesquisar");
        pesquisarMenu.setMnemonic('P');
        usuarioMenu.add(pesquisarMenu);

        JMenuItem atualizarMenu = new JMenuItem("Atualizar");
        atualizarMenu.setMnemonic('A');
        usuarioMenu.add(atualizarMenu);

        JMenuItem deletarMenu = new JMenuItem("Deletar");
        deletarMenu.setMnemonic('D');
        usuarioMenu.add(deletarMenu);

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(usuarioMenu);

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // Adiciona os listeners para os menus
        cadastrarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                abrirCadastrarView();
            }
        });

        pesquisarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                abrirPesquisarView();
            }
        });

        atualizarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                abrirAtualizarView();
            }
        });

        deletarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                abrirDeletarView();
            }
        });
    }

    // Métodos para abrir as diferentes janelas
    private void abrirCadastrarView() {
        CadastrarView cadastrarView = new CadastrarView(this);
        cadastrarView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cadastrarView.setVisible(true); // Torna a janela visível
    }

    private void abrirAtualizarView() {
        AtualizarView atualizarView = new AtualizarView(this);
        atualizarView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        atualizarView.setVisible(true); // Torna a janela visível
    }

    private void abrirDeletarView() {
        DeletarView deletarView = new DeletarView(this);
        deletarView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        deletarView.setVisible(true); // Torna a janela visível
    }

    private void abrirPesquisarView() {
        PesquisarView pesquisarView = new PesquisarView(this);
        pesquisarView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pesquisarView.setVisible(true); // Torna a janela visível
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipalView telaPrincipal = new TelaPrincipalView();
            telaPrincipal.setVisible(true); // Torna a janela principal visível
        });
    }
}
