public class Alert {
    private Patient p;
    private Observation obs;
    private int timeAlert;
    private int severity;
    private String message;
    private boolean isBeingWorkedOn;
    private Nurse[] nursesWorking = new Nurse[100];
    private int duration;

    public Alert(Patient p, Observation obs, int timeAlert, String msg, int severity) {
        this.p = p;
        this.obs = obs;
        this.timeAlert = timeAlert;
        this.severity = severity;
        this.message = msg;

        duration = Simulation.getRandomNumber(5)*severity;
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

    public String toString() {
        return "-ALERT- " + p + " [" + message + "] Time: " + timeAlert + " (" + obs.data() + ")";
    }

}