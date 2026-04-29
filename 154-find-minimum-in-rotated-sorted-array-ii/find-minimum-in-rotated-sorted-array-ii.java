class Solution {
    public int findMin(int[] nums) {
        //TC-O(logn) and n in worst case and SC-O(1)
        //if we consider mid and right, in all scenarios it will work
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}