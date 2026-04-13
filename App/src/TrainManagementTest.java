import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementTest {

    // Same model for testing
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Logic method
    boolean checkSafety(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    // TEST CASES

    @Test
    void testAllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(checkSafety(list));
    }

    @Test
    void testInvalidCylindrical() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(checkSafety(list));
    }

    @Test
    void testNonCylindricalAllowed() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(checkSafety(list));
    }

    @Test
    void testEmptyList() {
        List<GoodsBogie> list = new ArrayList<>();
        assertTrue(checkSafety(list)); // important concept
    }

    @Test
    void testMixedValidInvalid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // invalid
        );
        assertFalse(checkSafety(list));
    }
}
