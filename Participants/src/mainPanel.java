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
                int hours = (int) timeH.getValue();
                int minutes = (int) timeM.getValue();

                if (username.equals("")) { // Username has to be provided
                    String msg = String.format("Please provide a valid name");
                    JOptionPane.showMessageDialog(addParticipantButton, msg);
                } else {  // Display success message to the user
                    String msg = String.format("Thanks %s, you reserved at %02d:%02d", username, hours, minutes);
                    JOptionPane.showMessageDialog(addParticipantButton, msg);
                }
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
