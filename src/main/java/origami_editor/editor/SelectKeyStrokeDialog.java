package origami_editor.editor;

import origami_editor.tools.KeyStrokeUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.function.Function;

public class SelectKeyStrokeDialog extends JDialog {
    private final Function<KeyStroke, Boolean> select;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel keyStrokeLabel;
    private JButton buttonClear;
    private JLabel conflictLabel;

    private KeyStroke keyStroke;

    public SelectKeyStrokeDialog(Frame owner, AbstractButton button, Map<KeyStroke, AbstractButton> helpInputMap, KeyStroke keyStroke, Function<KeyStroke, Boolean> select) {
        super(owner, "Set Key Stroke");
        this.select = select;
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        setKeyStroke(keyStroke);

        KeyStrokeUtil.resetButton(buttonOK);
        KeyStrokeUtil.resetButton(buttonCancel);
        KeyStrokeUtil.resetButton(buttonClear);

        KeyListener adapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Ignore when only an action key is pressed
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_CONTROL:
                    case KeyEvent.VK_ALT:
                    case KeyEvent.VK_ALT_GRAPH:
                    case KeyEvent.VK_SHIFT:
                        setKeyStroke(null);
                        return;
                }

                KeyStroke keyStrokeForEvent = KeyStroke.getKeyStrokeForEvent(e);
                if (keyStrokeForEvent != null && helpInputMap.containsKey(keyStrokeForEvent) && helpInputMap.get(keyStrokeForEvent) != button) {
                    String conflictingButton = (String) helpInputMap.get(keyStrokeForEvent).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).get(keyStrokeForEvent);
                    setConflict("Conflicting with " + conflictingButton);
                } else {
                    setConflict(null);
                }
                setKeyStroke(keyStrokeForEvent);
            }
        };

        addKeyListener(adapter);
        keyStrokeLabel.addKeyListener(adapter);
        buttonOK.addKeyListener(adapter);
        buttonCancel.addKeyListener(adapter);
        buttonClear.addKeyListener(adapter);

        buttonClear.addActionListener(e -> setKeyStroke(null));

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
        setVisible(true);

        keyStrokeLabel.grabFocus();
    }

    private void setConflict(String s) {

        if (s == null) {
            conflictLabel.setText("<html>");
            buttonOK.setEnabled(true);
        } else {
            conflictLabel.setText("<html><span color='red'>" + s + "</span>");
            buttonOK.setEnabled(false);
        }
    }

    private void setKeyStroke(KeyStroke keyStroke) {
        if (keyStroke == null) {
            keyStrokeLabel.setText("<html><i>Press any key</i>");
        } else {
            keyStrokeLabel.setText("<html>" + KeyStrokeUtil.toString(keyStroke));
        }
        this.keyStroke = keyStroke;
    }

    private void onOK() {
        if (select.apply(keyStroke)) {
            dispose();
        }
    }

    private void onCancel() {
        dispose();
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
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer1, gbc);
        buttonOK = new JButton();
        buttonOK.setFocusable(false);
        buttonOK.setText("OK");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(buttonOK, gbc);
        buttonCancel = new JButton();
        buttonCancel.setFocusable(false);
        buttonCancel.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(buttonCancel, gbc);
        buttonClear = new JButton();
        buttonClear.setFocusable(false);
        buttonClear.setText("Clear");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(buttonClear, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        contentPane.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        contentPane.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        contentPane.add(spacer6, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.setBackground(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel2, gbc);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        keyStrokeLabel = new JLabel();
        keyStrokeLabel.setText("<html><i>None</i>");
        panel2.add(keyStrokeLabel);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel3, gbc);
        conflictLabel = new JLabel();
        conflictLabel.setText("<html>");
        panel3.add(conflictLabel);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        contentPane.add(spacer7, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
