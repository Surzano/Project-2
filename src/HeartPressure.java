public class HeartPressure extends Observation {
    private int HP;
    private int time;
    private int dystolic;
    private int diastolic;

    public HeartPressure(int dy, int di, int  t){
        dystolic = dy;
        diastolic = di;
        time = t;
    }

    public boolean critical(){
        if(dystolic >= 130 || diastolic >= 80 || dystolic <= 90 || diastolic <= 60){
            return true;
        }

        return false;
    }

    public String data() {
        return " Heart Pressure: " + dystolic + "/" + diastolic + " at time "+ time;
    }

}
