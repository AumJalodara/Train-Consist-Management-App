import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagement {

    static boolean linearSearch(String[] arr, String key) {

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";

        System.out.println("Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = linearSearch(bogieIds, searchKey);

        System.out.println("\n\nSearching for: " + searchKey);

        if (found) {
            System.out.println("Bogie Found");
        } else {
            System.out.println("Bogie Not Found");
        }
    }

    public static class TestCases {

        @Test
        void testSearch_BogieFound() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertTrue(linearSearch(arr, "BG309"));
        }

        @Test
        void testSearch_BogieNotFound() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertFalse(linearSearch(arr, "BG999"));
        }

        @Test
        void testSearch_FirstElementMatch() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertTrue(linearSearch(arr, "BG101"));
        }

        @Test
        void testSearch_LastElementMatch() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertTrue(linearSearch(arr, "BG550"));
        }

        @Test
        void testSearch_SingleElementArray() {
            String[] arr = {"BG101"};
            assertTrue(linearSearch(arr, "BG101"));
        }
    }
}