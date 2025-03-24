import org.example.Factorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    void factorialShouldThrowExceptionForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }

    @Test
    void factorialShouldReturnCorrectValues() {
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }
}