public class HeartRate extends Observation{
    private int bpm;

    public boolean critical() {
        if (bpm < 40 || bpm > 100) {
            return true;
        } else {
            return false;

        }
    }
    public HeartRate(int bpm) {
        this.bpm = bpm;

    }
    public String data() {
        return " Heart Rate: " + bpm + "bpm";
    }

}
