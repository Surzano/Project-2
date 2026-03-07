import java.util.UUID;

public class Patient {
    private UUID ID;
    private Devices[] dev;
    private int deviceCount;


    public Patient() {
        ID = UUID.randomUUID();
        dev = new Devices[8];
        deviceCount = 0;
    }

    public void addDevice(Devices d) {
        if (deviceCount < dev.length) {
            deviceCount++;
        }
    }

    public static Patient CreatePatient() {
        Patient p = new Patient();
        p.addDevice(new HRMonitor());
        p.addDevice(new PulseOxMonitor());

        return p;
    }


    public void genAlerts(int currentTime) {
        for (int i = 0; i < dev.length; i++) {
            if (dev[i] != null) {
                Observation obs = dev[i].read();

                if (obs.critical()) {
                    Alert newAlert = new Alert(obs, currentTime, "Urgent");
                    System.out.println("Patient " + ID + "Generated an Alert: " + newAlert.toString());
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
