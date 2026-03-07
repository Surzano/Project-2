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
    void testPatientGenAlerts() {
        Patient p1 = Patient.CreatePatient();
        assertDoesNotThrow(() -> p1.genAlerts(10));
    }
}
