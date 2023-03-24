import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPanel extends JFrame {
    private JPanel panelMain;
    private JTextField fieldName;
    private JFormattedTextField outFieldLog;
    private JSpinner timeH;
    private JButton addParticipantButton;
    private JSpinner timeM;
    private JFormattedTextField outFieldParticipants;


    public mainPanel() {
        addParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(addParticipantButton, "Hi, " + fieldName.getText() + "!\nThanks for participating!");
            }
        });
    }

    public static void main(String[] args) {
        mainPanel panel = new mainPanel();
        panel.setContentPane(panel.panelMain);
        panel.setSize(600, 400);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
