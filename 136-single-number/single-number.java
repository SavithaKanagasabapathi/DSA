class Solution {
    public int singleNumber(int[] nums) {
        //TC-O(N) and SC-O(1)
        //1^1=0, 1^0=1, 0^1=1, 0^0=0
        //so here 2 times if same number come, it will be 0, unique number will be returned
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}