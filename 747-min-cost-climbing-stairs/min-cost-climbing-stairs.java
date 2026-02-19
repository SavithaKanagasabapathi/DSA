class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //TC-O(N) and SC-O(N)
        //steps - 1 or 2, start from 0 or 1
        // int n = cost.length;
        // int[] dp = new int[n];
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        // for (int i = 2; i < n; i++) {
        //     dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
        // }
        // return Math.min(dp[n - 1], dp[n - 2]);//top floor n, so min of n-1 and n-2

        //TC-O(N) and SC-O(1)
        //steps - 1 or 2, start from 0 or 1
        int n = cost.length, prev2 = cost[0], prev1 = cost[1], current = 0;
        for (int i = 2; i < n; i++) {
            current = cost[i] + Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);//top floor n, so min of n-1 and n-2
    }
}