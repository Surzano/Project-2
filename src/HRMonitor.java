class HRMonitor extends Devices() {

    public Observation read() {
        HeartRate hrm = new HeartRate();
        return HeartRate;
    }
}
