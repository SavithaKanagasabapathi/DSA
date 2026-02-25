class Solution {
    public String minWindow(String s, String t) {
        //TC-O(S+T)and SC-O(S+T)
        //fill window with target char and with exact freq, left++ to shrink, move right++ to get min
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, required = 0, formed = 0;
        int[] result = { -1, 0, 0 };//length, start, end
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        required = target.size();
        while (right < s.length()) {
            char rightTemp = s.charAt(right);
            window.put(rightTemp, window.getOrDefault(rightTemp, 0) + 1);
            if (target.containsKey(rightTemp) && window.get(rightTemp).equals(target.get(rightTemp))) {
                //map.get() will give Integer and not int, Integer caches -128to127
                //if char comes 130 times, even if they are same also, it gives false
                //so give .intValue() or .equals()
                formed++;//if both target and window freq matched, then increment
            }
            while (left <= right && formed == required) {
                char leftTemp = s.charAt(left);
                if (result[0] == -1 || right - left < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
                window.put(leftTemp, window.get(leftTemp) - 1);
                if (target.containsKey(leftTemp) && window.get(leftTemp) < target.get(leftTemp)) {
                    formed--;//if window is AAA but target is AA, if window freq<target, decrement
                }
                left++;//Shrink
            }
            right++;//Expand
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}