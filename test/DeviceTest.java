import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    @Test
    void testHRMReadsObservation() {
        HRMonitor hrm = new HRMonitor();
        Observation obs = hrm.read();
        assertNotNull(obs, "Monitor should read Observation");
    }
    @Test
    void testPulseOxReadsObservation() {
        PulseOxMonitor POM = new PulseOxMonitor();
        Observation obs = POM.read();
        assertNotNull(obs, "Monitor should read observation");
    }

}
