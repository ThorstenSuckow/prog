package implementierung;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import schnittstellen.IListElement;
import schnittstellen.IList;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    @DisplayName("Stack")
    void testStack() {

        Stack stack = new Stack();

        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());
        assertEquals(0, stack.getSize());
        assertInstanceOf(IList.class, stack.getDVL());

        for (int i = 0; i < 7; i++) {
            stack.push(i+ 1);
            assertFalse(stack.isEmpty());
            assertFalse(i < 6 ? stack.isFull() : !stack.isFull());
            assertEquals(i + 1, stack.getSize());
        }

        assertTrue(stack.isFull());
        assertEquals(7, stack.top());
        assertEquals(7, stack.pop());

        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());

        assertEquals(4, stack.getSize());





    }
}