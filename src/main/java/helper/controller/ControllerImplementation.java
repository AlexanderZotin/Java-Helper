package helper.controller;

import helper.model.FileWorker;
import helper.model.JavaFile;
import helper.view.MainView;

import java.io.IOException;
import javax.swing.JOptionPane;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ControllerImplementation implements Controller {
    private final MainView view;

    @Override
    public void creatingRequested(JavaFile javaFile) {
        FileWorker fileWorker = new FileWorker(javaFile);
        try {
            if(fileWorker.createFile().isPresent()) {
                fileWorker.writeToFile();
                fileWorker.openFile();
                view.showMessage("Файл создан успешно!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                view.showMessage("Вы отказались от создания файла", JOptionPane.WARNING_MESSAGE);
            }
        } catch(Exception someException) {
            view.showMessage(defineErrorText(someException), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String defineErrorText(Exception exception) {
        return switch(exception) {
            case IOException _  -> """
                    Произошла ошибка при попытке создать файл и записать в него данные!\n
                    Возможно, папки, куда должен был помещён файл, не существует. \n
                    Например, она была случайно удалена после выбора в окне выбора папок.
                    """;
            case SecurityException _ -> "К директории или файлу нет доступа!";
            default -> "Произошла непредвиденная ошибка:\n" + exception;   
        };
    }
}
