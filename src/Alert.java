public class Alert {
    private int endTime;
    private Patient p;
    private Observation obs;
    private int timeAlert;
    int severity;
    private String message;
    private boolean isBeingWorkedOn;
    private Nurse[] nursesWorking = new Nurse[100];
    private int duration;

    private String[] sevMsgs = {"Not as Urgent", "Urgent", "Really Urgent"};

    public Alert(Patient p, Observation obs, int timeAlert, int severity) {
        this.p = p;
        this.obs = obs;
        this.timeAlert = timeAlert;
        this.severity = severity;


        if(severity > 0) {
            this.message = sevMsgs[severity - 1];
        }

        duration = Simulation.getRandomNumber(30)*severity;
    }

    public int getTime(){ return timeAlert; }

    public void alertIsAssigned(Nurse nr){
        addNurse(nr);
        isBeingWorkedOn = true;
    }

    private void addNurse(Nurse nr) {
        int validSpot = 0;
        boolean foundSpot = false;

        for (int i = 0; i < nursesWorking.length; i++) {
            if (nursesWorking[i] == null) {
                validSpot = i;
                foundSpot = true;
                break;
            }
        }

        if(foundSpot) {
            nursesWorking[validSpot] = nr;
        }
    }

    public Nurse[] getNursesWorking(){ return  nursesWorking; }
    public boolean BeingWorked(){ return isBeingWorkedOn; }
    public int getDuration(){ return duration; }
    public int getEndTime(){ return endTime; }

    public void endAlert(int t){
        isBeingWorkedOn = false;
        endTime = t;
    }

    public String toString() {
        return "-ALERT- (SEVERITY:" + severity +") " + p + " [" + message + "] Time: " + timeAlert + " (" + obs.data() + ")";
    }

    public int getSeverity() {
        return severity;
    }
}