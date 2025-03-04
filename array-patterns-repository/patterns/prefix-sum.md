Concept

The Prefix Sum technique is used to preprocess cumulative sums in an array to quickly answer range sum queries and solve subarray problems efficiently.
It often works with hash maps to solve problems involving subarrays with a given sum in O(N) time complexity.

## When to Use?

Finding subarrays with a given sum.
Calculating range sums in O(1) after preprocessing.
Checking for subarrays divisible by K.
### Template Code

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixSumFreq = new HashMap<>();
    prefixSumFreq.put(0, 1);
    
    int sum = 0, count = 0;
    for (int num : nums) {
        sum += num;
        if (prefixSumFreq.containsKey(sum - k)) {
            count += prefixSumFreq.get(sum - k);
        }
        prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
    }
    return count;
}
```

### Example Problems

Leetcode 560 - Subarray Sum Equals K
Leetcode 303 - Range Sum Query - Immutable
Leetcode 974 - Subarray Sums Divisible by K
Leetcode 523 - Continuous Subarray Sum