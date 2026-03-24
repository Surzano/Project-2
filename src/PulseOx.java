public class PulseOx extends Observation {
    private int spo2;
    private int time;
    private int sev;

    public PulseOx(int sp, int t) {
        spo2 = sp;
        time = t;

        if(spo2 < 94){
            sev = 1;
            if(spo2 < 90){
                sev = 2;
                if(spo2 < 85){
                    sev = 3;
                }
            }
        }
    }

    public boolean critical() {
        //return spo2 < 90;
        return sev > 0;
    }

    public int getSeverity() { return sev; }

    public String data() {
        return "Sp02 (Oxygen): " + spo2 + "% at time "+ time;
    }

}
