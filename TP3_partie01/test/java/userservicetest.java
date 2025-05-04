import org.example.User;
import org.example.UserRepository;
import org.example.UsService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class userservicetest {

    @Test
    void testGetUserById() {
        UserRepository mockRepo = mock(UserRepository.class);
        User expectedUser = new User(1, "koffi");

        when(mockRepo.findUserById(1)).thenReturn(expectedUser);

        UsService service = new UsService(mockRepo);
        User user = service.getUserById(1);

        assertEquals(expectedUser.getName(), user.getName());
        verify(mockRepo).findUserById(1);
    }
}
