import java.io.File;
import java.util.Scanner;

public class Hospital {
    private Patient[] patients = new Patient[10];

    public Hospital(String fileName){
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

    public Patient[] getPatients(){ return patients; }

    public void updateAlertData(int currentTime) {
        for (int i = 0; i < patients.length; i++) {
                patients[i].genAlerts(currentTime);
        }
    }


}
