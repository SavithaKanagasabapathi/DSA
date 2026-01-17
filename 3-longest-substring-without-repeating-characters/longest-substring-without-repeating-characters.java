class Solution {
    public int lengthOfLongestSubstring(String s) {
        //TC-O(n) and SC-O(min(m,n))
        //n is length of string and m is unique size of the char map (e.g., 128 for ASCII)
        //if n is 1000 but only having a's and b's, O(m)
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {//If duplicate, move left
                left = Math.max(left, map.get(c) + 1);//Eg., abba
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}