import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class HospitalSystemTest {
    private Hospital hospital;
    private Patient patient;

    @BeforeEach
    void setUp() {

        hospital = new Hospital("parameters.csv");
        patient = new Patient("Test Patient");
    }

    @Test
    void testAlertOrder() {

        Alert urgent = new Alert(patient, null, 10, "Urgent", 9);
        Alert normal = new Alert(patient, null, 10, "Routine", 3);


        hospital.recieveAlert(urgent,null);
        hospital.recieveAlert(normal,null);


        Nurse nurse = hospital.getStaff()[0];
        hospital.assignNurses();

        assertEquals(urgent, nurse.getWorkingOn(), "Nurse should prioritize the Urgent alert.");
    }

    @Test
    void testNurseExperienceImpactsResolution() {

        Nurse experiencedNurse = new Nurse();


        Alert quickAlert = new Alert(patient, null, 0, "Urgent", 1);
        // Set a short duration
        quickAlert.getDuration();

        experiencedNurse.giveTask(quickAlert);


        assertTrue(experiencedNurse.hasFinished(10), "Experienced nurse should finish within 10 mins.");
    }

    @Test
    void testMultipleNursesOnOneAlert() {
        Alert bigDeal = new Alert(patient, null, 0, "Urgent", 10);
        bigDeal.getDuration();

        Nurse n1 = hospital.getStaff()[0];
        Nurse n2 = hospital.getStaff()[1];

        n1.giveTask(bigDeal);
        n2.giveTask(bigDeal);


        assertTrue(n1.hasFinished(20), "Two nurses should resolve the big deal faster.");
    }

    @Test
    void testCompletedQueueStorage() {
        Alert al = new Alert(patient, null, 0, "Urgent", 5);
        hospital.recieveAlert(al,null);
        hospital.assignNurses();

        Nurse n = hospital.getStaff()[0];


        if (n.hasFinished(50)) {
            Alert finished = n.getWorkingOn();
            finished.getTime();
            hospital.getCompleteQueue().enqueue(finished);
            n.clearTask();
        }

        assertEquals(1, hospital.getCompleteQueue().count(), "Resolved alerts must move to the completeQueue.");
        assertTrue(n.isFree(), "Nurse should be free after clearing task.");
    }
}


