public class HeartRate extends Observation{
    private int bpm;
    private int time;

    public boolean critical() {
        if (bpm < 40 || bpm > 100) {
            return true;
        } else {
            return false;

        }
    }
    public HeartRate(int bpm, int t) {
        this.bpm = bpm;
        time = t;

    }
    public String data() {
        return "Heart Rate: " + bpm + "bpm" + " at time "+ time;
    }

}
