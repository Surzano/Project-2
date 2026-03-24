public class HeartRate extends Observation{
    private int bpm;
    private int time;
    private int sev;

    public boolean critical() {
        return sev >= 1;
    }
    public int getSeverity(){ return sev; }

    public HeartRate(int bpm, int t) {
        this.bpm = bpm;
        time = t;

        if(bpm < 60 || bpm > 100){
            sev = 1;
            if(bpm < 50 || bpm > 120){
                sev = 2;
                if(bpm < 40  || bpm > 150){
                    sev = 3;
                }
            }
        }

    }


    public String data() {
        return "Heart Rate: " + bpm + "bpm" + " at time "+ time;
    }

}
