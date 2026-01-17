class Solution {
    public int trap(int[] height) {
        //TC-O(n) and SC-O(1)
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, totalWater = 0;
        while (left < right) {
            //Process less height
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {//calc leftMax
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];//Formula max-current height
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}