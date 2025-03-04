import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);  // Base case for sum == k

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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -2, 2, 1};
        int k = 3;
        System.out.println(subarraySum(nums, k)); // Output: 3
    }
}
