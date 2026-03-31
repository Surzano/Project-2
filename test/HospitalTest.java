import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {
    @Test
    void testHospital(){
        Hospital testHos = new Hospital("parameters.csv", false);

        assertNotNull(testHos);
    }

    @Test
    void testAddPatient(){
        Hospital testHos = new Hospital("parameters.csv", false);

        assertTrue(testHos.addPatient(new Patient()));
    }



}
