class Solution {
    public int hammingWeight(int n) {
        //TC-0(1) k times, where k is no. of 1's present and SC-O(1)
        //If n=3 - 11, 
        //11&10=10
        //10&01=00
        //2 times loop, so return 2 1's
        // int result = 0;
        // while (n != 0) {
        //     n = n & (n - 1);
        //     result++;
        // }
        // return result;

        //TC-0(1) 32 times, as 31 bits for every num and SC-O(1)
        //If n=3 - 11
        //11&01=01, n>>1 so 1
        //1&1=1
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {//wrap n&1 in brackets or else it will check with ==1 and give error
                result++;
            }
            n >>= 1;//move 1 digit right, so last digit will go
        }
        return result;
    }
}