public class HeartRate extends Observation{
    private int bpm;
    private int time;

    public boolean critical() {
        return bpm <= 60 || bpm > 100;
    }

    public HeartRate(int bpm, int t) {
        this.bpm = bpm;
        time = t;

    }
    public String data() {
        return "Heart Rate: " + bpm + "bpm" + " at time "+ time;
    }

}
