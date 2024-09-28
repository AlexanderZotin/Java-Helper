package helper.view;

import helper.Main;
import helper.model.JavaFile;
import helper.view.dialogs.*;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        Optional<Path> directory = new DirectoryChooser().choose();
        if(directory.isPresent()) {
            QuestionnaireDialog dialog = defineDialogType(clickedButton.getText());
            dialog.start();
            dialog.getInputtedInformation().ifPresent(type ->
                    Main.getController().creatingRequested(new JavaFile(
                            type, Paths.get(directory.get() + File.separator + type.getName() + ".java"))));
        }
    }

    private QuestionnaireDialog defineDialogType(String clickedButtonText) {
        return switch (clickedButtonText) {
            case "класс" -> new ClassDialog();
            case "интерфейс" -> new InterfaceDialog();
            case "перечисление" -> new EnumDialog();
            case "record" -> new RecordDialog();
            default -> throw new AssertionError("Неожиданный текст кнопки: " + clickedButtonText);
        };
    }
}
