import org.example.RomanNumeral ;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @Test
    void shouldThrowExceptionIfLessThan1OrGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void shouldReturnCorrectRomanNumerals() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("CM", RomanNumeral.toRoman(900));
        assertEquals("MCMXCIX", RomanNumeral.toRoman(1999));
        assertEquals("MMXXIV", RomanNumeral.toRoman(2024));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }
}
