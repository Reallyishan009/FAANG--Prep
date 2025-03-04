# Binary Search

Binary search is used to efficiently find an element in a sorted array in O(log N) time.

## When to Use?

- Searching in a sorted array
- Finding the lower/upper bound
- Finding peak elements

## Template Code
```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}