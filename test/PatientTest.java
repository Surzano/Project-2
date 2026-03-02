import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testPatientIDValid(){
        Patient p1 = new Patient();
        assertNotNull(p1.getID());
    }

    @Test
    void testUniqueID(){
        Patient p1 = new Patient();
        Patient p2 = new Patient();
        assertNotEquals(p1.getID(), p2.getID());
    }

    @Test
    void TestAddPatient() {
        Patient p1 = Patient.addPatient();

        assertNotNull(p1);
        assertNotNull(p1.getID());
    }

}
