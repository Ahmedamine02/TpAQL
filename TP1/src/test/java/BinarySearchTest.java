import org.example.BinarySearch ;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void shouldReturnIndexOfElementIfExists() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(2, BinarySearch.binarySearch(arr, 5));
        assertEquals(0, BinarySearch.binarySearch(arr, 1));
        assertEquals(5, BinarySearch.binarySearch(arr, 11));
    }

    @Test
    void shouldReturnMinusOneIfElementNotFound() {
        int[] arr = {2, 4, 6, 8, 10};
        assertEquals(-1, BinarySearch.binarySearch(arr, 7));
    }

    @Test
    void shouldWorkWithSingleElementArray() {
        int[] arr = {42};
        assertEquals(0, BinarySearch.binarySearch(arr, 42));
        assertEquals(-1, BinarySearch.binarySearch(arr, 24));
    }

    @Test
    void shouldReturnMinusOneForEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearch(arr, 10));
    }

    @Test
    void shouldThrowExceptionIfArrayIsNull() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 10));
    }

    @Test
    void shouldHandleDuplicateValues() {
        int[] arr = {1, 2, 2, 2, 3};
        int result = BinarySearch.binarySearch(arr, 2);
        assertTrue(result >= 1 && result <= 3); // L'une des occurrences
    }
}
