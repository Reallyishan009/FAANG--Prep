package Stacks;

import java.util.Stack;

public class Q5NearestGreatestElement {
    public static int[] nearestGreatestElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop(); 
            }
            
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]); 
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nearestGreatestElement(arr);

        System.out.print("Nearest Smaller Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
