import org.example.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void shouldReturnTrueForSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void shouldReturnTrueForPalindromeWithSpacesAndCasing() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void shouldReturnFalseForNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"));
    }


    @Test
    void shouldReturnTrueForSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("A"));
    }

    @Test
    void shouldReturnTrueForEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void shouldReturnTrueForArabWord() {
        assertTrue(Palindrome.isPalindrome("خوخ"));
    }

    @Test
    void shouldThrowExceptionForNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
}
