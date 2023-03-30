/**
 * The Participants program will allow users to register with a time slot
 * The log will give users feedback on their actions
 * All reserved time slots are displayed in a list
 *
 * @author StefanFB
 *
 * This class defines the interface and functionality of the elements.
 * It also has functions to reset (parts of) the form when interacting with the form
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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

        /**
         * ActionListener for button, when clicked will try to add participant to our collection
         */
        addParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get all inputted values
                String username = fieldName.getText();
                int hours = (int) timeH.getValue();
                int minutes = (int) timeM.getValue();

                if (username.equals("") || username.equals("Write your name here")) { // Username has to be provided
                    String msg = "Please provide a valid name\n";
                    logText.append(msg);
                } else if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) {
                    String msg = "Please input a valid time\n";
                    logText.append(msg);
                } else {
                    // Add messages to both TextArea's indicating successful adding of participant
                    String logMsg = String.format("%s was added\n", username);
                    logText.append(logMsg);
                    String participantsMsg = String.format("%s, reservation at %02d:%02d\n", username, hours, minutes);
                    participantsText.append(participantsMsg);

                    // Add user to our participants-arraylist
                    Participant P = new Participant(username, hours, minutes);
                    participantsCollection.addParticipant(P);

                    // Reset form so a new participant can be added
                    resetForm();

                    // Debug print statements, to show ArrayList is actually updated
                    System.out.print("Current participant: ");
                    System.out.println(P.showParticipantStr()); // show current participant
                    System.out.println("\nList of participants: ");
                    participantsCollection.showParticipants(); // show current ArrayList of participants
                }
            }
        });

        /**
         * FocusListeners to empty when focussed, restore default value when no name was entered
         */
        fieldName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                fieldName.setText("");
            }
        });
        fieldName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String input = fieldName.getText();
                if (input.equals("")) {
                    fieldName.setText("Write your name here");
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

        // This doesn't work yet, it autofocusses on the text field, removing the default text
        // When re-enabling, check the Custom Create in the mainPanel.form
        // fieldName = new JTextField("Write your name here");
    }

    private void resetForm() {
        fieldName.setText("Write your name here");
        timeH.setValue(0);
        timeM.setValue(0);
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
