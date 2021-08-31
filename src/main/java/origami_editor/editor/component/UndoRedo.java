package origami_editor.editor.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UndoRedo extends JPanel {
    private JButton undoButton;
    private JPanel panel1;
    private JTextField undoCountTextField;
    private JButton setUndoCountButton;
    private JButton redoButton;

    public UndoRedo() {
    }

    public void addUndoActionListener(ActionListener listener) {
        undoButton.addActionListener(listener);
    }

    public void addRedoActionListener(ActionListener listener) {
        redoButton.addActionListener(listener);
    }

    public void addSetUndoCountActionListener(ActionListener listener) {
        setUndoCountButton.addActionListener(listener);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1.setLayout(new GridBagLayout());
        panel1.setEnabled(true);
        undoButton = new JButton();
        undoButton.setIcon(new ImageIcon(getClass().getResource("/ppp/undo.png")));
        undoButton.setPreferredSize(new Dimension(30, 30));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(undoButton, gbc);
        undoCountTextField = new JTextField();
        undoCountTextField.setColumns(2);
        undoCountTextField.setMinimumSize(new Dimension(60, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(undoCountTextField, gbc);
        setUndoCountButton = new JButton();
        setUndoCountButton.setPreferredSize(new Dimension(50, 30));
        setUndoCountButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(setUndoCountButton, gbc);
        redoButton = new JButton();
        redoButton.setIcon(new ImageIcon(getClass().getResource("/ppp/redo.png")));
        redoButton.setPreferredSize(new Dimension(30, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(redoButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    private void createUIComponents() {
        panel1 = this;
    }

    public String getText() {
        return undoCountTextField.getText();
    }

    public void setText(String s) {
        undoCountTextField.setText(s);
    }
}
