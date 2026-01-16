class Solution {
    public int firstMissingPositive(int[] nums) {
        //TC-O(n) and SC-O(1) as required in question
        //we are not using sort or map
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                //If 3 is in 0 index, 3!=index 2, swap 3 with index 2
                //If swapped num is 2, it should be again swapped so while loop
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {//If 1 is not in 0, return 1
                return i + 1;
            }
        }
        return length + 1;//If everything in place, return n+1
    }
}