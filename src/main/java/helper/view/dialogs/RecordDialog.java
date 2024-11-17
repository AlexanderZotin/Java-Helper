package helper.view.dialogs;

import helper.model.types.Record;
import helper.model.types.TypeDeclaration;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.util.Optional;

public class RecordDialog extends QuestionnaireDialog {
    private final JTextField components = new JTextField(16);

    public RecordDialog() {
        super("Имя записи:");
        add(new JLabel("Компоненты записи:"));
        add(components);
        add(new JLabel("Пакет:"));
        add(packageTextField);
        add(createButton);
        createButton.setPreferredSize(new Dimension(180, 30));
        setSize(240, 330);
    }

    @Override
    public Optional<? extends TypeDeclaration> getInputtedInformation() {
       return super.emptyOrGet(() -> new Record(
                nameOfFileTextField.getText(),
                packageTextField.getText(),
                super.defineModifier(),
                components.getText()));
    }
}
