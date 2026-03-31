import java.io.File;
import java.util.Scanner;

public class Hospital {
    private Patient[] patients = new Patient[100];
    private Queue urgentQueue = new Queue();
    private Queue nonUrgentQueue = new Queue();
    private Queue completeQueue = new Queue();
    private Nurse[] staff;
    private Patient[] patientList;
    private boolean telemedicine = false;

    public Hospital(String fileName, boolean tele, int nrs){
        telemedicine = tele;
        staff = new Nurse[nrs];
        for(int i = 0; i < staff.length; i++) staff[i] = new Nurse();

        try {
            File parameters = new File(fileName);
            Scanner scan = new Scanner(parameters);

            while(scan.hasNextLine()){
                String line = scan.nextLine();

                String[] values = line.split(",");
                addPatient(new Patient(values[0]));
            }

        }catch(java.io.FileNotFoundException ex){
            System.out.println("Parameters file not found");
        }
    }

    public boolean addPatient(Patient ptn) {
        int validSpot = 0;
        boolean foundSpot = false;

        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == null) {
                validSpot = i;
                foundSpot = true;
                break;
            }
        }

        if(foundSpot) {
            patients[validSpot] = ptn;
        }

        return true;
    }

    public void recieveAlert(Alert al, Observation obs) {
        if (al.getSeverity() >= 5) {
            urgentQueue.enqueue(al);
        }else {
            nonUrgentQueue.enqueue(al);
        }
    }
    public void assignNurses() {
        for (Nurse n : staff) {
            if (n.isFree()) {
                Alert toAssign = urgentQueue.dequeue();
                if (toAssign == null) toAssign = nonUrgentQueue.dequeue();

                if (toAssign != null) n.giveTask(toAssign);
            }
        }
    }

    public void assignNursesOnWorkingAlerts(){
        for(Nurse working: staff) {
            if(!working.isFree()) {
                for (Nurse n : staff) {
                    if (n.isFree()) {
                        Alert toAssign = working.getWorkingOn();

                        if (toAssign != null) n.giveTask(toAssign);
                    }
                }
            }
        }

    }

    public Patient[] getPatients(){ return patients; }

    public void updateAlertData(int currentTime,Hospital h) {
        for (int i = 0; i < patients.length; i++) {
                patients[i].genAlerts(currentTime,h);
        }
    }
    public Nurse[] getStaff() {
        return staff;
    }

    public Queue getCompleteQueue() {
        return completeQueue;
    }

    public boolean areAlertsAvailable() { return urgentQueue.peek() == null && nonUrgentQueue.peek() == null;}

    public boolean isTelemedicineAvailable(){ return telemedicine;}
}
