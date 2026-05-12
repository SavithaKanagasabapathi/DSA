class Solution {
    //TC-O(log10(x)) and SC-O(1)
    //loop upto x digits is same as log of base 10 
    //we are dividing x by 10 till it reaches 0 - log10(x)
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int temp = x % 10;//Last digit
            x /= 10;//Remove last digit as it is processed
            //Max Int: 2147483647, Min Int: -2147483648
            //If i/p is less than limits but reversed digit is greater than limits, so check 
            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 ||
                    (reversed == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            reversed = (reversed * 10) + temp;
        }
        return reversed;
    }
}