package helper.controller;

import helper.model.JavaFile;
import helper.model.types.TypeDeclaration;
import helper.view.DirectoryChooser;
import helper.view.dialogs.*;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@NonNull
@AllArgsConstructor
public class Listener implements ActionListener {
    private final Controller linkedController;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        var clickedButton = (JButton) e.getSource();
        Optional<File> directory = new DirectoryChooser().choose();
        if(directory.isPresent()) {
            QuestionnaireDialog dialog = defineDialogType(clickedButton.getText());
            dialog.start();
            String pathToDirectory = directory.get() + File.separator;
            Consumer<? super TypeDeclaration> consumer = 
                    type -> linkedController.creatingRequested(
                                new JavaFile(type, 
                                (Paths.get(pathToDirectory + type.getName() + ".java")))
                            );
            dialog.getInputtedInformation().ifPresent(consumer);
        }
    }

    private QuestionnaireDialog defineDialogType(String clickedButtonText) {
        return switch (clickedButtonText) {
            case "класс" -> new ClassDialog();
            case "интерфейс" -> new InterfaceDialog();
            case "перечисление" -> new EnumDialog();
            case "record" -> new RecordDialog();
            default -> throw new UnsupportedOperationException("Unsupported button text: " + clickedButtonText);
        };
    }
}
