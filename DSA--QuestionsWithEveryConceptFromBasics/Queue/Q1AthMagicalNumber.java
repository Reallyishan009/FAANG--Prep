package Queue;

import java.util.*;

public class Q1AthMagicalNumber {
    public static String findAthPerfectNumber(int A) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");

        String result = "";
        
        for (int i = 0; i < A; i++) {
            result = queue.poll(); // Get the front element
            queue.add(result + "1"); // Generate next perfect numbers
            queue.add(result + "2");
        }

        return result;
    }

    public static void main(String[] args) {
        int A = 5; // Example: Find the 5th perfect number
        System.out.println("The " + A + "th perfect number is: " + findAthPerfectNumber(A));
    }
}
