import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainManagement {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    // Method for filtering bogies using Stream API
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold) // key condition
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("=========================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("General", 90));

        int threshold = 70;

        // Apply stream filtering
        List<Bogie> filteredBogies = filterBogiesByCapacity(bogies, threshold);

        // Display filtered bogies
        System.out.println("Bogies with capacity greater than " + threshold + ":\n");

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        // Verify original list unchanged
        System.out.println("\nOriginal Bogie List:");
        bogies.forEach(System.out::println);
    }
}