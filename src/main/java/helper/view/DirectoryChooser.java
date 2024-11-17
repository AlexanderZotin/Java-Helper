package helper.view;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Optional;

public class DirectoryChooser extends JFileChooser {
    public DirectoryChooser() {
       setCurrentDirectory(new File(System.getProperty("user.dir")));
       setDialogTitle("Помощник от Шурика — выбор папки");
       setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
   }

    public Optional<File> choose() {
        while(true) {
            int result = showDialog(null, "Выбрать");
            if(result == JFileChooser.APPROVE_OPTION) {
                if(getSelectedFile().isDirectory()) {
                    return Optional.of(getSelectedFile());
                } else {
                    JOptionPane.showMessageDialog(this, "Указанного пути не существует!",
                            "Помощник от Шурика", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                return Optional.empty();
            }
        }
    }
}