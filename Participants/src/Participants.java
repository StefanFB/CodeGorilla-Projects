/**
 * This class creates the ArrayList of Participants
 * It has a method to add to the list
 * It has a debug function to print the complete list
 */

import java.util.ArrayList;

public class Participants {
    ArrayList<Participant> ParticipantsList;

    public Participants() {
        this.ParticipantsList = new ArrayList<>();
    }

    /**
     * Function to add a Participant to the ArrayList
     * @param P : Participant to add
     */
    public void addParticipant(Participant P) {
        ParticipantsList.add(P);
    }

    public void showParticipants() {
        for (int i = 0; i < ParticipantsList.size(); i++) {
            System.out.println(ParticipantsList.get(i).showParticipantStr());
        }
    }
}
