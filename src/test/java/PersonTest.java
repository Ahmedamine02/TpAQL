import org.example.Person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullNameShouldReturnFirstNameSpaceLastName() {
        // Arrange
        Person person = new Person("ahmed", "amine", 25);

        // Act
        String fullName = person.getFullName();

        // Assert
        assertEquals("ahmed amine", fullName);
    }

    @Test
    void isAdultShouldReturnTrueIfAgeIsGreaterThanOrEqualTo18() {
        // Test pour adulte
        Person adult = new Person("ahmed", "amine", 18);
        assertTrue(adult.isAdult());

        // Test pour mineur
        Person minor = new Person("ahmed", "amine", 17);
        assertFalse(minor.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseIfAgeIsLessThan18() {
        Person child = new Person("ahmed", "amine", 10);
        assertFalse(child.isAdult());
    }
}