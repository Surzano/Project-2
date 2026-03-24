public class BloodPressure extends Observation {
    private int HP;
    private int time;
    private int dystolic;
    private int diastolic;
    private int sev;

    public BloodPressure(int dy, int di, int  t){
        dystolic = dy;
        diastolic = di;
        time = t;

        if((dystolic < 90 || dystolic > 130) || (diastolic < 60 || diastolic > 80)){
            sev = 1;
            if((dystolic < 70 || dystolic > 150) || (diastolic < 40 || diastolic > 100)){
                sev = 2;
                if((dystolic < 50  || dystolic > 180) || (diastolic < 30 || diastolic > 120)){
                    sev = 3;
                }
            }
        }
    }

    public int getSeverity(){
        return sev;
    }

    public boolean critical(){
        return  sev > 0;
    }

    public String data() {
        return " Heart Pressure: " + dystolic + "/" + diastolic + " at time "+ time;
    }

}
