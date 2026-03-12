import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void TestDequeueMethod() {
        Queue queue = new Queue();
        Patient p1 = new Patient();
        HeartRate BadHr = new HeartRate(101,1);

        Alert alr = new Alert(p1, BadHr,1,"Not Urgent");

        assertNotNull(queue.dequeue());

    }

    @Test
    void TestEnqueueMethod() {
        Queue queue = new Queue();
        Patient P1 = new Patient();
        HeartPressure BadHP = new HeartPressure(150, 140, 2);

        Alert alr = new Alert(P1, BadHP, 1, "Urgent");
        queue.enqueue(alr);
        assertEquals(queue.peek().getTime(),1);

    }


}
