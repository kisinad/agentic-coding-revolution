import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    
    /**
     * Generate Fibonacci sequence up to n terms
     * @param n The number of terms to generate
     * @return List containing the Fibonacci sequence
     */
    public static List<Integer> fibonacci(int n) {
        // Handle edge cases
        if (n <= 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(0);
            return sequence;
        } else if (n == 2) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(0);
            sequence.add(1);
            return sequence;
        }
        
        // Initialize sequence with first two terms
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(1);
        
        // Generate remaining terms
        for (int i = 2; i < n; i++) {
            int nextTerm = sequence.get(i - 1) + sequence.get(i - 2);
            sequence.add(nextTerm);
        }
        
        return sequence;
    }
    
    /**
     * Main method to demonstrate the Fibonacci function
     */
    public static void main(String[] args) {
        // Test the function with different values
        System.out.println("Fibonacci(0): " + fibonacci(0));
        System.out.println("Fibonacci(1): " + fibonacci(1));
        System.out.println("Fibonacci(2): " + fibonacci(2));
        System.out.println("Fibonacci(10): " + fibonacci(10));
        System.out.println("Fibonacci(15): " + fibonacci(15));
    }
}

// First-generation models could generate such functions 
// but struggled with complex algorithms or domain-specific code
