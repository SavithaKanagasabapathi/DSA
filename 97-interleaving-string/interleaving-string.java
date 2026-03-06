class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //TC-O(M.N) and SC-O(M.N)
        // if (s1.length() + s2.length() != s3.length()) {
        //     return false;
        // }
        // int m = s1.length(), n = s2.length();
        // boolean[][] dp = new boolean[m + 1][n + 1];//dp i,j tells no. of chars done/checked
        // dp[0][0] = true;//two empty string form empty s3
        // for (int i = 1; i <= m; i++) {//by this fill first row and column
        //     dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        //     //check s1 with s3, if i-1 count true only i can also be true
        // }
        // for (int j = 1; j <= n; j++) {
        //     dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);//sameway check s2 with s3
        // }
        // for (int i = 1; i <= m; i++) {//start with length 1
        //     for (int j = 1; j <= n; j++) {
        //         dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
        //                 || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        //         //here i,j are length checked, s3 char will have s1 and s2 mixed
        //         //so check s1/s2 char with s3 char length of i+j, if i=2,j=1, 
        //         //In s3-s1 chars 2 and s2 char 1 present already, so check next number that is i+j-1, 
        //         //-1 is for index, i-1, j-1 also for that index
        //     }
        // }
        // return dp[m][n];

        //TC-O(M.N) and SC-O(N)
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // Ensure s2 is the shorter string to minimize space
        if (s2.length() > s1.length()) {
            return isInterleave(s2, s1, s3);
        }
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {//s2 with s3
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            // Update dp[0] for the current row, s1 with s3
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                // 1. The OLD dp[j] (which is dp[i-1][j] from the row above)
                // 2. The NEW dp[j-1] (which is the cell to the left in the current row)
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n];
    }
}