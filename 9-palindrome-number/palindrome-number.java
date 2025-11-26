class Solution {
    public boolean isPalindrome(int x) {
        int reverseX = 0;
        int temp = x;
        while (temp > 0) {
            reverseX = reverseX * 10 + (temp % 10);
            temp = temp / 10;
        }
        return x == reverseX;
    }
}