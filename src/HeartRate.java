public class HeartRate extends Observation{
    public boolean critical() {
        if (HeartRate < 40) or if (HeartRate > 75){
            return alert();
        }
    }
    public HeartRate() {

    }

}
