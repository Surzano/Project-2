import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue queue;
    private Alert alr1;
    private Alert alr2;


    @BeforeEach
    void set() {
        queue = new Queue();
        Observation BadHR = new HeartRate(150);
        Observation BadPulseOx = new PulseOx(60);

        alr1 = new Alert(BadPulseOx, 10, "not urgent");
        alr2 = new Alert(BadHR, 12, "Urgent");
    }

    @Test
    void testEnqueueAndCount() {
        queue.enqueue(alr1);
        queue.enqueue(alr2);
        assertEquals(2, queue.count(), "Queue should contain 2 items.");
    }

    @Test
    void testDequeueOrder() {
        queue.enqueue(alr1);
        queue.enqueue(alr2);


        assertEquals(alr1, queue.dequeue(), "First dequeued item should be alert1.");
        assertEquals(alr2, queue.dequeue(), "Second dequeued item should be alert2.");
        assertEquals(0, queue.count(), "Queue should be empty after two dequeues.");
    }
    @Test
    void testPeek() {
        queue.enqueue(alr1);
        assertEquals(alr1, queue.peek(), "Peek should show the head without removing it.");
        assertEquals(1, queue.count(), "Count should remain unchanged after peek.");
    }
    @Test
    void testEmptyQueueBehavior() {
        assertNull(queue.dequeue(), "Dequeueing an empty queue should return null.");
        assertNull(queue.peek(), "Peeking an empty queue should return null.");
        assertEquals(0, queue.count(), "Count of new queue should be 0.");
    }
    @Test
    void testClearanceToNull() {
        queue.enqueue(alr1);
        queue.dequeue();
        // This checks your logic where if head becomes null, tail also becomes null
        assertEquals(0, queue.count());
        assertNull(queue.peek());
    }
}
