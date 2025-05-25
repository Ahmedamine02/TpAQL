import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.repository.TaskRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testGetTaskById {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testGetTaskById() {
        Task task = taskRepository.save(new Task("Test", "Description"));

        ResponseEntity<Task> response = restTemplate.getForEntity(
                "/tasks/" + task.getId(),
                Task.class
        );

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test", response.getBody().getTitle());
    }
}