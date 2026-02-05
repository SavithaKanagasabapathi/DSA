class Solution {
    //TC-O(N) and SC-O(1)
    public int missingNumber(int[] nums) {
        //XOR upto n and nums - remaining xor is missing number
        int xor = nums.length;//add last number as loop ends before length
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
    //if [3,0,1], length is 3
    //0^1^2^3^3^0^1 = 2
}