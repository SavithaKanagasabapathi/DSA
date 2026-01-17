class Solution {
    public int maxArea(int[] height) {
        //TC-O(n) and SC-O(1)
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int hgt = Math.min(height[left], height[right]);
            int area = hgt * width;
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {//we don't want less hgt, so which side is less-move
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}