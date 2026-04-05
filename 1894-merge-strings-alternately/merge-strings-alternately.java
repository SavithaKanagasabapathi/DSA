class Solution {
    public String mergeAlternately(String word1, String word2) {
        //TC-O(N+M) and SC-O(N+M)
        int n = word1.length(), m = word2.length(), maxLength = Math.max(n, m);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            if (i < n) {
                sb.append(word1.charAt(i));
            }
            if (i < m) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}