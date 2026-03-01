class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //create dp of longest common subsequence of length 1 to n
        //dp[0][0] will be 0 as longest common subsequence of length 0 of both texts will be 0
        //so create dp of size m+1, n+1, return dp[m][n] instead of dp[m-1][n-1] as LCS of length m,n
        //if both letters same, 1+previous m and n, if not max of i-1 or j-1 
        //as before letter of text1 and current letter can e same or before of text2 & current letter 

        //TC-O(M.N) and SC-O(M.N)
        // int m = text1.length(), n = text2.length();
        // int[][] dp = new int[m + 1][n + 1];
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // return dp[m][n];

        //In this optimization, we are not creating 2d array, just 1d array of smallest length
        //Every row starts with 0, so there's i-1 be 0, so keeping prevI as 0 before every j starts
        //Storing old i-1 values as temp and giving to prevI after setting new dp[j]

        //TC-O(M.N) and SC-O(Min(M.N))
        int m = text1.length(), n = text2.length();
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prevI = 0;//dp[i-1][j-1]
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];//here dp[j] is dp[i-1]
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = 1 + prevI;//1+dp[i-1][j-1]
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevI = temp;
            }
        }
        return dp[n];
    }
}
