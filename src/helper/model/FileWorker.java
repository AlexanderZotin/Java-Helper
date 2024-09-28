package helper.model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.io.PrintWriter;
import java.io.IOException;
import java.awt.Desktop;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import javax.swing.JOptionPane;

public class FileWorker {
   private final JavaFile javaFile;
   
   public FileWorker(JavaFile javaFile) {
       this.javaFile = Objects.requireNonNull(javaFile, "Параметр javaFile не должен быть null!");
   }
   
   public Optional<Path> createFile() throws InvalidPathException, SecurityException, IOException {
      Path path = javaFile.path();
      try {
         if(!Files.exists(path) || replace(path)) {
             Files.deleteIfExists(path);
            Files.createFile(path);
            return Optional.of(path);
         }
      } catch (InvalidPathException _) {
          throw new InvalidPathException("Путь\n" + path + "\nнекорректен.", "Ошибка");
      } catch (SecurityException _) {
          throw new SecurityException("Не удалось получить доступ к папке (" +
                 path.getParent() + "), в которой должен был быть создан файл.");
       } catch(IOException _) {
            throw new IOException
                 ("К сожалению, файл\n" + path + "\nсоздать не удалось.\nВозможно, папки\n" + 
               path.getParent() + "\nне существует.\nПроверьте существование и правильность пути, затем попробуйте ещё раз.");
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
       } catch (SecurityException _) {
          throw new SecurityException("Не удалось записать данные в файл, так как к\n" + file + "\nнет доступа.");
       } catch(IOException _) {
           throw new IOException("Не удалось записать данные в файл\n" + file + "\n.Попробуйте ещё раз.");
      }
    }
   
   public void openFile() throws SecurityException, IOException {
      File file = javaFile.path().toFile();
      try {
         Desktop desktop = Desktop.getDesktop();
         desktop.open(file);
      } catch (SecurityException _) {
         throw new SecurityException("Не удалось открыть файл, так как к\n" + file + "\nнет доступа.");
      } catch(IOException _){
         throw new IOException("Не удалось открыть файл\n" + file);
      }
   }
   
}