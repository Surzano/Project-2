public class Alert {
    private Observation obs;
    private int timeAlert;
    private int timeResolved;
    private String severity;

    public Alert(Observation obs, int timeAlert, String severity) {
        this.obs = obs;
        this.timeAlert = timeAlert;
        this.timeResolved = -1;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "-ALERT- [" + severity + "] Time: " + timeAlert + "( " + obs.data() + ")";
    }

}
