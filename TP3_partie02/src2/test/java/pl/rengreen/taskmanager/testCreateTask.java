package pl.rengreen.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import pl.rengreen.taskmanager.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testCreateTask {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setTitle("Test Containers");
        task.setDescription("Learn Testcontainers");

        ResponseEntity<Task> response = restTemplate.postForEntity(
                "/tasks",
                task,
                Task.class
        );

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody().getId());
    }
}