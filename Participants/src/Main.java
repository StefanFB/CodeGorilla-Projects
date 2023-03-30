/**
 * The Participants program will allow users to register with a time slot
 * The log will give users feedback on their actions
 * All reserved time slots are displayed in a list
 *
 * @author StefanFB
 *
 */

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Initialize our mainPanel
        mainPanel panel = new mainPanel();
        panel.setContentPane(panel.panelMain);
        panel.setSize(600, 400);
        panel.setVisible(true);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}