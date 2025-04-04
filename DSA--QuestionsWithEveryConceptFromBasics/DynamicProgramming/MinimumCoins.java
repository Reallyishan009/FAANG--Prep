package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int n = 18;
        int A[] = {7, 5, 1};
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = mincoin(n, A, dp);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static int mincoin(int n, int A[], int dp[]) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (n - A[i] >= 0) {
                int subcoin = mincoin(n - A[i], A, dp);
                
                if (subcoin != Integer.MAX_VALUE) {
                    ans = Math.min(ans, subcoin + 1);
                }
            }
        }

        return dp[n] = ans;
    }
}
