class Solution {
    public String longestPalindrome(String s) {
        //TC-O(N^2) and SC-O(N^2)
        //if single char-true, 2 chars if same i,j-true, if >3, center char should be true
        // int n = s.length(), maxLen = 0, start = 0;
        // boolean[][] dp = new boolean[n][n];
        // for (int len = 1; len <= n; len++) {//length-1 to n
        //     for (int i = 0; i <= n - len; i++) {//loop every char
        //         int j = i + len - 1;
        //         if (s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1])) {
        //             //if len 3, center should be true, i and j have to be same
        //             dp[i][j] = true;
        //             if (len > maxLen) {
        //                 maxLen = len;
        //                 start = i;
        //             }
        //         }
        //     }
        // }
        // return s.substring(start, start + maxLen);

        //TC-O(N^2) and SC-O(1)
        //Expand from center
        //Don't create many strings and many substring, just deal with length and start
        int n = s.length(), start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int oddLen = expand(s, i, i);//odd
            int evenLen = expand(s, i, i + 1);//even
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {//if new len is greater than old palindrome length
                start = i - (len - 1) / 2;
                end = i + (len / 2);
                //i is in middle, so start will be i-len/2 but for odd len only it will work, 
                //so i-(len-1)/2 and for end i+len/2
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int start, int end) {//expand from center
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;//after while start will be -1, end will be n, 
        //so (end-1)-(start+1)+1=end-1-start-1+1=end-start-1
        //even-abba
        //odd-abcba
        //here center char will check left and right upto limit and return count
    }
}