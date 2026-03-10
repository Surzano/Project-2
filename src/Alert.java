public class Alert {
    private Observation obs;
    private int timeAlert;
    private String severity;

    public Alert(Observation obs, int timeAlert, String severity) {
        this.obs = obs;
        this.timeAlert = timeAlert;
        this.severity = severity;
    }

    public String toString() {
        return "-ALERT- [" + severity + "] Time: " + timeAlert + " (" + obs.data() + ")";
    }

}