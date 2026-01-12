class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Majority Vote Algorithm or Voting Algorithm
        //Used to find the majority element that appears more than n/2 times
        //Check if majority elements always exist in question
        //TC-O(n) and SC-O(1)
        int count = 0;
        int majorityNum = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityNum = num;
            }
            count += (num == majorityNum) ? 1 : -1;
        }
        //if the problem doesn't guarantee a majority exists
        // if (isMajority(nums, majorityNum)) {
        //     return majorityNum;
        // }
        return majorityNum;
    }

    public boolean isMajority(int[] nums, int number) {
        int count = 0;
        for (int num : nums) {
            if (num == number) {
                count++;
            }
        }
        return count > nums.length / 2;
    }
}