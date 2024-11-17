package helper.view.dialogs;

import helper.model.types.Enum;
import helper.model.types.TypeDeclaration;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.util.Optional;

public class EnumDialog extends QuestionnaireDialog {
    private final JTextField constantsTextField = new JTextField(16);

    public EnumDialog() {
        super("Имя перечисления:");
        add(new JLabel("Константы перечисления:"));
        add(constantsTextField);
        add(new JLabel("Пакет:"));
        add(packageTextField);
        add(createButton);
        createButton.setPreferredSize(new Dimension(180, 30));
        setSize(240, 330);
    }

    @Override
    public Optional<? extends TypeDeclaration> getInputtedInformation() {
         return super.emptyOrGet(() -> new Enum(
                nameOfFileTextField.getText(),
                packageTextField.getText(),
                super.defineModifier(),
                constantsTextField.getText()));
    }
}
