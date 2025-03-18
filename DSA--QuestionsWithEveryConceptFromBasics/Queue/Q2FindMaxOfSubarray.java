package Queue;

import java.util.*;

public class Q2FindMaxOfSubarray {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Stores indices of elements

        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements (maintain decreasing order)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current element index
            deque.offer(i);

            // Start adding max to result after the first k elements
            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Maximum of each subarray of size " + k + ": " + maxSlidingWindow(arr, k));
    }
}
