class Solution {
    //TC-O(N) and SC-O(1)
    //Greedily move eachstep to their farthest
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {//if we came far than reach, somewhere stuck so return false
                return false;
            }
            reach = Math.max(reach, i + nums[i]);//from i, if we need to move nums[i] - i+nums[i]
            if (reach >= nums.length - 1) {
                return true;//if we already reached our reach or farther, return true 
                //as we can able to reach last index by any way (1step/2's)
            }
        }
        return true;//if we come here all nums reached, return true
    }
}