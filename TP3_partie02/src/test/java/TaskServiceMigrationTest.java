
import org.example.Mail;
import org.example.MailRepository;
import org.example.User;
import org.example.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest
public class TaskServiceMigrationTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("SD_db")
            .withUsername("root")
            .withPassword("amine.amine");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailRepository mailRepository; // Ajout du repository pour Mail

    @Test
    void testCreateUserAndMail() {
        // Créer un utilisateur
        User user = new User();
        user.setName("amine");
        user.setEmail("amine@gmail.com");
        userRepository.save(user);

        // Créer un mail associé
        Mail mail = new Mail(); // Correction de la casse
        mail.setSubject("Test Subject"); // Ajout des champs obligatoires
        mail.setContent("Test Content");
        mail.setUser(user); // Association avec l'utilisateur
        mailRepository.save(mail);

        // Vérifier les données
        assertNotNull(userRepository.findById(user.getId()).orElse(null));
        assertNotNull(mailRepository.findById(mail.getId()).orElse(null));
    }
}