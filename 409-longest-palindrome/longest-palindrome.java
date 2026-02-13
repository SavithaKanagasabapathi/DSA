class Solution {
    //TC-O(N) and SC-O(1)
    //if any char comes again, count+2 and remove from set
    //if full set is empty, all are coming multiples of 2 times so got removed
    //if set is still having some chars, we can put any char in middle like aba, so +1
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count : count + 1;
    }
}