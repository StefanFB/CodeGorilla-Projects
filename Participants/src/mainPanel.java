import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPanel extends JFrame {
    public JPanel panelMain;
    private JTextField fieldName;
    private JFormattedTextField outFieldLog;
    public JSpinner timeH;
    private JButton addParticipantButton;
    public JSpinner timeM;
    private JFormattedTextField outFieldParticipants;




    public mainPanel() {
        addParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fieldName.getText();


                // Display success message to the user
                JOptionPane.showMessageDialog(addParticipantButton, "Hi, " + username + "!\nThanks for participating!");
            }
        });
    }


    private void createUIComponents() {

        // Make sure the bounds of the spinner are set to the correct values for hours and minutes
        SpinnerNumberModel hours = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel minutes = new SpinnerNumberModel(0,0,59,1);
        timeH = new JSpinner(hours);
        timeM = new JSpinner(minutes);
    }
}
