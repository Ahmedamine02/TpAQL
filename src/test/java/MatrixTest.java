import org.example.Matrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void addShouldCombineMatrices() {
        Matrix m1 = new Matrix(2);
        m1.set(0, 0, 1); m1.set(0, 1, 2);
        m1.set(1, 0, 3); m1.set(1, 1, 4);

        Matrix m2 = new Matrix(2);
        m2.set(0, 0, 5); m2.set(0, 1, 6);
        m2.set(1, 0, 7); m2.set(1, 1, 8);

        m1.add(m2);

        assertEquals(6, m1.get(0, 0));
        assertEquals(8, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(12, m1.get(1, 1));
    }

    @Test
    void multiplyShouldPerformMatrixMultiplication() {
        Matrix m1 = new Matrix(2);
        m1.set(0, 0, 1); m1.set(0, 1, 2);
        m1.set(1, 0, 3); m1.set(1, 1, 4);

        Matrix m2 = new Matrix(2);
        m2.set(0, 0, 5); m2.set(0, 1, 6);
        m2.set(1, 0, 7); m2.set(1, 1, 8);

        m1.multiply(m2);

        assertEquals(19, m1.get(0, 0));
        assertEquals(22, m1.get(0, 1));
        assertEquals(43, m1.get(1, 0));
        assertEquals(50, m1.get(1, 1));
    }

    @Test
    void transposeShouldSwapRowsAndColumns() {
        Matrix m = new Matrix(2);
        m.set(0, 0, 1); m.set(0, 1, 2);
        m.set(1, 0, 3); m.set(1, 1, 4);

        m.transpose();

        assertEquals(1, m.get(0, 0));
        assertEquals(3, m.get(0, 1));
        assertEquals(2, m.get(1, 0));
        assertEquals(4, m.get(1, 1));
    }
}