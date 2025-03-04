Concept

A Monotonic Stack is a stack that maintains its elements in either increasing or decreasing order. It is useful for efficiently solving problems that involve finding the next greater or smaller element in an array.

When to Use?

Finding the next greater/smaller element in an array.
Processing elements in a non-decreasing or non-increasing order.
Used in histogram-based problems, stock span problems, and range queries.
### Template Code
```java
import java.util.Stack;

public class MonotonicStack {
    public static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
```
### Example Problems

Leetcode 739 - Daily Temperatures
Leetcode 496 - Next Greater Element I
Leetcode 901 - Online Stock Span
Leetcode 84 - Largest Rectangle in Histogram
