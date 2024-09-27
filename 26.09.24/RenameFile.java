

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RenameFile {

    public static void main(String[] args) throws Exception {

        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Select the file to move");
            int val1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if (val1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("File Full Path: " + fileFullPath);
            } else {
                System.out.println("No file selected.");
                return;
            }

            chooser.setDialogTitle("Select the destination folder");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int val2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if (val2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("You chose the folder: " + chooser.getSelectedFile().getName());
                System.out.println("Folder Full Path: " + chooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("No folder selected.");
                return;
            }

            
            String newFileName = JOptionPane.showInputDialog("Enter the new file name (with extension):", fileName);
            if (newFileName == null || newFileName.trim().isEmpty()) {
                System.out.println("Invalid filename. Operation canceled.");
                return;
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath, newFileName);

          
            Files.move(pathOrigin, pathDestination, REPLACE_EXISTING);
            System.out.println("File moved successfully to: " + pathDestination);

        } catch (Exception e) {
            System.out.println("Unable to move the file: " + e.getMessage());
        }
    }
}
