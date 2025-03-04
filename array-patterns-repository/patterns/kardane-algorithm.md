Concept

Kadane’s Algorithm is an efficient way to find the maximum sum subarray in an array. It reduces the brute-force O(N²) approach to O(N) by maintaining a running sum and updating the maximum encountered so far.

When to Use?

Finding the maximum sum contiguous subarray.
Solving variations like maximum circular subarray sum.
### Template Code

```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0], currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}

```

### Example Problems

Leetcode 53 - Maximum Subarray
Leetcode 918 - Maximum Sum Circular Subarray
Leetcode 152 - Maximum Product Subarray
