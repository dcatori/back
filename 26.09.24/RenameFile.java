
import java.nio.file.*;
import javax.swing.JFileChooser;

public class RenameFile {

    public static void main(String[] args) throws Exception{

        try {

            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Informe o arquivo que deseja renomear. ");
            int var1 =  chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";

            if (var1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("Tu selecionou este arquivo: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("File Full Path: " + fileFullPath);
            } else {
                System.out.println("Que coisa não!!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathRename = Paths.get(fileName);
                    
            

        
        } catch (Exception e) {
            System.out.println("Nem deu pra renomear este arquivo!!");
        }
        

    }
    
}
