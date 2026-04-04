class Solution {
    public List<String> restoreIpAddresses(String s) {
        //TC-O(3^4) and SC-O(1), time also 3^4 is constant for all i/ps so TC-O(1)
        //len 1-3 for 4 segments
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> segments, List<String> result) {
        if (segments.size() == 4 && start == s.length()) {
            result.add(String.join(".", segments));
            return;
        }
        for (int len = 1; len <= 3; len++) {
            if ((start + len) > s.length()) {
                return;
            }
            String segment = s.substring(start, start + len);
            if ((segment.startsWith("0") && segment.length() > 1)
                    || (segment.length() == 3 && Integer.parseInt(segment) > 255)) {
                //if 0 is segment allow but segment startswith 0 and its length is >1
                //segments with leading zeros - not needed
                //if 3 digits segment, >255 - not needed
                continue;
            }
            segments.add(segment);
            backtrack(s, start + len, segments, result);
            segments.remove(segments.size() - 1);
        }
    }
}