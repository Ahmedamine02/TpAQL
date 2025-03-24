import org.example.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void newStackShouldBeEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void pushShouldAddElement() {
        Stack stack = new Stack();
        stack.push(22);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(22, stack.peek());
    }

    @Test
    void popShouldRemoveAndReturnTopElement() {
        Stack stack = new Stack();
        stack.push(22);
        stack.push(23);

        assertEquals(23, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(22, stack.peek());
    }

    @Test
    void popOnEmptyStackShouldThrowException() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void stackShouldExpandWhenFull() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.peek());
    }
}