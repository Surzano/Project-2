import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void testRNGBounds() {
        int bound = 100;
        int result = Simulation.getRandomNumber(bound);

        assertTrue(result >= 0);
        assertTrue(result < bound);
    }

}
