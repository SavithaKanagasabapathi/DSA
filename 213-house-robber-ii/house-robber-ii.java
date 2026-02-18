class Solution {
    //TC-O(N) and SC-O(1)
    //see from current to left
    //rob alternate house so i+(i-2)
    //max((i+(i-2)), i-1), because Rob/skip the house 
    //Rob it: You take the money at nums[i] and add it to the best loot from two houses ago (prev2).
    //Skip it: Because the house right before it had much more money.
    //As it is circle, first and last is neighbours, so from first to end-1 and from second to last
    //return max of those
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int first = robHelper(nums, 0, n - 1);
        int last = robHelper(nums, 1, n);
        return Math.max(first, last);
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev2Dp = 0, prev1Dp = 0, currentDp = 0;
        for (int i = start; i < end; i++) {
            currentDp = Math.max(nums[i] + prev2Dp, prev1Dp);
            prev2Dp = prev1Dp;
            prev1Dp = currentDp;
        }
        return currentDp;
    }
}