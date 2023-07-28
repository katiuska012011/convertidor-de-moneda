package model;

import javax.swing.*;

public class Components extends JFrame {
    private JFrame frame = new JFrame();
    private JComboBox<String> comboBox = new JComboBox<>();
    private JLabel label = new JLabel();

    private JButton button = new JButton();

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}
