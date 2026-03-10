import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {
    @Test
    void testHRMReadsObservation() {
        HRMonitor hrm = new HRMonitor();
        Observation obs = hrm.read(0);
        assertNotNull(obs, "Monitor should read Observation");
    }
    @Test
    void testPulseOxReadsObservation() {
        PulseOxMonitor POM = new PulseOxMonitor();
        Observation obs = POM.read(0); // some number
        assertNotNull(obs, "Monitor should read observation");
    }

    @Test
    void testHPMReadsObservation() {
        HPMonitor hrm = new HPMonitor();
        Observation obs = hrm.read(0);
        assertNotNull(obs, "Monitor should read Observation");
    }
    @Test
    void testTemperatureObservation() {
        TempMonitor POM = new TempMonitor();
        Observation obs = POM.read(0); // some number
        assertNotNull(obs, "Monitor should read observation");
    }

}
