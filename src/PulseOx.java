public class PulseOx extends Observation {
    private int spo2;


    public PulseOx(int spo2) {
        this.spo2 = spo2;
    }

    public boolean critical() {
        if (spo2 < 90) {
            return true;
        }else {
            return false;
        }
    }

    public String data() {
        return " Sp02 (Oxygen): " + spo2 + "%";
    }

}
