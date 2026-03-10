import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObservationTest {

    @Test

    void testHeartRateNormalNotCritical() {
        HeartRate hrm = new HeartRate(80,0);
        assertFalse(hrm.critical(), " should not be flagged.");

    }
    @Test
    void testHeartRateIsCritical() {
        HeartRate hrm = new HeartRate(135,0);
        assertTrue(hrm.critical(), "Should be flagged.");
        HeartRate hr = new HeartRate(30,0);
        assertTrue(hr.critical(), "Should be Flagged");
    }
    @Test
    void testPulseOxNormal() {
        PulseOx pom = new PulseOx(98,0);
        assertFalse(pom.critical(), "SHould not be flagged");

    }
    @Test
    void testPulseOxisCritical() {
        PulseOx pom = new PulseOx(85, 0);
        assertTrue(pom.critical(), "Should be flagged");
    }

    @Test
    void testHearPressureNormal(){
        assertFalse(new HeartPressure(100, 70, 0).critical());
    }

    @Test
    void testHearPressureCritical(){
        assertTrue(new HeartPressure(200, 130, 0).critical());
    }

    @Test
    void testTemperatureNormal(){
        assertFalse(new Temperature(38, 0).critical());
    }

    @Test
    void testTemperatureCritical(){
        assertTrue(new Temperature(40,0).critical());
    }

}
