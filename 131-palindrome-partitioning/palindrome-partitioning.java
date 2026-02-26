class Solution {
    public List<List<String>> partition(String s) {
        //TC-O(N.2^N) and SC-O(N)//N opeartions and substring operations and 2^n to partition for aaa..
        List<List<String>> result = new ArrayList<>();
        backtrack(result, s, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<List<String>> result, String s, List<String> list, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
            //if u just give list, it will be empty 
            //as it got backtracked and removed, so create copy of list 
            //For backtracking, remember start>=length, copy of list and return
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                list.add(s.substring(start, end + 1));
                backtrack(result, s, list, end + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}