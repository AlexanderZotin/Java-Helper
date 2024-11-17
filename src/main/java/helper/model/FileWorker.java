package helper.model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.awt.Desktop;
import javax.swing.JOptionPane;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@NonNull
@AllArgsConstructor
public class FileWorker {
   private final JavaFile javaFile;
   
    public Optional<Path> createFile() throws InvalidPathException, SecurityException, IOException {
        Path path = javaFile.path();
        if(!Files.exists(path) || replace(path)) {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return Optional.of(path);
        }
        return Optional.empty();
    }
   
    private boolean replace(Path path) {
        int answer = JOptionPane.showConfirmDialog(null, 
                "Файл\n" + path + "\nуже существует! Заменить?",
               "Помощник от Шурика", JOptionPane.YES_NO_OPTION);
        return (answer == JOptionPane.YES_OPTION);
    }
   
    public void writeToFile() throws SecurityException, IOException {
        File file = javaFile.path().toFile();
        String textOfFile = javaFile.toString();
        try(PrintWriter writer = new PrintWriter(file)) {
            writer.print(textOfFile);
        }
    }
   
    public void openFile() throws IOException, SecurityException {
        File file = javaFile.path().toFile();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }
}