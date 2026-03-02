import java.io.File;
import java.util.Scanner;

public class Hospital {
    private Patient[] patients = new Patient[100];

    public Hospital(String fileName){
        try {
            File parameters = new File(fileName);
            Scanner scan = new Scanner(parameters);

            while(scan.hasNextLine()){
                String line = scan.nextLine();

                String[] values = line.split(",");
                addPatient(new Patient());
            }

        }catch(java.io.FileNotFoundException ex){
            System.out.println("Parameters file not found");
        }
    }

    public boolean addPatient(Patient ptn){
        int validSpot = 0;

        for(int i = 0; i<patients.length; i++){
            if(patients[i] == null){
                validSpot = i;
            }
        }

        patients[validSpot] = ptn;

        return true;
    }

}
