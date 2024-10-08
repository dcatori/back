package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaPrincipalView  extends JFrame{
      public TelaPrincipalView(){
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
         
         JMenu itemMenu = new JMenu("Itens");
         itemMenu.setMnemonic('I');


         JMenuBar bar = new JMenuBar();
         setJMenuBar(bar);
         bar.add(usuarioMenu);
         bar.add(itemMenu);

         

         setSize(500, 500);
         setVisible(true);

        
         cadastrarMenu.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    setVisible(true);
                    CadastrarView application = new CadastrarView();
                    application.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        );

     
   }
   public static int confirmarSaida() {
        if (JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?",
                "Mensagem do sistema", JOptionPane.PLAIN_MESSAGE) > 0) {
            return EXIT_ON_CLOSE;
        } else {
            return DO_NOTHING_ON_CLOSE;
        }
    }

    
    public static TelaPrincipalView telaPrincipal = null;

    public static void main(String[] args) {
        telaPrincipal = new TelaPrincipalView();
        telaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

