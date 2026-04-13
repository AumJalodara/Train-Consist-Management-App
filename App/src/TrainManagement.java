import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagement {

    static boolean searchBogie(String[] arr, String key) {

        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309"};
        String searchKey = "BG205";

        try {
            boolean found = searchBogie(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie Found");
            } else {
                System.out.println("Bogie Not Found");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static class TestCases {

        @Test
        void testSearch_ThrowsExceptionWhenEmpty() {
            String[] arr = {};
            assertThrows(IllegalStateException.class, () -> {
                searchBogie(arr, "BG101");
            });
        }

        @Test
        void testSearch_AllowsSearchWhenDataExists() {
            String[] arr = {"BG101","BG205"};
            assertDoesNotThrow(() -> {
                searchBogie(arr, "BG101");
            });
        }

        @Test
        void testSearch_BogieFoundAfterValidation() {
            String[] arr = {"BG101","BG205","BG309"};
            assertTrue(searchBogie(arr, "BG205"));
        }

        @Test
        void testSearch_BogieNotFoundAfterValidation() {
            String[] arr = {"BG101","BG205","BG309"};
            assertFalse(searchBogie(arr, "BG999"));
        }

        @Test
        void testSearch_SingleElementValidCase() {
            String[] arr = {"BG101"};
            assertTrue(searchBogie(arr, "BG101"));
        }
    }
}