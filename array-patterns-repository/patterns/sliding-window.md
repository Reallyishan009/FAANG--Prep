# Sliding Window Pattern

## Concept  
The sliding window technique is used to reduce the time complexity from O(N²) to O(N) for problems involving contiguous subarrays.

## When to Use?  
- Finding subarrays with max/min sum, length, etc.
- Finding longest/shortest substring with a given property.

## Template Code
```java
public int maxSumSubarray(int[] arr, int k) {
    int windowSum = 0, maxSum = 0;
    for (int i = 0; i < k; i++) 
        windowSum += arr[i];  // Initialize window

    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k]; // Slide window
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
