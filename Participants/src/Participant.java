public class Participant {
    String name;
    int timeHour;
    int timeMin;

    public Participant(String name, int timeHour, int timeMin) {
        this.name = name;
        this.timeHour = timeHour;
        this.timeMin = timeMin;
    }

    String showParticipantStr() {
        return String.format("%s, reservation at %02d:%02d\n", this.name, this.timeHour, this.timeMin);
    }
}
