package helper.view;

import helper.controller.Listener;
import lombok.NonNull;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;

public class Window extends JFrame implements MainView {
    private JButton[] buttons;

    public Window() {
        setTitle("Помощник от Шурика");
        JLabel label = new JLabel("Создать...");
        label.setFont(new Font(null, Font.PLAIN, 20));
        JPanel windowContent = new JPanel(new BorderLayout());
        windowContent.add("North", label);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        buttons = new JButton[4];
        buttons[0] = new JButton("класс");
        buttons[1] = new JButton("интерфейс");
        buttons[2] = new JButton("перечисление");
        buttons[3] = new JButton("record");
        Dimension dimensionOfButtons = new Dimension(160, 60);
        Arrays.stream(buttons).forEach(current -> {
            current.setPreferredSize(dimensionOfButtons);
            panel.add(current);
        });
        windowContent.add("South", panel);

        setContentPane(windowContent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
    }

    @Override
    public void subscribeToListener(@NonNull Listener listener) {
        Arrays.stream(buttons).forEach(current -> current.addActionListener(listener));
    }

    @Override
    public void showMessage(String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, "Помощник от Шурика", messageType);
    }
   
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(true);
        if(visible) setLocationRelativeTo(null);
    }
}