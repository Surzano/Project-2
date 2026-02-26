import java.util.UUID;

public class Hospital {
    Patient[] patients;
    UUID[] patientsUUID;

    public Hospital(int patientCount){
        patients = new Patient[patientCount];
    }

    public void addPatient(Patient ptn){
        int validSpot = 0;

        for(int i = 0; i<patients.length; i++){
            if(patients[i] == null){
                validSpot = i;
            }
        }

        patients[validSpot] = ptn;
        patientsUUID[validSpot] = UUID.randomUUID();
    }

}
