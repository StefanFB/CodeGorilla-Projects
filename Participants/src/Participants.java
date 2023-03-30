import java.util.ArrayList;

public class Participants {
    ArrayList<Participant> ParticipantsList;

    public Participants() {
        this.ParticipantsList = new ArrayList<>();
    }

    public void addParticipant(Participant P) {
        ParticipantsList.add(P);
    }

    public void showParticipants() {
        for (int i = 0; i < ParticipantsList.size(); i++) {
            System.out.println(ParticipantsList.get(i).showParticipantStr());
        }
    }
}
