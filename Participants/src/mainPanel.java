/**
 * The Participants program will allow users to register with a time slot
 * The log will give users feedback on their actions
 * All reserved time slots are displayed in a list
 *
 * @author StefanFB
 *
 * This class defines the interface
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPanel extends JFrame {
    public JPanel panelMain;
    private JTextField fieldName;
    public JSpinner timeH;
    private JButton addParticipantButton;
    public JSpinner timeM;
    private JTextArea participantsText;
    private JTextArea logText;

    // Create collection
    Participants participantsCollection = new Participants();

    public mainPanel() {

        addParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get all inputted values
                String username = fieldName.getText();
                int hours = (int) timeH.getValue();
                int minutes = (int) timeM.getValue();

                if (username.equals("")) { // Username has to be provided
                    String msg = "Please provide a valid name\n";
                    logText.append(msg);
                } else {
                    // Add messages to both TextArea's indicating successfull adding of particpant
                    String participantsMsg = String.format("%s, reservation at %02d:%02d\n", username, hours, minutes);
                    participantsText.append(participantsMsg);
                    String logMsg = String.format("%s was added\n", username, hours, minutes);
                    logText.append(logMsg);

                    // Add user to our participants-arraylist
                    Participant P = new Participant(username, hours, minutes);
                    participantsCollection.addParticipant(P);

                    // Debug print statements
                    System.out.print("Current participant: ");
                    System.out.println(P.showParticipantStr()); // show current participant
                    System.out.println("\nList of participants: ");
                    participantsCollection.showParticipants(); // show current ArrayList of participants
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

    public static void main(String[] args) {
        // Initialize our mainPanel
        mainPanel panel = new mainPanel();
        panel.setContentPane(panel.panelMain);
        panel.setSize(600, 400);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
