class Solution {
    public int search(int[] nums, int target) {
        //TC-O(log n) and SC-O(1)
        //if target given, return in mid, so left<=right and return default outside
        //already mid and target checked, so in later loops with mid and target don't include =
        //else in other places, use =
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {//left sorted
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//right sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}