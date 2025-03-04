
---

        ### **2. Add Java Code Implementations (`code/` folder)**
Create a Java file for each pattern inside the `code/` folder.

#### **sliding-window.java**
        ```java
public class SlidingWindow {
    public static int maxSumSubarray(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++)
            windowSum += arr[i];

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSubarray(arr, k)); // Output: 9
    }
}
