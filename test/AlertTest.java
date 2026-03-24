import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
class AlertTest {
    @Test
    void testAlertData() {
        Patient p1 = new Patient();
        Observation badHR = new HeartRate(150,0);
        Alert alr = new Alert(p1, badHR, 15, "Urgent", 3);

        String alertOut = alr.toString();

        assertTrue(alertOut.contains("p1"), "includes Patient Info");
        assertTrue(alertOut.contains("Urgent"), "includes severity");
        assertTrue(alertOut.contains("15"), "Includes Alert time");
        assertTrue(alertOut.contains("150"), "Includes Observation Data");
    }

}
