public class HeartRate extends Observation() {
    public boolean dangerous() {
        if (HeartRate < 40) or if (HeartRate > 75){
            return alert();
        }
    }
    public HeartRate() {

    }

}
