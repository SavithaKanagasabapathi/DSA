class Solution {
    public int climbStairs(int n) {
        //Recursion - TC-O(2^N) and SC-O(N)
        //Memo with Recursion - TC-O(N) and SC-O(N)
        // int[] memo = new int[n + 1];
        // return helper(n, memo);

        //DP[Array] - TC-O(N) and SC-O(N)
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

        //DP with variables - TC-O(N) and SC-O(1)
        // if (n <= 2) {
        //     return n;
        // }
        // int first = 1, second = 2, third = 0;
        // for (int i = 3; i <= n; i++) {
        //     third = first + second;
        //     first = second;
        //     second = third;
        // }
        // return third;
    }

    private int helper(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return helper(n - 1, memo) + helper(n - 2, memo);
    }
}