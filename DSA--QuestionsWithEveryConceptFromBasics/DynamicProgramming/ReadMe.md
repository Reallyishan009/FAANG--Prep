# Dynamic Programming in Java (DSA)

Dynamic Programming (DP) is a powerful algorithmic paradigm that breaks complex problems into simpler overlapping subproblems and solves each subproblem just once, storing the results to avoid redundant calculations.

## Core Principles of Dynamic Programming

1. **Optimal Substructure**: The optimal solution to the problem contains optimal solutions to its subproblems.
2. **Overlapping Subproblems**: The same subproblems are solved multiple times when using a naive recursive approach.

## How Dynamic Programming Works

DP algorithms typically follow these steps:

1. **Break down** the problem into smaller subproblems
2. **Memorize** solutions to subproblems (memoization or tabulation)
3. **Reuse** stored solutions instead of recalculating them
4. **Build** the final solution from these saved results

## Approaches to Dynamic Programming

### 1. Memoization (Top-Down)
```java
// Fibonacci with memoization
public int fib(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return fibMemoized(n, memo);
}

private int fibMemoized(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    
    memo[n] = fibMemoized(n - 1, memo) + fibMemoized(n - 2, memo);
    return memo[n];
}
```

### 2. Tabulation (Bottom-Up)
```java
// Fibonacci with tabulation
public int fib(int n) {
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n];
}
```

## Real-World Example: Knapsack Problem

Imagine you're a thief with a knapsack that can hold a maximum weight of W. You have n items, each with a weight and value. You want to maximize the value you steal without exceeding the weight limit.

### Visual Representation of the 0/1 Knapsack Problem:

Let's say we have:
- Knapsack capacity: 7 kg
- Items: [(value=1, weight=1), (value=4, weight=3), (value=5, weight=4), (value=7, weight=5)]

We build a table where rows represent items and columns represent weights from 0 to capacity:

```
    0  1  2  3  4  5  6  7  (Weight)
0   0  0  0  0  0  0  0  0
1   0  1  1  1  1  1  1  1
2   0  1  1  4  5  5  5  5
3   0  1  1  4  5  6  6  9
4   0  1  1  4  5  7  8  9
(Items)
```

Each cell dp[i][j] represents the maximum value achievable using the first i items and with a weight limit of j.

### Java Implementation:

```java
public int knapsack(int[] values, int[] weights, int capacity) {
    int n = values.length;
    int[][] dp = new int[n + 1][capacity + 1];
    
    // Build table in bottom-up manner
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            if (weights[i-1] <= w) {
                // Max of taking the item or not taking it
                dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
            } else {
                // Can't take this item due to weight constraint
                dp[i][w] = dp[i-1][w];
            }
        }
    }
    
    return dp[n][capacity];
}
```

## Common Dynamic Programming Patterns

1. **Linear Sequence DP**: Each state depends on previous states (like Fibonacci)
2. **Two-Dimensional Grid DP**: Problems on grids or matrices
3. **Interval DP**: Problems dealing with intervals like matrix chain multiplication
4. **Tree DP**: DP on tree structures
5. **State Compression DP**: Using bits to represent states
6. **Digit DP**: Problems dealing with digit properties

## Top Dynamic Programming Questions for Interviews

### General DP Interview Questions
1. **Fibonacci Numbers**: Calculate the nth Fibonacci number
2. **Coin Change**: Find the minimum number of coins to make a given amount
3. **Longest Increasing Subsequence**: Find the length of the longest subsequence in which elements are in ascending order
4. **0/1 Knapsack Problem**: Maximize value given weight constraints
5. **Edit Distance**: Find minimum operations to convert one string to another
6. **Longest Common Subsequence**: Find the longest subsequence common to two sequences
7. **Maximum Subarray Sum**: Find the contiguous subarray with the largest sum
8. **Minimum Path Sum**: Find the path with minimum sum in a grid
9. **Climbing Stairs**: Count ways to climb n stairs taking 1 or 2 steps at a time
10. **Rod Cutting**: Maximize profit by cutting a rod of length n
11. **Palindrome Partitioning**: Partition string such that each part is a palindrome
12. **Partition Equal Subset Sum**: Determine if array can be partitioned into two equal sum subsets
13. **House Robber**: Maximize money stolen without robbing adjacent houses
14. **Maximum Product Subarray**: Find contiguous subarray with largest product
15. **Unique Paths**: Count paths from top-left to bottom-right in a grid

### Top DP Questions Asked in FAANG Companies

1. **Word Break**: Determine if a string can be segmented into dictionary words
2. **Best Time to Buy/Sell Stock**: Maximize profit with various constraints
3. **Decode Ways**: Count ways to decode a message
4. **Regular Expression Matching**: Implement regex matching with support for '.' and '*'
5. **Longest Palindromic Substring**: Find the longest palindromic substring
6. **Wildcard Matching**: Implement wildcard pattern matching with '?' and '*'
7. **Distinct Subsequences**: Count distinct subsequences of one string in another
8. **Interleaving String**: Check if third string is interleaving of first two
9. **Burst Balloons**: Maximize coins by bursting balloons strategically
10. **Target Sum**: Find ways to assign + and - signs to array elements to reach target
11. **Shortest Common Supersequence**: Find the shortest string that has both strings as subsequences
12. **Longest String Chain**: Find longest chain of words where each word differs by one character
13. **Stone Game variations**: Various game theory problems
14. **Minimum Cost Tree From Leaf Values**: Build tree with minimum non-leaf node sum
15. **Count Different Palindromic Subsequences**: Count distinct palindromic subsequences

## Let's Solve a Top DP Problem: Longest Increasing Subsequence (LIS)

The LIS problem asks for the length of the longest subsequence in which elements are in ascending order.

### Example:
Input: [10, 9, 2, 5, 3, 7, 101, 18]
Output: 4 (The LIS is [2, 3, 7, 101])

### Visual Explanation of LIS:
For the array [10, 9, 2, 5, 3, 7, 101, 18]:

```
Index:    0  1  2  3  4  5  6   7
Array:    10 9  2  5  3  7  101 18
DP value: 1  1  1  2  2  3  4   4
```

DP[i] represents the length of the LIS ending at index i.

### Java Implementation:

```java
public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) return 0;
    
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1); // Each element alone is an LIS of length 1
    int maxLength = 1;
    
    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        maxLength = Math.max(maxLength, dp[i]);
    }
    
    return maxLength;
}
```

Dynamic Programming's true power lies in its ability to optimize solutions by avoiding redundant calculations, making it an essential technique for solving complex algorithmic problems efficiently.