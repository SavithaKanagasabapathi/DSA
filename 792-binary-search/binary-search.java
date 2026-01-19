class Solution {
    public int search(int[] nums, int target) {
        //Binary Search TC-O(log n) and SC-O(1)
        int left = 0, right = nums.length - 1;
        while (left <= right) {//If only one number, left<=right
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}