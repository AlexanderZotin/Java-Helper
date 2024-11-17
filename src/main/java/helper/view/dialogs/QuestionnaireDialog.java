package helper.view.dialogs;

import helper.model.types.TypeDeclaration;
import helper.view.Visible;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class QuestionnaireDialog extends JDialog implements Visible, ActionListener {
    protected final JTextField nameOfFileTextField = new JTextField(16);
    protected final JRadioButton publicRadioButton = new JRadioButton("public");
    protected final JRadioButton packagePrivateRadioButton = new JRadioButton("package private");
    protected final JTextField packageTextField = new JTextField(16);
    protected final JButton createButton = new JButton("Создать!");

    public QuestionnaireDialog(String nameLabelText) {
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(publicRadioButton);
        radioButtons.add(packagePrivateRadioButton);
        publicRadioButton.setSelected(true);
        createButton.addActionListener(this);
        setTitle("Помощник от Шурика");
        setModal(true);
        setLayout(new FlowLayout(FlowLayout.LEFT, 31, 9));
        add(new JLabel(nameLabelText));
        add(nameOfFileTextField);
        add(publicRadioButton);
        add(packagePrivateRadioButton);
    } 
   
    public void start() {
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
   
    public abstract Optional<? extends TypeDeclaration> getInputtedInformation();

    protected TypeDeclaration.AccessModifier defineModifier() {
        return publicRadioButton.isSelected()
                ? TypeDeclaration.AccessModifier.PUBLIC : TypeDeclaration.AccessModifier.PACKAGE_PRIVATE;
    }

    protected Optional<? extends TypeDeclaration> emptyOrGet(Supplier<? extends TypeDeclaration> supplier) {
        if (nameOfFileTextField.getText().isEmpty()) return Optional.empty();
        else return Optional.of(supplier.get());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(nameOfFileTextField.getText().isEmpty()) {
            int answer = JOptionPane.showConfirmDialog(null,
                    "Вы не ввели имя!\nОтменить действие?",
                    "Помощник от Шурика", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.NO_OPTION) return;
        }
        dispose();      
    }
}