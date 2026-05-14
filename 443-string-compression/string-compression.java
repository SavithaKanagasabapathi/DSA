class Solution {
    public int compress(char[] chars) {
        //TC-O(n) and SC-O(1)
        int count = 1, write = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[write++] = chars[i - 1];
                if (count > 1) {
                    char[] freq = String.valueOf(count).toCharArray();
                    for (char c : freq) {
                        chars[write++] = c;
                    }
                    count = 1;
                }
            }
        }
        return write;
        //If 1 loop wanted, use StringBuilder and append and SC-O(N)
    }
}