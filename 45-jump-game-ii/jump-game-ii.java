class Solution {
    //TC-O(N) and SC-O(1)
    //minimum jumps to reach last index
    public int jump(int[] nums) {
        int reach = 0, jumps = 0, currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {//upto last second, 
            //as we can able to reach last index, only min jumps needed
            reach = Math.max(reach, i + nums[i]);//from i, if we need to move nums[i] - i+nums[i]
            if (i == currentEnd) {//first time jump, next time if u reach currentEnd, jump
                jumps++;//need to jump
                currentEnd = reach;
                if (reach >= nums.length - 1) {
                    break;//if we already reached our reach or farther, so break
                }
            }
        }
        return jumps;
    }
}