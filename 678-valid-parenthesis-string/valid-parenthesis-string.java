class Solution {
    public boolean checkValidString(String s) {
        //TC-O(N) and SC-O(1)
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--;//)
                maxOpen++;//(
            }
            if (maxOpen < 0) {
                return false;//it can't be negative, may be more )
            }
            if (minOpen < 0) {
                minOpen = 0;//it can be negative, maek it as 0
            }
        }
        return minOpen == 0;//if minOpen is 0, return true
    }
}