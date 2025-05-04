import org.example.Product;
import org.example.ProductApiClient;
import org.example.ProductService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void testGetProduct_Success() throws Exception {
        ProductApiClient mockApi = mock(ProductApiClient.class);
        Product expected = new Product("p1", "Phone");

        when(mockApi.getProduct("p1")).thenReturn(expected);

        ProductService service = new ProductService(mockApi);
        Product result = service.getProduct("p1");

        assertEquals("Phone", result.getName());
        verify(mockApi).getProduct("p1");
    }

    @Test
    void testGetProduct_Failure() throws Exception {
        ProductApiClient mockApi = mock(ProductApiClient.class);

        when(mockApi.getProduct("p2")).thenThrow(new RuntimeException("API failed"));

        ProductService service = new ProductService(mockApi);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.getProduct("p2");
        });

        assertEquals("API failed", exception.getMessage());
    }
}
