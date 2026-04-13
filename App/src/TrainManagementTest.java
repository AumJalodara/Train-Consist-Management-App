import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    List<Bogie> getData() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Sleeper", i % 100));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> data = getData();
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : data) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> data = getData();

        List<Bogie> result = data.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> data = getData();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : data) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = data.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> data = getData();

        long start = System.nanoTime();
        data.stream().filter(b -> b.capacity > 60).count();
        long end = System.nanoTime();

        assertTrue(end - start > 0);
    }
}
