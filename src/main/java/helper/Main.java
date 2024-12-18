package helper;

import helper.controller.ControllerImplementation;
import helper.controller.Listener;
import helper.view.Window;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String [] args) {
       try {
          UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      } catch(UnsupportedLookAndFeelException | ClassNotFoundException 
              | InstantiationException | IllegalAccessException _) {
          System.err.println("An error has occurred trying set Look&Feel! Program will work, but will look not same as always.");
      }
      localizeUI();

      SwingUtilities.invokeLater(() -> {
          var view = new Window();
          var controller = new ControllerImplementation(view);
          view.subscribeToListener(new Listener(controller));
          view.setVisible(true);
      });
    }

    private static void localizeUI() {
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.okButtonText", "ОК");

        UIManager.put("FileChooser.lookInLabelText", "Искать в:");
        UIManager.put("FileChooser.saveInLabelText", "Создать в:");
        UIManager.put("FileChooser.folderNameLabelText", "Имя папки:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Типы файлов:");
        UIManager.put("FileChooser.acceptAllFileFilterText", "папки");
        UIManager.put("FileChooser.upFolderToolTipText", "На уровень выше");
        UIManager.put("FileChooser.homeFolderToolTipText", "Домашняя директория");
        UIManager.put("FileChooser.newFolderToolTipText", "Создать новую папку");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Таблица");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Отменить создание файла");
        UIManager.put("FileChooser.openButtonToolTipText", "Выбрать указанную папку");
        UIManager.put("FileChooser.viewMenuLabelText", "Вид");
        UIManager.put("FileChooser.listViewActionLabelText", "Список");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Таблица");
        UIManager.put("FileChooser.refreshActionLabelText", "Обновить");
        UIManager.put("FileChooser.newFolderActionLabelText", "Новая папка");
        UIManager.put("FileChooser.newFolderParentDoesntExistTitleText", "Указанного пути не существует");
        UIManager.put("FileChooser.newFolderParentDoesntExistText",
                "<html>Невозможно создать папку,<br>так как указанного пути больше не существует!</html>");

    }
}
