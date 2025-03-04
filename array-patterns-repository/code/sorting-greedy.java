import java.util.Arrays;

public class SortingGreedy {
    // Example: Assign Cookies (Leetcode 455)
    public static int findContentChildren(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int i = 0, j = 0;
        while (i < greed.length && j < cookies.length) {
            if (cookies[j] >= greed[i]) i++; // Assign cookie to child
            j++; // Move to next cookie
        }
        return i; // Number of children satisfied
    }

    public static void main(String[] args) {
        int[] greed = {1, 2, 3};
        int[] cookies = {1, 1};
        System.out.println(findContentChildren(greed, cookies)); // Output: 1
    }
}
