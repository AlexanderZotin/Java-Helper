package helper.view.dialogs;

import helper.model.types.Class;
import helper.model.types.TypeDeclaration;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Optional;
import java.util.stream.Stream;

public class ClassDialog extends QuestionnaireDialog implements ItemListener {
    private final JCheckBox abstractCheckBox = new JCheckBox("abstract");
    private final JCheckBox finalCheckBox = new JCheckBox("final");
    private final JCheckBox sealedCheckBox = new JCheckBox("sealed, permits...");
    private final JTextField permittedSubclassesTextField = new JTextField(16);
    private final JTextField superClassTextField = new JTextField(16);
    private final JCheckBox constructorCheckBox = new JCheckBox("public-конструктор");
    private final JCheckBox mainCheckBox = new JCheckBox("стартовый метод main()");

    public ClassDialog() {
        super("Имя класса:");
        add(abstractCheckBox);
        add(finalCheckBox);
        add(sealedCheckBox);
        add(permittedSubclassesTextField);
        add(new JLabel("Суперкласс:"));
        add(superClassTextField);
        add(new JLabel("Создать в новом классе:"));
        add(constructorCheckBox);
        add(mainCheckBox);
        add(new JLabel("Пакет:"));
        add(packageTextField);
        add(createButton);
        createButton.setPreferredSize(new Dimension(180, 30));
        permittedSubclassesTextField.setEnabled(false);
        finalCheckBox.addItemListener(this);
        abstractCheckBox.addItemListener(this);
        sealedCheckBox.addItemListener(this);
        sealedCheckBox.addItemListener(_ -> 
                permittedSubclassesTextField.setEnabled(sealedCheckBox.isSelected()));
        setSize(250, 500);
    }
   
    @Override
    public void itemStateChanged(ItemEvent event) {
        JCheckBox source = (JCheckBox) event.getSource();
        Stream.of(abstractCheckBox, finalCheckBox, sealedCheckBox)
                .filter(current -> current != source)
                .forEach(current -> current.setEnabled(!source.isSelected()));
    }

    @Override
    public Optional<? extends TypeDeclaration> getInputtedInformation() {
        return super.emptyOrGet(() -> new Class(
                nameOfFileTextField.getText(),
                packageTextField.getText(),
                super.defineModifier(),
                finalCheckBox.isSelected(),
                abstractCheckBox.isSelected(),
                superClassTextField.getText(),
                sealedCheckBox.isSelected()? permittedSubclassesTextField.getText() : "",
                mainCheckBox.isSelected(),
                constructorCheckBox.isSelected()));
    }
}
