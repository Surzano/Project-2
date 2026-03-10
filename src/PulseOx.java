public class PulseOx extends Observation {
    private int spo2;
    private int time;

    public PulseOx(int sp, int t) {
        spo2 = sp;
        time = t;
    }

    public boolean critical() {
        if (spo2 < 90) {
            return true;
        }else {
            return false;
        }
    }

    public String data() {
        return "Sp02 (Oxygen): " + spo2 + "% at time "+ time;
    }

}
