import org.example.Order;
import org.example.OrderController;
import org.example.OrderDao;
import org.example.OrderService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    void testCreateOrder() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderService orderService = new OrderService(mockDao);
        OrderController controller = new OrderController(orderService);

        Order order = new Order("pc", 2);

        controller.createOrder(order);

        verify(mockDao).saveOrder(order);
    }
}
