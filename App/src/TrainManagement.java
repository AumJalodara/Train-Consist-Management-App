import java.util.*;

public class TrainManagement {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("=======================================\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // Add IDs (including duplicates)
        bogies.add("B101");
        bogies.add("B102");
        bogies.add("B103");
        bogies.add("B101"); // duplicate
        bogies.add("B102"); // duplicate

        // Display bogies
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}