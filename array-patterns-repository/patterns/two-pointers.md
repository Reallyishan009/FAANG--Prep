The Two Pointers technique is used to iterate through an array efficiently by maintaining two pointers—one starting from the left and the other from the right (or both moving within the array). This technique is commonly used to solve problems with sorted arrays, linked lists, and strings.

## When to Use?

- Finding pairs in a sorted array.
- Removing duplicates in place.
- Checking for palindromes.
- Merging two sorted arrays.

## Template Code

```java
public boolean hasPair(int[] arr, int target) {
    Arrays.sort(arr); 
    int left = 0, right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) return true;
        else if (sum < target) left++;
        else right--;
    }
    return false;
}
```
## Example Problems

- Leetcode 167 - Two Sum II
- Leetcode 125 - Valid Palindrome
- Leetcode 11 - Container With Most Water
- Leetcode 345 - Reverse Vowels of a String

