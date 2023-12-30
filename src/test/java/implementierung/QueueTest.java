package implementierung;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import schnittstellen.IList;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    @DisplayName("Queue")
    void testQueue() {

        Queue queue = new Queue();

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(0, queue.getSize());
        assertInstanceOf(IList.class, queue.getDVL());

        for (int i = 0; i < 7; i++) {
            queue.enqueue(7 - i);
            assertFalse(queue.isEmpty());
            assertFalse(i < 6 ? queue.isFull() : !queue.isFull());
            assertEquals(i + 1, queue.getSize());
        }
        
        assertTrue(queue.isFull());
        assertEquals(1, queue.front());
        assertEquals(1, queue.dequeue());

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        assertEquals(4, queue.getSize());





    }
}