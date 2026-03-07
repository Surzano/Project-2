import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObservationTest {

    @Test

    void testHeartRateNormalNotCritical() {
        HeartRate hrm = new HeartRate(80);
        assertFalse(hrm.critical(), " should not be flagged.");

    }
    @Test
    void testHeartRateIsCritical() {
        HeartRate hrm = new HeartRate(135);
        assertTrue(hrm.critical(), "Should be flagged.");
        HeartRate hr = new HeartRate(30);
        assertTrue(hr.critical(), "Should be Flagged");
    }
    @Test
    void testPulseOxNormal() {
        PulseOx pom = new PulseOx(98);
        assertFalse(pom.critical(), "SHould not be flagged");

    }
    @Test
    void testPulseOxisCritical() {
        PulseOx pom = new PulseOx(85);
        assertTrue(pom.critical(), "Should be flagged");
    }

}
