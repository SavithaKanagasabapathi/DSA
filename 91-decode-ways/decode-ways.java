class Solution {
    public int numDecodings(String s) {
        //TC-O(N) and SC-O(N)
        // if (s == null || s.length() == 0 || s.charAt(0) == '0') {
        //     return 0;
        // }
        // int n = s.length();
        // int[] dp = new int[n + 1];
        // dp[0] = 1;//if empty string, only 1 way to decode
        // dp[1] = 1;//1-9 only so 1 way
        // for (int i = 2; i <= n; i++) {
        //     int oneDigit = Integer.parseInt(s.substring(i - 1, i));
        //     int twoDigits = Integer.parseInt(s.substring(i - 2, i));
        //     if (oneDigit >= 1) {//no 0 for oneDigit
        //         dp[i] += dp[i - 1];//count i as i+(i-1) as u need to include 1st digit way
        //     }
        //     if (twoDigits >= 10 && twoDigits <= 26) {//should be 10-26
        //         dp[i] += dp[i - 2];//count i as i+(i-2) as u need to include i-2's digit way 
        //         //as we are considering two digits here so i-2
        //     }
        // }
        // return dp[n];

        //TC-O(N) and SC-O(1)
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int prev2 = 1, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = 0;//every loop current should be 0
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (oneDigit >= 1) {//no 0 for oneDigit
                current += prev1;//count i as i+(i-1) as u need to include 1st digit way
            }
            if (twoDigits >= 10 && twoDigits <= 26) {//should be 10-26
                current += prev2;//count i as i+(i-2) as u need to include i-2's digit way 
                //as we are considering two digits here so i-2
            }
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}