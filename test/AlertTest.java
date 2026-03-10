import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AlertTest {
    @Test
    void testAlertData() {
        Observation badHR = new HeartRate(150,0);
        Alert alr = new Alert(badHR, 15, "Urgent");

        String alertOut = alr.toString();

        assertTrue(alertOut.contains("Urgent"), "includes severity");
        assertTrue(alertOut.contains("15"), "Includes Alert time");
        assertTrue(alertOut.contains("150"), "Includes Observation Data");
    }

}
