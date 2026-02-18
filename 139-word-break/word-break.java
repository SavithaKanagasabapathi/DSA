class Solution {
    //TC-O(N^3) and SC-O(N), substring for prefix, suffix will be O(n)
    //set instead of list as it is less complex
    public boolean wordBreak(String s, List<String> wordDict) {
        // Set<String> set = new HashSet<>(wordDict);
        // boolean[] dp = new boolean[s.length() + 1];
        // dp[0] = true;
        // for (int i = 1; i <= s.length(); i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (dp[j] && set.contains(s.substring(j, i))) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[s.length()];

        Set<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakHelper(s, set, memo);
    }

    private boolean wordBreakHelper(String s, Set<String> set, Map<String, Boolean> memo) {
        if (s.isEmpty()) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))) {//prefix
                if (wordBreakHelper(s.substring(i), set, memo)) {//suffix
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}