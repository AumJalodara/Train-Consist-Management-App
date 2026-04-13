import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagement {

    static void bubbleSort(int[] arr) {
        int n = arr.length;
import java.util.*;
import java.util.stream.Collectors;

public class TrainManagement {

    // ----------- Bogie Class -----------
    static class Bogie {
        String name;
        int capacity;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        String getName() {
            return name;
        }

        int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // ----------- Main Program -----------
    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        bubbleSort(capacities);

        System.out.println("\nAfter Sorting:");
        for (int c : capacities) {
            System.out.print(c + " ");
        System.out.println("=======================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("=======================================\n");

        // Create List of Bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        // Display All Bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }

    public static class TestCases {

        // -------- GROUPING USING STREAM --------
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        // Display Grouped Bogies
        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {

            System.out.println("\nBogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.getCapacity());
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}