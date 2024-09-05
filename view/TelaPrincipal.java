package view;

import javax.swing.*;


public class TelaPrincipal  extends JFrame{
      public TelaPrincipal(){
         super("PERFECT BURGUER");

         JMenu usuarioMenu = new JMenu("Usuarios");
         usuarioMenu.setMnemonic('U');

         JMenu cadastrarMenu = new JMenu("Cadastrar");
         cadastrarMenu.setMnemonic('C');
         usuarioMenu.add(cadastrarMenu);

         JMenu pesquisarMenu = new JMenu("Pesquisar");
         pesquisarMenu.setMnemonic('P');
         usuarioMenu.add(pesquisarMenu);

         JMenu atualizarMenu = new JMenu("Atulizar");
         atualizarMenu.setMnemonic('A');
         usuarioMenu.add(atualizarMenu);

         JMenu deletarMenu = new JMenu("Deletar");
         deletarMenu.setMnemonic('D');
         usuarioMenu.add(deletarMenu);

         JMenuBar bar = new JMenuBar();
         setJMenuBar(bar);
         bar.add(usuarioMenu);

         setSize(500, 500);
         setVisible(true);
     
   }
   public static int confirmarSaida() {
        if (JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?",
                "Mensagem do sistema", JOptionPane.PLAIN_MESSAGE) > 0) {
            return EXIT_ON_CLOSE;
        } else {
            return DO_NOTHING_ON_CLOSE;
        }
    }

    public static TelaPrincipal telaPrincipal = null;

    public static void main(String[] args) {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
