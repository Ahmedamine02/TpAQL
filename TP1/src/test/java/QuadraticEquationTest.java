
import org.example.QuadraticEquation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    void shouldThrowExceptionWhenAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }

    @Test
    void shouldReturnNullWhenNoRealRoots() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // x² + 1 = 0 → Δ < 0
    }

    @Test
    void shouldReturnOneRootWhenDeltaIsZero() {
        double[] result = QuadraticEquation.solve(1, 2, 1); // x² + 2x + 1 = 0 → Δ = 0
        assertArrayEquals(new double[]{-1.0}, result, 1e-6);
    }

    @Test
    void shouldReturnTwoRootsWhenDeltaIsPositive() {
        double[] result = QuadraticEquation.solve(1, -3, 2); // x² - 3x + 2 = 0 → x = 1, 2
        assertArrayEquals(new double[]{2.0, 1.0}, result, 1e-6); // ordre peut varier
    }

    @Test
    void shouldReturnCorrectRootsEvenWithNegatives() {
        double[] result = QuadraticEquation.solve(1, -2, -3); // x² - 2x - 3 = 0 → x = 3, -1
        assertArrayEquals(new double[]{3.0, -1.0}, result, 1e-6);
    }
}
