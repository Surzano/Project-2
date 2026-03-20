public class Alert {
    private Patient p;
    private Observation obs;
    private int timeAlert;
    private int severity;
    private String message;
    private boolean isBeingWorkedOn;
    private int nursesWorking;

    public Alert(Patient p, Observation obs, int timeAlert, String msg, int severity) {
        this.p = p;
        this.obs = obs;
        this.timeAlert = timeAlert;
        this.severity = severity;
        this.message = msg;
    }

    public int getTime(){ return timeAlert; }

    public String toString() {
        return "-ALERT- " + p + " [" + message + "] Time: " + timeAlert + " (" + obs.data() + ")";
    }

}