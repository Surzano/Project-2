import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {
    @Test
    void testHospital(){
        Hospital testHos = new Hospital("parameters.csv");

        assertNotNull(testHos);
    }

    @Test
    void testAddPatient(){
        Hospital testHos = new Hospital("parameters.csv");

        assertTrue(testHos.addPatient(new Patient()));
    }



}
