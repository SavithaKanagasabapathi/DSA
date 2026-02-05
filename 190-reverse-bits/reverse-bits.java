class Solution {
    public int reverseBits(int n) {
        //TC-O(1) and SC-O(1), 32 times as 31 bits
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;//n%10
            n >>>= 1;//n/10, >>> three times is logical, >> two times is arithmetic
            //Logical>>> works well with negative num as they fill left side as 0's and not 1's
            reversed = (reversed << 1) | temp;//reversed*10+temp
        }
        return reversed;
    }
}