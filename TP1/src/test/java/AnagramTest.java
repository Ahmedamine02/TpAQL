import org.example.Anagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void shouldReturnTrueForSimpleAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void shouldReturnTrueIgnoringCasingAndSpaces() {
        assertTrue(Anagram.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
    }

    @Test
    void shouldReturnFalseForDifferentLengths() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    @Test
    void shouldReturnFalseForNonAnagrams() {
        assertFalse(Anagram.isAnagram("chien", "chat"));
    }

    @Test
    void shouldReturnTrueForEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    void shouldReturnTrueForAnagramsWithMultipleSpaces() {
        assertTrue(Anagram.isAnagram("  un mot   ici", "i c i    u n m o t"));
    }

    @Test
    void shouldReturnFalseWhenOnlyOneCharacterDiffers() {
        assertFalse(Anagram.isAnagram("test", "tess"));
    }



    @Test
    void shouldThrowExceptionForNullInputs() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
    }
}
