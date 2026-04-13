import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainManagementTest {

    int threshold = 50;

    @Test
    void testFilter() {
        List<TrainManagement.Bogie> result = TrainManagement.getBogies().stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.capacity > threshold));
    }

    @Test
    void testReduce() {
        int total = TrainManagement.getBogies().stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }
}