
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

public class DeleteFile {
    
    public static void main(String[] args) throws Exception{

        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Qual arquivo que vai deletar. ");
            int var1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            if(var1 == JFileChooser.APPROVE_OPTION){
                System.out.println("Arquivo escolhido: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("File Full Path: " + fileFullPath);
            } else{
                System.out.println("Triste");
            }

        
            Path pathOrigin = Paths.get(fileFullPath);
            Files.delete(pathOrigin);

        } catch (Exception e) {
            System.out.println("Nem deu pra deletar o arquivo.");
        }
        
    }
}
