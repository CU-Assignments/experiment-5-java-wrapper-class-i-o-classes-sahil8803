import java.util.*;

public class SumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for input
        System.out.println("Enter some numbers (separated by spaces):");
        String input = scanner.nextLine(); // Read the whole input line

        // Split the input into individual numbers
        String[] numbers = input.split(" ");
        
        int sum = 0; // Variable to store the sum

        // Convert each number from text to integer and add it to the sum
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        // Display the final sum
        System.out.println("Total Sum: " + sum);

        scanner.close(); // Close the scanner
    }
}
