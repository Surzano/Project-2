import java.util.UUID;

public class Patient {
    private UUID ID;
    private Devices[] dev = {new HRMonitor(), new PulseOxMonitor(), new TempMonitor(), new HPMonitor()};
    private int deviceCount;


    public Patient() {
        ID = UUID.randomUUID();
    }

    public void genAlerts(int currentTime) {
        for (int i = 0; i < dev.length; i++) {
            if (dev[i] != null) {
                Observation obs = dev[i].read(currentTime);

                if (obs.critical()) {
                    Alert newAlert = new Alert(obs, currentTime, "Urgent");
                    System.out.println("Patient " + ID + " generated an alert: " + newAlert.toString());
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
