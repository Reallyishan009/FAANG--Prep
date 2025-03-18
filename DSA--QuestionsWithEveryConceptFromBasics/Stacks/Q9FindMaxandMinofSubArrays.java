package Stacks;

import java.util.*;

public class Q9FindMaxandMinofSubArrays {

    // Function to compute Next Smaller Left (NSL)
    private static int[] getNSL(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return nsl;
    }

    // Function to compute Next Smaller Right (NSR)
    private static int[] getNSR(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nsr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nsr;
    }

    // Function to compute Next Greater Left (NGL)
    private static int[] getNGL(int[] arr) {
        int n = arr.length;
        int[] ngl = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            ngl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ngl;
    }

    // Function to compute Next Greater Right (NGR)
    private static int[] getNGR(int[] arr) {
        int n = arr.length;
        int[] ngr = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            ngr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ngr;
    }

    // Function to compute sum of (max - min) of all subarrays
    public static long sumOfMaxMinusMin(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr);
        int[] NSR = getNSR(arr);
        int[] NGL = getNGL(arr);
        int[] NGR = getNGR(arr);

        long sumMax = 0, sumMin = 0;

        // Compute contribution as min
        for (int i = 0; i < n; i++) {
            long left = i - NSL[i];
            long right = NSR[i] - i;
            sumMin += arr[i] * left * right;
        }

        // Compute contribution as max
        for (int i = 0; i < n; i++) {
            long left = i - NGL[i];
            long right = NGR[i] - i;
            sumMax += arr[i] * left * right;
        }

        return sumMax - sumMin;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println("Sum of (max - min) of all subarrays: " + sumOfMaxMinusMin(arr));
    }
}
