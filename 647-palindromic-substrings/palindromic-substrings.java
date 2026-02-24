class Solution {
    public int countSubstrings(String s) {
        //TC-O(N^2) and SC-O(N^2)
        //if single char-true, 2 chars if same i,j-true, if >3, center char should be true
        // int n = s.length(), count = 0;
        // boolean[][] dp = new boolean[n][n];
        // for (int len = 1; len <= n; len++) {//length-1 to n
        //     for (int i = 0; i <= n - len; i++) {//loop every char
        //         int j = i + len - 1;
        //         if (s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1])) {
        //             //if len 3, center should be true, i and j have to be same
        //             dp[i][j] = true;
        //             count++;
        //         }
        //     }
        // }
        // return count;

        //TC-O(N^2) and SC-O(1)
        //Expand from center
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            count += expand(s, i, i);//odd
            count += expand(s, i, i + 1);//even
        }
        return count;
    }

    private int expand(String s, int start, int end) {//expand from center
        int count = 0, n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
        //even-abba
        //odd-abcba
        //here center char will check left and right upto limit and return count
    }
}