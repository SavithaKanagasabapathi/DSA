class Solution {
    public int[] countBits(int n) {
        //TC-O(N) and SC-O(N)
        int[] dp = new int[n + 1];
        dp[0] = 0;
        //1-01-1+dp[0(1-1)]=1
        //2-10-1+dp[0(2-2)]=1
        //3-11-1+dp[1(3-2)]=2
        //4-100-1+dp[0(4-4)]=1
        //5-101-1+dp[1(5-4)]=2
        //6-110-1+dp[2(6-4)]=2
        //i=1+dp[i-recentTwoPower]
        int twoPowers = 1;
        for (int i = 1; i <= n; i++) {
            if (twoPowers * 2 == i) {
                twoPowers = i;
            }
            dp[i] = 1 + dp[i - twoPowers];
        }
        return dp;
    }
}