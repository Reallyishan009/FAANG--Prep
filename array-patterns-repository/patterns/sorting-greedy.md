Concept

Sorting is a fundamental technique in problem-solving. When combined with the Greedy approach, it helps in making locally optimal choices that lead to globally optimal solutions.

When to Use?

Problems where ordering elements simplifies decisions.
Greedy selection of elements based on sorted order.
Optimization problems involving minimization/maximization.

### Template Code (Sorting Approach)
```java
import java.util.Arrays;

public void sortArray(int[] nums) {
    Arrays.sort(nums); // O(N log N) using QuickSort/MergeSort internally
}
```

### Template Code (Greedy Approach)
```java
import java.util.Arrays;

public int minSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int num : nums) {
        sum += num; // Greedy selection
    }
    return sum;
}
```
### Example Problems

Leetcode 455 - Assign Cookies
Leetcode 135 - Candy
Leetcode 406 - Queue Reconstruction by Height
Leetcode 1029 - Two City Scheduling
