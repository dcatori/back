
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JFileChooser;

public class MoveFile {
    

    public static void main(String[] args) throws Exception{

        try{
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Qual arquivo você vai mover");
            int val1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if(val1 == JFileChooser.APPROVE_OPTION){
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("File Full Path: " + fileFullPath);
            } else{
                System.out.println("Lamentavel");
            }

            chooser.setDialogTitle("Informe a pasta de destino. ");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int val2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if (val2 == JFileChooser.APPROVE_OPTION){
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("You chose to open this folder: " + chooser.getSelectedFile().getName());
                System.out.println("Folder Full Path:" + chooser.getSelectedFile().getAbsolutePath());
            } else{
                System.out.println("Lamentavel");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            Files.move(pathOrigin, pathDestination, REPLACE_EXISTING);
        }catch (Exception e){
            System.out.println("Não foi possivel mover este arquivo");
        }
        
    }
}
