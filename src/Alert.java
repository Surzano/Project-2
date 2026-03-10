public class Alert {
    private Patient p;
    private Observation obs;
    private int timeAlert;
    private String severity;

    public Alert(Patient p, Observation obs, int timeAlert, String severity) {
        this.p = p;
        this.obs = obs;
        this.timeAlert = timeAlert;
        this.severity = severity;
    }

    public String toString() {
        return "-ALERT- " + p + " [" + severity + "] Time: " + timeAlert + " (" + obs.data() + ")";
    }

}