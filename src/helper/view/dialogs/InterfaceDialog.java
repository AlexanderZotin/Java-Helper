package helper.view.dialogs;

import helper.model.types.Interface;
import helper.model.types.TypeDeclaration;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.util.Optional;

public class InterfaceDialog extends QuestionnaireDialog {
    private final JCheckBox sealedCheckBox =  new JCheckBox("sealed, permits...");
    private final JTextField permittedSubtypesTextField = new JTextField(15);
    private final JTextField parentInterfacesTextField = new JTextField(15);

    public InterfaceDialog() {
        super("Имя интерфейса:");
        add(sealedCheckBox);
        add(permittedSubtypesTextField);
        add(new JLabel("Интерфейсы-родители:"));
        add(parentInterfacesTextField);
        add(new JLabel("Пакет:"));
        add(packageTextField);
        add(createButton);
        createButton.setPreferredSize(new Dimension(170, 30));
        setSize(230, 420);
        permittedSubtypesTextField.setEnabled(false);
        sealedCheckBox.addItemListener(_ -> permittedSubtypesTextField.setEnabled(sealedCheckBox.isSelected()));
    }

    @Override
    public Optional<? extends TypeDeclaration> getInputtedInformation() {
        return super.emptyOrGet(() -> new Interface(
                nameOfFileTextField.getText(),
                packageTextField.getText(),
                super.defineModifier(),
                parentInterfacesTextField.getText(),
                sealedCheckBox.isSelected()? permittedSubtypesTextField.getText() : ""));
    }
}
