import java.util.UUID;

public class Patient {
    private UUID ID;
    private Devices[] dev = {new HRMonitor(), new PulseOxMonitor(), new TempMonitor(), new BPMonitor()};
    private int[] Severities = new int[dev.length];
    private int deviceCount;
    private boolean gettingTreatedByNurse = false;
    private String name;
    private Hospital h;


    public Patient(String n) {
        ID = UUID.randomUUID();
        name = n;
    }

    public Patient() {
        ID = UUID.randomUUID();
        name = "NONAME";
    }

    public void genAlerts(int currentTime, Hospital h) {
        for (int i = 0; i < dev.length; i++) {
            if (dev[i] != null) {
                Observation obs = dev[i].read(currentTime);

                if (obs.critical() && Severities[i] < obs.getSeverity()) {
                    Alert newAlert = new Alert(this, obs, currentTime, obs.getSeverity());
                    Severities[i] = obs.getSeverity();
                    h.recieveAlert(newAlert,obs);
                    System.out.println("Patient "+ name + "(" + ID + ") generated an alert: " + newAlert.toString());
                }
            }
        }
    }

    public UUID getID() {
        return ID;
    }

    public String toString(){
        return "Patient ID: " + ID.toString();
    }



}
