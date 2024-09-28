package helper.controller;

import helper.model.FileWorker;
import helper.model.JavaFile;
import helper.view.MainView;

import javax.swing.JOptionPane;
import java.util.Objects;

public class AppController implements Controller {
    private final MainView view;

    public AppController(MainView view) {
        this.view = Objects.requireNonNull(view);
    }

    @Override
    public void creatingRequested(JavaFile javaFile) {
        FileWorker fileWorker = new FileWorker(javaFile);
        try {
            if(fileWorker.createFile().isPresent()) {
                fileWorker.writeToFile();
                fileWorker.openFile();
               view.showInfo("Файл создан успешно!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                view.showInfo("Вы отказались от создания файла", JOptionPane.WARNING_MESSAGE);
            }
        } catch(Exception someException) {
            view.showInfo(someException.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
