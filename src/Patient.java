import java.util.UUID;

public class Patient {
    private UUID ID;
    private Devices[] dev = {new HRMonitor(), new PulseOxMonitor(), new TempMonitor(), new HPMonitor()};
    private int deviceCount;
    private boolean gettingTreatedByNurse = false;
    private String name;


    public Patient(String n) {
        ID = UUID.randomUUID();
        name = n;
    }

    public Patient() {
        ID = UUID.randomUUID();
        name = "NONAME";
    }

    public void genAlerts(int currentTime) {
        for (int i = 0; i < dev.length; i++) {
            if (dev[i] != null) {
                Observation obs = dev[i].read(currentTime);

                if (obs.critical()) {
                    Alert newAlert = new Alert(this, obs, currentTime, "Urgent");
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
