import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagement {

    static boolean binarySearch(String[] arr, String key) {

        if (arr.length == 0) return false;

        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};
        String searchKey = "BG205";

        System.out.println("Original IDs:");
        System.out.println(Arrays.toString(bogieIds));

        boolean found = binarySearch(bogieIds, searchKey);

        System.out.println("\nSearching for: " + searchKey);

        if (found) {
            System.out.println("Bogie Found");
        } else {
            System.out.println("Bogie Not Found");
        }
    }

    public static class TestCases {

        @Test
        void testBinarySearch_BogieFound() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertTrue(binarySearch(arr, "BG309"));
        }

        @Test
        void testBinarySearch_BogieNotFound() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertFalse(binarySearch(arr, "BG999"));
        }

        @Test
        void testBinarySearch_FirstElementMatch() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertTrue(binarySearch(arr, "BG101"));
        }

        @Test
        void testBinarySearch_LastElementMatch() {
            String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
            assertTrue(binarySearch(arr, "BG550"));
        }

        @Test
        void testBinarySearch_SingleElementArray() {
            String[] arr = {"BG101"};
            assertTrue(binarySearch(arr, "BG101"));
        }

        @Test
        void testBinarySearch_EmptyArray() {
            String[] arr = {};
            assertFalse(binarySearch(arr, "BG101"));
        }

        @Test
        void testBinarySearch_UnsortedInputHandled() {
            String[] arr = {"BG309","BG101","BG550","BG205","BG412"};
            assertTrue(binarySearch(arr, "BG205"));
        }
    }
}