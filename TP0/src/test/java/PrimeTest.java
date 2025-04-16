import org.example.Prime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    void isPrimeShouldReturnFalseForNumbersLessThan2() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(-10));
        assertFalse(Prime.isPrime(-22));
    }

    @Test
    void isPrimeShouldReturnTrueForPrimes() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(11));
        assertTrue(Prime.isPrime(13));
    }

    @Test
    void isPrimeShouldReturnFalseForNonPrimes() {
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(10));
    }
}